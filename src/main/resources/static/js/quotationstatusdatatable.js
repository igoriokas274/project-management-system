$(document).ready( function () {
    const quotationStatusTable = $('#quotationStatusTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        /*"serverSide": true,*/
        "ajax": "/api/quotationstatuses/list",
        "sAjaxDataProp": "",
        rowId: 'quotationStatusId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "quotationStatusId" },
            { "data": "quotationStatusName" }
        ]
    });
    $('#quotationStatusTable body').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            quotationStatusTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    $('#deleteBtn').click( function () {
        var id = quotationStatusTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'delete?id=' + id,
            success: function () {
                alert("Row id " + id + " deleted");
                quotationStatusTable.row('.selected').remove().draw( false );
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });
    });
    $('.editBtn').on('click', function(event) {
        event.preventDefault();
        var id = quotationStatusTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'update?id=' + id,
            success: function () {
                $.get(this.url, function (quotationstatuses, status) {
                    $('.quotationStatusFormUpdate #quotationStatusId').val(quotationstatuses.quotationStatusId);
                    $('.quotationStatusFormUpdate #quotationStatusName').val(quotationstatuses.quotationStatusName);
                });
                $('.quotationStatusFormUpdate #updateModal').modal();
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });

    });
    $('.newBtn').on('click', function(event) {
        event.preventDefault();
        $('.quotationStatusFormCreate #quotationStatusId').val('');
        $('.quotationStatusFormCreate #quotationStatusName').val('');
        $('.quotationStatusFormCreate #quotationStatusModalCreate').modal();
    });
});
