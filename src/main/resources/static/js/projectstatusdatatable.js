$(document).ready( function () {
    const projectStatusTable = $('#projectStatusTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        /*"serverSide": true,*/
        "ajax": "/api/projectstatuses/list",
        "sAjaxDataProp": "",
        rowId: 'projectStatusId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "projectStatusId" },
            { "data": "projectStatusName" }
        ]
    });
    $('#projectStatusTable body').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            projectStatusTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    $('#deleteBtn').click( function () {
        var id = projectStatusTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'delete?id=' + id,
            success: function () {
                alert("Row id " + id + " deleted");
                projectStatusTable.row('.selected').remove().draw( false );
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });
    });
    $('.editBtn').on('click', function(event) {
        event.preventDefault();
        var id = projectStatusTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'update?id=' + id,
            success: function () {
                $.get(this.url, function (departments, status) {
                    $('.projectStatusFormUpdate #projectStatusId').val(projectstatuses.projectStatusId);
                    $('.projectStatusFormUpdate #projectStatusName').val(projectstatuses.projectStatusName);
                });
                $('.projectStatusFormUpdate #updateModal').modal();
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });

    });
    $('.newBtn').on('click', function(event) {
        event.preventDefault();
        $('.projectStatusFormCreate #projectStatusId').val('');
        $('.projectStatusFormCreate #projectStatusName').val('');
        $('.projectStatusFormCreate #projectStatusModalCreate').modal();
    });
});
