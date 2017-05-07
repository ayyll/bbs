/* ×¢²á */
function regist() {
	var url = "/MyForum/user/regist";
	var params = {
		username : $('#username').val(),
		password : $('#password').val()
	};
	$.post(url, params, function(data) {
		alert(data.data);
	}, "json");
}

/* µÇÂ¼ */
function login() {
	var url = "/MyForum/user/login";
	var params = {
		username : $('#username').val(),
		password : $('#password').val()
	};
	$.post(url, params, function(data) {
		alert(data.data);
		location.href = "/MyForum/article/list/1";
	}, "json");
}