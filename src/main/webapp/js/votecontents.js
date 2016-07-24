function chkformComment() {
  var sugg = document.getElementById("sgbox").value;
  var com = document.getElementById("cbox").value;
  var chk = document.getElementById("checked");

  if(chk.checked) {
    if(sugg == "") {
      alert("intput element");
      return false;
    }
    if(com == "") {
      alert("intput comment");
      return false;
    }
    return true;
  }
  else {
    if(com == "") {
      alert("intput comment");
      return false;
    }
    return true;
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

$(document).ready(function() {
  $(".edit").click(function() {
    $(".edittext").show();
    $(".text").hide();
  });
});
