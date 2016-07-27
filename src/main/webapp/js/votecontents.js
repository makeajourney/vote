
var link_button = document.getElementById("linkBtn");

link_button.onclick = function() {

  $('#exampleModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
    var recipient = button.data('whatever'); // Extract info from data-* attributes
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this);
    modal.find('.modal-title').text("Link the current article and vote.");
    modal.find('.modal-body input').val(recipient);
  });

}

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

function editcomment(obj) {
	var divblock = obj.parentNode.parentNode;
	var commentContent = divblock.childNodes[1];
	var removeElement = divblock.childNodes[3];
	
	var updateCommentDiv = document.createElement('div');
	updateCommentDiv.setAttribute("class", "box");
	
	var inputComment = document.createElement('input');
	inputComment.setAttribute("type", "text");
	inputComment.setAttribute("name", "context");
	inputComment.setAttribute("id", "cbox");
	inputComment.setAttribute("class", "cbox");
	inputComment.setAttribute("value", commentContent.innerHTML);
	
	var submitBtn = document.createElement('button');
	submitBtn.setAttribute("type", "submit");
	submitBtn.setAttribute("class", "cbtn");
	submitBtn.innerHTML="Submit";
	
	updateCommentDiv.appendChild(inputComment);
	updateCommentDiv.appendChild(submitBtn);
	
	divblock.appendChild(updateCommentDiv);
	
	commentContent.remove();
	removeElement.remove();
	
}

function changeAction() {
	var formElement = document.getElementById('commentform');
	
	if (document.getElementById('checked').checked == true) {
		formElement.setAttribute('action', 'addVoteSuggest.do');
	} else {
		formElement.setAttribute('action', 'addComment.do');
	}
}

function voteitem(obj) {
	var choose = obj;
	var choosename = choose.childNodes[1];
	
	choose.setAttribute("style", "background-color: #FFDFDF;");
	choosename.setAttribute("style", "background-color: red;");
	
}






