$(document).ready(function(){

    $('.newBtn, .table .editBtn').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
        //for update user
        if (text == 'edit') {
            $.get(href, function (users, status) {
                $('.userFormUpdate #userId').val(users.userId);
                $('.userFormUpdate #userName').val(users.userName);
                $('.userFormUpdate #password').val(users.password);
                $('.userFormUpdate #role').val(users.role);
                $('.userFormUpdate #enabled').val(users.enabled);
            });
            $('.userFormUpdate #updateModal').modal();
        } else {
            //for creating user
            $('.userFormCreate #userName').val('');
            $('.userFormCreate #password').val('');
            $('.userFormCreate #role').val('');
            $('.userFormCreate #enabled').val('');
            $('.userFormCreate #userModalCreate').modal();
        }
    });
});
