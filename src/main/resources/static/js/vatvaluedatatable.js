$(document).ready( function () {
    const vatValueTable = $('#vatValuesTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        /*"serverSide": true,*/
        "ajax": "/api/vatvalues/list",
        "sAjaxDataProp": "",
        rowId: 'vatId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "vatId" },
            { "data": "vatValue" },
            { "data": "description" }
        ]
    });
    $('#vatValuesTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            vatValueTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    $('#deleteBtn').click( function () {
        var id = vatValueTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'delete?id=' + id,
            success: function () {
                alert("Row id " + id + " deleted");
                vatValueTable.row('.selected').remove().draw( false );
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });
    });
    $('.editBtn').on('click', function(event) {
        event.preventDefault();
        var id = vatValueTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'update?id=' + id,
            success: function () {
                $.get(this.url, function (vatValues, status) {
                    $('.vatValueFormUpdate #vatId').val(vatValues.vatId);
                    $('.vatValueFormUpdate #vatValue').val(vatValues.vatValue);
                    $('.vatValueFormUpdate #description').val(vatValues.description);
                });
                $('.vatValueFormUpdate #updateModal').modal();
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });

    });
    $('.newBtn').on('click', function(event) {
        event.preventDefault();
        $('.vatValueFormCreate #vatId').val('');
        $('.vatValueFormCreate #vatValue').val('');
        $('.vatValueFormCreate #description').val('');
        $('.vatValueFormCreate #vatValueModalCreate').modal();
    });
});
