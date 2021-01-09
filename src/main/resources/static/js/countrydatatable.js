$(document).ready( function () {
    const countryTable = $('#countryTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        /*"serverSide": true,*/
        "ajax": "/api/countries/list",
        "sAjaxDataProp": "",
        rowId: 'countryId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "countryId" },
            { "data": "countryCode" },
            { "data": "countryName" },
            { "data": "closed" }
        ]
    });
    $('#countryTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            countryTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    $('#deleteBtn').click( function () {
        var id = countryTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'delete?id=' + id,
            success: function () {
                alert("Row id " + id + " deleted");
                countryTable.row('.selected').remove().draw( false );
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });
    });
    $('.editBtn').on('click', function(event) {
        event.preventDefault();
        var id = countryTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'update?id=' + id,
            success: function () {
                $.get(this.url, function (counties, status) {
                    $('.countryFormUpdate #countryId').val(counties.countryId);
                    $('.countryFormUpdate #countryCode').val(counties.countryCode);
                    $('.countryFormUpdate #countryName').val(counties.countryName);
                    $('.countryFormUpdate #closed').val(counties.closed);
                });
                $('.countryFormUpdate #updateModal').modal();
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });

    });
    $('.newBtn').on('click', function(event) {
        event.preventDefault();
        $('.countryFormCreate #countryId').val('');
        $('.countryFormCreate #countryCode').val('');
        $('.countryFormCreate #countryName').val('');
        $('.countryFormCreate #closed').val('');
        $('.countryFormCreate #countryModalCreate').modal();
    });
});
