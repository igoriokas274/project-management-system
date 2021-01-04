$(document).ready( function () {
    const dataTable = $('#employeesTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        "serverSide": true,
        "ajax": "/api/employee/list",
        "sAjaxDataProp": "",
        rowId: 'employeeId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "employeeId" },
            { "data": "firstName" },
            { "data": "lastName" },
            { "data": "title" },
            { "data": "department" },
            { "data": "mobilePhone" },
            { "data": "workEmail" },
            { "data": "createdBy" },
            { "data": "createdDate" },
            { "data": "lastModifiedBy" },
            { "data": "lastModifiedDate" },
            { "data": "closed" }
        ]
    });
    $('#employeesTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            dataTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    $('#deleteBtn').click( function () {
        var id = dataTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'delete?id=' + id,
            success: function () {
                alert("Row id " + id + " deleted");
                dataTable.row('.selected').remove().draw( false );
            },
            error: function (errorMsg) {
                alert("ERROR: " + errorMsg);
                console.log("ERROR: " + errorMsg);
            }
        });

    });
});
