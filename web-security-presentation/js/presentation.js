$(document).ready(function() {

    $('.step').each(function () {

        var x_separate = 1500;
        var y_separate = 900;

        var x_data = $(this).attr('data-x');
        if(x_data.search('x')>-1){
            x_data = x_data.replace('x', '');
            var x_data2 = x_data * x_separate;
            $(this).attr('data-x', x_data2);
        }else if(x_data.search('y')>-1){
            x_data = x_data.replace('y', '');
            var x_data2 = x_data * y_separate;
            $(this).attr('data-x', x_data2);
        }

        var y_data = $(this).attr('data-y');
        if(y_data.search('x')>-1){
            y_data = y_data.replace('x', '');
            var y_data2 = y_data * x_separate;
            $(this).attr('data-y', y_data2);
        }else if(y_data.search('y')>-1){
            y_data = y_data.replace('y', '');
            var y_data2 = y_data * y_separate;
            $(this).attr('data-y', y_data2);
        }
    });
    impress().init();
});
