function check(){
	var names=registry.name.value;
	var emails=registry.email.value;
	var e=/^[A-Za-z0-9]+([_\.\-]?[A-Za-z0-9])*@[A-Za-z0-9]+([\.\-]?[A-Za-z0-9]+)*(\.[A-Za-z]+)+$/;
	var subjects=registry.subject.value;
	var message=registry.message.value;
	var e_names=document.all("error_name");
	var e_emails=document.all("error_email");
	var e_subject=document.all("error_subject");
	var e_message=document.all("error_message");
	if(names==""){
		registry.name.style.backgroundColor="red";
		e_names.innerHTML="(*) No Empty";
		registry.name.focus();
		return;
	}
	error_name.innerHTML="";
	var els=e.test(emails);
	if(els==""){
		registry.email.style.backgroundColor="red";
		e_emails.innerHTML="(*) No Empty";
		registry.email.focus();
		return;
	}
	error_email.innerHTML="";
	if(subjects==""){
		registry.subject.style.backgroundColor="red";
		e_subjects.innerHTML="(*) No Empty";
		registry.subject.focus();
		return;
	}
	error_subject.innerHTML="";
	if(messages==""){
		registry.message.style.backgroundColor="red";
		e_messages.innerHTML="(*) No Empty";
		registry.message.focus();
		return;
	}
	error_message.innerHTML="";
}