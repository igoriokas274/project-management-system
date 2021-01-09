$(document).ready( function () {
    const currencyTable = $('#currencyTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        /*"serverSide": true,*/
        "ajax": "/api/currencies/list",
        "sAjaxDataProp": "",
        rowId: 'currencyId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "currencyId" },
            { "data": "currencyCode" },
            { "data": "currencyName" },
            { "data": "closed" }
        ]
    });
    $('#currencyTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            currencyTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    $('#deleteBtn').click( function () {
        var id = currencyTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'delete?id=' + id,
            success: function () {
                alert("Row id " + id + " deleted");
                currencyTable.row('.selected').remove().draw( false );
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });
    });
    $('.editBtn').on('click', function(event) {
        event.preventDefault();
        var id = currencyTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'update?id=' + id,
            success: function () {
                $.get(this.url, function (currencies, status) {
                    $('.currencyFormUpdate #currencyId').val(currencies.currencyId);
                    $('.currencyFormUpdate #currencyCode').val(currencies.currencyCode);
                    $('.currencyFormUpdate #currencyName').val(currencies.currencyName);
                    $('.currencyFormUpdate #closed').val(currencies.closed);
                });
                $('.currencyFormUpdate #updateModal').modal();
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });

    });
    $('.newBtn').on('click', function(event) {
        event.preventDefault();
        $('.currencyFormCreate #currencyId').val('');
        $('.currencyFormCreate #currencyCode').val('');
        $('.currencyFormCreate #currencyName').val('');
        $('.currencyFormCreate #closed').val('');
        $('.currencyFormCreate #currencyModalCreate').modal();
    });
});
