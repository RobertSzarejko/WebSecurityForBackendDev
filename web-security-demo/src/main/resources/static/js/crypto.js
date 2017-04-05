$(document).ready(function() {

    var length =  $('#plainText').val().length;
    $('#size').text(length);


    $('#plainText').keyup(function() {
        var length =  $('#plainText').val().length;
        $('#size').text(length);
    });


});
