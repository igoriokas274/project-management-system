$(document).ready( function () {
    const contactsTable = $('#contactTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        /*"serverSide": true,*/
        "ajax": "/api/contacts/list",
        "sAjaxDataProp": "",
        rowId: 'contactId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "contactId" },
            { "data": null,
                "string": "fullName",
                render: function ( data, type, row ) {
                    return data.firstName +' '+ data.lastName;
                }},
            { "data": "title" },
            { "data": "contactPhone" },
            { "data": "contactEmail" },
            { "data": "customer" },
            { "data": "supplier" },
            { "data": "closed" }
        ]
    });
    $('#contactTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            contactsTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    $('#deleteBtn').click( function () {
        var id = contactsTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'delete?id=' + id,
            success: function () {
                alert("Row id " + id + " deleted");
                contactsTable.row('.selected').remove().draw( false );
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });
    });
    $('.editBtn').on('click', function(event) {
        event.preventDefault();
        var id = contactsTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'update?id=' + id,
            success: function () {
                $.get(this.url, function (contacts, status) {
                    $('.contactFormUpdate #contactId').val(contacts.contactId);
                    $('.contactFormUpdate #firstName').val(contacts.firstName);
                    $('.contactFormUpdate #middleName').val(contacts.middleName);
                    $('.contactFormUpdate #lastName').val(contacts.lastName);
                    $('.contactFormUpdate #title').val(contacts.title);
                    $('.contactFormUpdate #contactEmail').val(contacts.contactEmail);
                    $('.contactFormUpdate #gender').val(contacts.gender);
                    $('.contactFormUpdate #contactPhone').val(contacts.contactPhone);
                    $('.contactFormUpdate #customerId').val(contacts.customerId);
                    $('.contactFormUpdate #supplierId').val(contacts.supplierId);
                    $('.contactFormUpdate #closed').val(contacts.closed);
                });
                $('.contactFormUpdate #updateModal').modal();
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });

    });
    $('.newBtn').on('click', function(event) {
        event.preventDefault();
        $('.contactFormCreate #firstName').val('');
        $('.contactFormCreate #middleName').val('');
        $('.contactFormCreate #lastName').val('');
        $('.contactFormCreate #title').val('');
        $('.contactFormCreate #contactEmail').val('');
        $('.contactFormCreate #gender').val('');
        $('.contactFormCreate #contactPhone').val('');
        $('.contactFormCreate #customerId').val('');
        $('.contactFormCreate #supplierId').val('');
        $('.contactFormCreate #closed').val('');
        $('.contactFormCreate #contactModalCreate').modal();
    });
});
