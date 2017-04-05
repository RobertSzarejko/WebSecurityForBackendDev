$(document).ready(function() {


        $.fn.increment = function() {
            if(this.val()!='1'){
                return this;
            }
            var value = this.text();
            value = parseInt(value, 10)+1;
            if(value>9){
                value = 0;
            }
            this.text(value);
            return this;
        };

        $.fn.initial = function() {
            this.attr('class', 'digit');
            this.val('1');
            return this;
        };

        $.fn.final = function(digit) {
            this.val('0');
            this.attr('class', 'final');
            this.text(digit);
            return this;
        };



    $('.digit').initial();


    var incTimer = null;
    var forceTimer = null;

    $('#wynik').click(function () {
        $('.final').initial();
        var incTimer = setInterval(function () {
                $('.digit').each(function () {
                    $(this).increment();
                });
            }
            ,30
        );
        var ms = new Date().getTime();
        $('#timer').text(ms);
        var forceTimer = setInterval(function () {
                var time = $('#timer');
                var value = new Date().getTime() - ms;
                value = $.number(value, 0, ',', ' s ') + ' ms';
                time.text(value);
            }
            ,20
        );

        var hash = $('#hash').val();
        var algorithm = $('#algorithm').val();
        $.post( "/crypto/broke", {hash: hash, algorithm: algorithm},function( data ) {
            $().result(data);
            setTimeout(function () {
                    clearInterval(incTimer);
                    clearInterval(forceTimer);
                }
                , 3000
            );
        });
    })

    $.fn.result = function(result) {

        $('#D3').final(result[2]);
        setTimeout(function () {
                $('#D7').final(result[6]);
            }
            , 500
        );
        setTimeout(function () {
                $('#D5').final(result[4]);
            }
            , 1000
        );

        setTimeout(function () {
                $('#D1').final(result[0]);
            }
            , 1500
        );

        setTimeout(function () {
                $('#D6').final(result[5]);
            }
            , 2000
        );

        setTimeout(function () {
                $('#D2').final(result[1]);
            }
            , 2500
        );

        setTimeout(function () {
                $('#D4').final(result[3]);
            }
            , 3000
        );
    }
});

