$(document).ready( function () {
    const quotationTable = $('#quotationTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        /*"serverSide": true,*/
        "ajax": "/api/quotations/list",
        "sAjaxDataProp": "",
        rowId: 'quotationId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "quotationId" },
            { "data": "quotationDate" },
            { "data": "quotationTitle" },
            { "data": "confirmed" },
            { "data": "createdBy" },
            { "data": "createdDate" },
            { "data": "lastModifiedBy" },
            { "data": "lastModifiedDate" },
        ]
    });
    $('#quotationTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            quotationTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
    $('#deleteBtn').click( function () {
        var id = quotationTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'delete?id=' + id,
            success: function () {
                alert("Row id " + id + " deleted");
                quotationTable.row('.selected').remove().draw( false );
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });
    });
    /*$('.editBtn').on('click', function(event) {
        event.preventDefault();
        var id = quotationTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'update?id=' + id,
            success: function () {
                $.get(this.url, function (projects, status) {
                    $('.projectFormUpdate #projectId').val(projects.projectId);
                    $('.projectFormUpdate #projectName').val(projects.projectName);
                    $('.projectFormUpdate #employees').val(projects.employees);
                    $('.projectFormUpdate #projectType').val(projects.projectType);
                    $('.projectFormUpdate #projectStatus').val(projects.projectStatus);
                    $('.projectFormUpdate #customer').val(projects.customer);
                    $('.projectFormUpdate #closed').val(projects.closed);
                    $('.projectFormUpdate #projectMemo1').val(projects.projectMemo1);
                    $('.projectFormUpdate #projectMemo2').val(projects.projectMemo2);
                    $('.projectFormUpdate #projectStartDate').val(projects.projectStartDate);
                    $('.projectFormUpdate #projectEndDate').val(projects.projectEndDate);
                });
                $('.projectFormUpdate #updateModal').modal();
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });

    });
    $('.newBtn').on('click', function(event) {
        event.preventDefault();
        $('.projectFormCreate #projectName').val('');
        $('.projectFormCreate #employees').val('');
        $('.projectFormCreate #projectType').val('');
        $('.projectFormCreate #projectStatus').val('');
        $('.projectFormCreate #customer').val('');
        $('.projectFormCreate #closed').val('');
        $('.projectFormCreate #projectMemo1').val('');
        $('.projectFormCreate #projectMemo2').val('');
        $('.projectFormCreate #projectStartDate').val('');
        $('.projectFormCreate #projectEndDate').val('');
        $('.projectFormCreate #projectModalCreate').modal();
    });*/
});
