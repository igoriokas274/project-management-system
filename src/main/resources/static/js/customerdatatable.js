$(document).ready( function () {
    const customerTable = $('#customerTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        /*"serverSide": true,*/
        "ajax": "/api/customers/list",
        "sAjaxDataProp": "",
        rowId: 'customerId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "customerId" },
            { "data": "customerName" },
            /*{ "data": "createdBy" },
            { "data": "createdDate" },
            { "data": "lastModifiedBy" },
            { "data": "lastModifiedDate" },*/
            { "data": "closed" }
        ]
    });
    $('#customerTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            customerTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    $('#deleteBtn').click( function () {
        var id = customerTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'delete?id=' + id,
            success: function () {
                alert("Row id " + id + " deleted");
                customerTable.row('.selected').remove().draw( false );
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });
    });
    $('.editBtn').on('click', function(event) {
        event.preventDefault();
        var id = customerTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'update?id=' + id,
            success: function () {
                $.get(this.url, function (customers, status) {
                    $('.customerFormUpdate #customerId').val(customers.customerId);
                    $('.customerFormUpdate #customerName').val(customers.customerName);
                    $('.customerFormUpdate #customerRegistrationNumber').val(customers.customerRegistrationNumber);
                    $('.customerFormUpdate #customerVATNumber').val(customers.customerVATNumber);
                    $('.customerFormUpdate #closed').val(customers.closed);
                    $('.customerFormUpdate #addressLine1').val(customers.addressLine1);
                    $('.customerFormUpdate #addressLine2').val(customers.addressLine2);
                    $('.customerFormUpdate #city').val(customers.city);
                    $('.customerFormUpdate #zipCode').val(customers.zipCode);
                    $('.customerFormUpdate #country').val(customers.country);
                    $('.customerFormUpdate #contactPhone').val(customers.contactPhone);
                    $('.customerFormUpdate #contactEmail').val(customers.contactEmail);
                    $('.customerFormUpdate #bankName').val(customers.bankName);
                    $('.customerFormUpdate #bankAccount').val(customers.bankAccount);
                    $('.customerFormUpdate #bankCode').val(customers.bankCode);
                    $('.customerFormUpdate #swift').val(customers.swift);
                    $('.customerFormUpdate #currency').val(customers.currency);
                });
                $('.customerFormUpdate #updateModal').modal();
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });

    });
    $('.newBtn').on('click', function(event) {
        event.preventDefault();
        $('.customerFormCreate #customerName').val('');
        $('.customerFormCreate #customerRegistrationNumber').val('');
        $('.customerFormCreate #customerVATNumber').val('');
        $('.customerFormCreate #closed').val('');
        $('.customerFormCreate #addressLine1').val('');
        $('.customerFormCreate #addressLine2').val('');
        $('.customerFormCreate #city').val('');
        $('.customerFormCreate #zipCode').val('');
        $('.customerFormCreate #country').val('');
        $('.customerFormCreate #contactPhone').val('');
        $('.customerFormCreate #contactEmail').val('');
        $('.customerFormCreate #bankName').val('');
        $('.customerFormCreate #bankAccount').val('');
        $('.customerFormCreate #bankCode').val('');
        $('.customerFormCreate #swift').val('');
        $('.customerFormCreate #currency').val('');
        $('.customerFormCreate #customerModalCreate').modal();
    });
});
