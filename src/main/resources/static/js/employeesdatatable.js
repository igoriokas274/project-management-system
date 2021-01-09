$(document).ready( function () {
    const dataTable = $('#employeesTable').DataTable({
        "pagingType": "full_numbers",
        select: {
            style: 'single'
        },
        "processing": true,
        /*"serverSide": true,*/
        "ajax": "/api/employee/list",
        "sAjaxDataProp": "",
        rowId: 'employeeId',
        "order": [[ 0, "asc" ]],
        "columns": [
            { "data": "employeeId" },
            { "data": null,
                "string": "fullName",
                render: function ( data, type, row ) {
                    return data.firstName +' '+ data.lastName;
                }},
            /*{ "data": "firstName" },
            { "data": "lastName" },*/
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
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });
    });
    $('.editBtn').on('click', function(event) {
        event.preventDefault();
        var id = dataTable.row( '.selected' ).id();
        $.ajax({
            type: 'GET',
            url: 'update?id=' + id,
            success: function () {
                $.get(this.url, function (employees, status) {
                    $('.employeeFormUpdate #employeeId').val(employees.employeeId);
                    $('.employeeFormUpdate #firstName').val(employees.firstName);
                    $('.employeeFormUpdate #middleName').val(employees.middleName);
                    $('.employeeFormUpdate #lastName').val(employees.lastName);
                    $('.employeeFormUpdate #title').val(employees.title);
                    $('.employeeFormUpdate #department').val(employees.department);
                    $('.employeeFormUpdate #addressLine1').val(employees.addressLine1);
                    $('.employeeFormUpdate #addressLine2').val(employees.addressLine2);
                    $('.employeeFormUpdate #city').val(employees.city);
                    $('.employeeFormUpdate #zipCode').val(employees.zipCode);
                    $('.employeeFormUpdate #country').val(employees.country);
                    $('.employeeFormUpdate #homePhone').val(employees.homePhone);
                    $('.employeeFormUpdate #personalEmail').val(employees.personalEmail);
                    $('.employeeFormUpdate #gender').val(employees.gender);
                    $('.employeeFormUpdate #dateOfBirth').val(employees.dateOfBirth);
                    $('.employeeFormUpdate #dateOfEmployment').val(employees.dateOfEmployment);
                    $('.employeeFormUpdate #bankName').val(employees.bankName);
                    $('.employeeFormUpdate #bankCode').val(employees.bankCode);
                    $('.employeeFormUpdate #bankAccount').val(employees.bankAccount);
                    $('.employeeFormUpdate #mobilePhone').val(employees.mobilePhone);
                    $('.employeeFormUpdate #officePhone').val(employees.officePhone);
                    $('.employeeFormUpdate #workEmail').val(employees.workEmail);
                    $('.employeeFormUpdate #closed').val(employees.closed);
                });
                $('.employeeFormUpdate #updateModal').modal();
            },
            error: function (errorMsg) {
                alert("Error: Please select a row first!");
                console.log("ERROR: " + errorMsg);
            }
        });

    });
    $('.newBtn').on('click', function(event) {
        event.preventDefault();
        $('.employeeFormCreate #firstName').val('');
        $('.employeeFormCreate #middleName').val('');
        $('.employeeFormCreate #lastName').val('');
        $('.employeeFormCreate #title').val('');
        $('.employeeFormCreate #department').val('');
        $('.employeeFormCreate #addressLine1').val('');
        $('.employeeFormCreate #addressLine2').val('');
        $('.employeeFormCreate #city').val('');
        $('.employeeFormCreate #zipCode').val('');
        $('.employeeFormCreate #country').val('');
        $('.employeeFormCreate #homePhone').val('');
        $('.employeeFormCreate #personalEmail').val('');
        $('.employeeFormCreate #gender').val('');
        $('.employeeFormCreate #dateOfBirth').val('');
        $('.employeeFormCreate #dateOfEmployment').val('');
        $('.employeeFormCreate #bankName').val('');
        $('.employeeFormCreate #bankCode').val('');
        $('.employeeFormCreate #bankAccount').val('');
        $('.employeeFormCreate #mobilePhone').val('');
        $('.employeeFormCreate #officePhone').val('');
        $('.employeeFormCreate #workEmail').val('');
        $('.employeeFormCreate #closed').val('');
        $('.employeeFormCreate #employeeModalCreate').modal();
    });
});
