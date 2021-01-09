$(document).ready( function () {
    const departmentTable = $('#departmentTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        /*"serverSide": true,*/
        "ajax": "/api/departments/list",
        "sAjaxDataProp": "",
        rowId: 'departmentId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "departmentId" },
            { "data": "departmentName" },
            { "data": "closed" }
        ]
    });
    $('#departmentTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            departmentTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    $('#deleteBtn').click( function () {
        var id = departmentTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'delete?id=' + id,
            success: function () {
                alert("Row id " + id + " deleted");
                departmentTable.row('.selected').remove().draw( false );
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });
    });
    $('.editBtn').on('click', function(event) {
        event.preventDefault();
        var id = departmentTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'update?id=' + id,
            success: function () {
                $.get(this.url, function (departments, status) {
                    $('.departmentFormUpdate #departmentId').val(departments.departmentId):
                    $('.departmentFormUpdate #departmentName').val(departments.departmentName);
                    $('.departmentFormUpdate #closed').val(departments.closed);
                });
                $('.departmentFormUpdate #updateModal').modal();
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });

    });
    $('.newBtn').on('click', function(event) {
        event.preventDefault();
        $('.departmentFormCreate #departmentId').val('');
        $('.departmentFormCreate #departmentName').val('');
        $('.departmentFormCreate #closed').val('');
        $('.departmentFormCreate #departmentModalCreate').modal();
    });
});
