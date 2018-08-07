$(document).ready(function () {
    $('.addBtn, .table .editBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
        if (text === 'Edit') {
            $.get(href, function (property, status) {
                $('.myForm #id').val(property.id);
                $('.myForm #key').val(property.key);
                $('.myForm #value').val(property.value);
            });
            $('.myForm #addModal').modal();
        } else {
            $('.myForm #id').val('');
            $('.myForm #key').val('');
            $('.myForm #value').val('');
            $('.myForm #addModal').modal();
        }
    });
    $('.table .deleteBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #deleteRef').attr('href', href);
        $('#deleteModal').modal();
    });
});