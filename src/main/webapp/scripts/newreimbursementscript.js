function submitReimbursement() {
	// grab the form
	let form = document.newReimbursementForm;
	// get the values
	let amount = form.amount.value;
	let type = form.type.value;
	let description = form.description.value;
	// may want to comment out file until more investigation, we'll see...
	let file = form.file.value;
	
	// create temp js object to hold input
	let newReimbursementJSObject = {
			amount: amount,
			type: type,
			description: description,
			file: file,
	}
	
	// instantiate xhr
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if((this.readyState === 4) && (this.status === 201)) {
			alert("Reimbursement Submission Succesful")
		} else if ((this.readyState === 4) && (this.status !== 201)) {
			alert("Reimbursement Submission Failed.")
		}
	};
	
	xhr.open("POST", "http://localhost:8080/Projet1/newReimbursement");
	xhr.send(JSON.stringify(newReimbursementJSObject));
}