/**
 * 
 */

function formData() {
	console.log("Hi");
	var email = $("#exampleInputEmail1").val();
	var password = $("#exampleInputPassword1").val();

	console.log(email);

	var fmdata = {
		email: email,
		password: password
	}
	console.log(fmdata);
	$.ajax({
		url: "FormData",
		type: "post",
		data: { "data": JSON.stringify(fmdata) },
		success: function(data) {
			window.location.href = data;
		},
		error: function(data) {
			window.location.href = data;
		}
	});


}