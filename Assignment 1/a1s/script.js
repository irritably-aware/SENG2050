function validateForm(form){

	if(empty(form.uname.value)){
		alert("invalid userName!");
	}

	if(empty(form.title.value)){
		alert("invalid title!");
	}

	if(empty(form.message.value)){
		alert("invalid message!");
	}

	if(form.message.value.length>50){
		alert("message exceed maxsize");
	}
		
	return 0;

}

function empty(str){
	//space-only strings have size 0
	return str.trim().length === 0;

}