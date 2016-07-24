function chkformComment() {   

    var sugg = document.getElementById("sgbox").value;
    var com = document.getElementById("cbox").value;
    var chk = document.getElementById("checked");

    if(chk.checked) {

        if(sugg == "") {
            alert("intput element");
        }

        if(com == "") {
            alert("intput comment");
        }
        return true;
    }
    else {
        if(com == "") {
            alert("intput comment");
        }
        $.ajax({
        	url: "./addComment.do", 
        	data : {
        		comment : encodeURIComponent( value  )
        	}, 
        	success: function(result){
        		
        	}
        });

        $('.keyword-form')[0].value = "";
    }

}

$(function () {
            $(".checked").click(function() {
                if($(this).is(":checked")) {
                    $(".sgbox").show();
                } else {
                    $(".sgbox").hide();
                }
            });
        });