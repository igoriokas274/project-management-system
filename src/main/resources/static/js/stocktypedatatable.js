$(document).ready( function () {
    const stockTypeTable = $('#stockTypeTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        /*"serverSide": true,*/
        "ajax": "/api/stocktypes/list",
        "sAjaxDataProp": "",
        rowId: 'stockId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "stockId" },
            { "data": "stockName" },
            { "data": "closed" }
        ]
    });
    $('#stockTypeTable body').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            stockTypeTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    $('#deleteBtn').click( function () {
        var id = stockTypeTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'delete?id=' + id,
            success: function () {
                alert("Row id " + id + " deleted");
                stockTypeTable.row('.selected').remove().draw( false );
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });
    });
    $('.editBtn').on('click', function(event) {
        event.preventDefault();
        var id = stockTypeTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'update?id=' + id,
            success: function () {
                $.get(this.url, function (stocktypes, status) {
                    $('.stockTypeFormUpdate #stockId').val(stocktypes.stockId);
                    $('.stockTypeFormUpdate #stockName').val(stocktypes.stockName);
                    $('.stockTypeFormUpdate #closed').val(stocktypes.closed);
                    $('.stockTypeFormUpdate #addressLine1').val(stocktypes.addressLine1);
                    $('.stockTypeFormUpdate #addressLine2').val(stocktypes.addressLine2);
                    $('.stockTypeFormUpdate #city').val(stocktypes.city);
                    $('.stockTypeFormUpdate #zipCode').val(stocktypes.zipCode);
                    $('.stockTypeFormUpdate #country').val(stocktypes.country);
                });
                $('.stockTypeFormUpdate #updateModal').modal();
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });

    });
    $('.newBtn').on('click', function(event) {
        event.preventDefault();
        $('.stockTypeFormCreate #stockName').val('');
        $('.stockTypeFormCreate #closed').val('');
        $('.stockTypeFormCreate #addressLine1').val('');
        $('.stockTypeFormCreate #addressLine2').val('');
        $('.stockTypeFormCreate #city').val('');
        $('.stockTypeFormCreate #zipCode').val('');
        $('.stockTypeFormCreate #country').val('');
        $('.stockTypeFormCreate #stockTypeModalCreate').modal();
    });
});
