var i = 2;
var addEln = document.getElementById("addVoElBtn");

addEln.onclick = function() {

  var newEln = document.createElement("DIV");
  newEln.setAttribute("class", "modal-footer");
  newEln.setAttribute("id", "vote");

  var child = document.createElement("INPUT");
  child.setAttribute("class", "form-control");
  child.setAttribute("id", "ex4");
  child.setAttribute("type", "text");

  newEln.appendChild(child);

  var delBtn = document.createElement("BUTTON");
  delBtn.setAttribute("class", "open-icon");
  delBtn.setAttribute("type", "reset");
  var text = document.createTextNode("X");
  delBtn.appendChild(text);
  delBtn.onclick = function() {

    var label = document.getElementById("123").innerHTML;
    var res = label.replace(i, (i-1));

    $(this).parent().remove();
    i = i - 1;
    document.getElementById("123").innerHTML = res;
  }
  newEln.appendChild(delBtn);

  var votingList = document.getElementById("modalContent");

  votingList.appendChild(newEln);

  var label = document.getElementById("123").innerHTML;
  var res = label.replace(i, (i+1));
  i = i + 1;
  document.getElementById("123").innerHTML = res;
}


function chkformLogin() {
  var title = document.getElementById("T").value;
  var comment = document.getElementById("comment").value;
  var eln_1 = document.getElementById("ex5").value;
  var eln_2 = document.getElementById("ex6").value;

  if(title == "") {
    alert("input title");
    return false;
  }
  if(comment == "") {
    alert("input comment");
    return false;
  }
  if(eln_1 == "") {
    alert("input vote element 1");
    return false;
  }
  if(eln_2 == "") {
    alert("input vote element 2");
    return false;
  }
  return true;
}
