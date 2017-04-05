$(document).ready(function() {

    $('.value').click(function () {
        var ex = $(this).text();
        $('#get').val('[GET] '+ex);
        $('#post').val('[POST] '+ex);
    })

});
