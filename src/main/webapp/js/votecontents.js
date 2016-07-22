$(function () {
            $(".checked").click(function() {
                if($(this).is(":checked")) {
                    $(".sgbox").show();
                } else {
                    $(".sgbox").hide();
                }
            });
        });