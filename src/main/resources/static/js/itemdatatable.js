$(document).ready( function () {
    const itemTable = $('#itemTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        /*"serverSide": true,*/
        "ajax": "/api/items/list",
        "sAjaxDataProp": "",
        rowId: 'itemId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "itemId" },
            { "data": "itemName" },
            { "data": "itemType" },
            { "data": "salesPrice", render: $.fn.dataTable.render.number( ',', '.', 2, '€ ' ) },
            { "data": "supplier" },
            { "data": "closed" }
        ]
    });
    $('#itemTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            itemTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    $('#deleteBtn').click( function () {
        var id = itemTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'delete?id=' + id,
            success: function () {
                alert("Row id " + id + " deleted");
                itemTable.row('.selected').remove().draw( false );
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });
    });
    $('.editBtn').on('click', function(event) {
        event.preventDefault();
        var id = itemTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'update?id=' + id,
            success: function () {
                $.get(this.url, function (items, status) {
                    $('.itemFormUpdate #itemId').val(items.itemId);
                    $('.itemFormUpdate #itemName').val(items.itemName);
                    $('.itemFormUpdate #itemDescription').val(items.itemDescription);
                    $('.itemFormUpdate #supplierId').val(items.supplierId);
                    $('.itemFormUpdate #itemType').val(items.itemType);
                    $('.itemFormUpdate #stockId').val(items.stockId);
                    $('.itemFormUpdate #salesPrice').val(items.salesPrice);
                    $('.itemFormUpdate #vatId').val(items.vatId);
                    $('.itemFormUpdate #minStockLevel').val(items.minStockLevel);
                    $('.itemFormUpdate #closed').val(items.closed);
                });
                $('.itemFormUpdate #updateModal').modal();
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });

    });
    $('.newBtn').on('click', function(event) {
        event.preventDefault();
        $('.itemFormCreate #itemId').val('');
        $('.itemFormCreate #itemName').val('');
        $('.itemFormCreate #itemDescription').val('');
        $('.itemFormCreate #supplierId').val('');
        $('.itemFormCreate #itemType').val('');
        $('.itemFormCreate #stockId').val('');
        $('.itemFormCreate #salesPrice').val('');
        $('.itemFormCreate #vatId').val('');
        $('.itemFormCreate #minStockLevel').val('');
        $('.itemFormCreate #itemModalCreate').modal();
    });
});
