$(document).ready( function () {
    const supplierTable = $('#supplierTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        /*"serverSide": true,*/
        "ajax": "/api/suppliers/list",
        "sAjaxDataProp": "",
        rowId: 'supplierId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "supplierId" },
            { "data": "supplierName" },
            { "data": "createdBy" },
            { "data": "createdDate" },
            { "data": "lastModifiedBy" },
            { "data": "lastModifiedDate" },
            { "data": "closed" }
        ]
    });
    $('#supplierTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            supplierTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    $('#deleteBtn').click( function () {
        var id = supplierTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'delete?id=' + id,
            success: function () {
                alert("Row id " + id + " deleted");
                supplierTable.row('.selected').remove().draw( false );
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });
    });
    $('.editBtn').on('click', function(event) {
        event.preventDefault();
        var id = supplierTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'update?id=' + id,
            success: function () {
                $.get(this.url, function (suppliers, status) {
                    $('.supplierFormUpdate #supplierId').val(suppliers.supplierId);
                    $('.supplierFormUpdate #supplierName').val(suppliers.supplierName);
                    $('.supplierFormUpdate #supplierRegistrationNumber').val(suppliers.supplierRegistrationNumber);
                    $('.supplierFormUpdate #supplierVATNumber').val(suppliers.supplierVATNumber);
                    $('.supplierFormUpdate #closed').val(suppliers.closed);
                    $('.supplierFormUpdate #addressLine1').val(suppliers.addressLine1);
                    $('.supplierFormUpdate #addressLine2').val(suppliers.addressLine2);
                    $('.supplierFormUpdate #city').val(suppliers.city);
                    $('.supplierFormUpdate #zipCode').val(suppliers.zipCode);
                    $('.supplierFormUpdate #country').val(suppliers.country);
                    $('.supplierFormUpdate #contactPhone').val(suppliers.contactPhone);
                    $('.supplierFormUpdate #contactEmail').val(suppliers.contactEmail);
                    $('.supplierFormUpdate #bankName').val(suppliers.bankName);
                    $('.supplierFormUpdate #bankAccount').val(suppliers.bankAccount);
                    $('.supplierFormUpdate #bankCode').val(suppliers.bankCode);
                    $('.supplierFormUpdate #swift').val(suppliers.swift);
                    $('.supplierFormUpdate #currency').val(suppliers.currency);
                });
                $('.supplierFormUpdate #updateModal').modal();
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });

    });
    $('.newBtn').on('click', function(event) {
        event.preventDefault();
        $('.supplierFormCreate #supplierName').val('');
        $('.supplierFormCreate #supplierRegistrationNumber').val('');
        $('.supplierFormCreate #supplierVATNumber').val('');
        $('.supplierFormCreate #closed').val('');
        $('.supplierFormCreate #addressLine1').val('');
        $('.supplierFormCreate #addressLine2').val('');
        $('.supplierFormCreate #city').val('');
        $('.supplierFormCreate #zipCode').val('');
        $('.supplierFormCreate #country').val('');
        $('.supplierFormCreate #contactPhone').val('');
        $('.supplierFormCreate #contactEmail').val('');
        $('.supplierFormCreate #bankName').val('');
        $('.supplierFormCreate #bankAccount').val('');
        $('.supplierFormCreate #bankCode').val('');
        $('.supplierFormCreate #swift').val('');
        $('.supplierFormCreate #currency').val('');
        $('.supplierFormCreate #supplierModalCreate').modal();
    });
});
