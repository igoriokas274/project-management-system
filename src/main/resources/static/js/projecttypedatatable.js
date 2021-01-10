$(document).ready( function () {
    const projectTypeTable = $('#projectTypeTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        /*"serverSide": true,*/
        "ajax": "/api/projecttypes/list",
        "sAjaxDataProp": "",
        rowId: 'projectTypeId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "projectTypeId" },
            { "data": "projectTypeName" }
        ]
    });
    $('#projectTypeTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            projectTypeTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    $('#deleteBtn').click( function () {
        var id = projectTypeTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'delete?id=' + id,
            success: function () {
                alert("Row id " + id + " deleted");
                projectTypeTable.row('.selected').remove().draw( false );
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });
    });
    $('.editBtn').on('click', function(event) {
        event.preventDefault();
        var id = projectTypeTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'update?id=' + id,
            success: function () {
                $.get(this.url, function (projectTypes, status) {
                    $('.projectTypeFormUpdate #projectTypeId').val(projectTypes.projectTypeId);
                    $('.projectTypeFormUpdate #projectTypeName').val(projectTypes.projectTypeName);
                });
                $('.projectTypeFormUpdate #updateModal').modal();
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });

    });
    $('.newBtn').on('click', function(event) {
        event.preventDefault();
        $('.projectTypeFormCreate #projectTypeId').val('');
        $('.projectTypeFormCreate #projectTypeName').val('');
        $('.projectTypeFormCreate #projectTypeModalCreate').modal();
    });
});
