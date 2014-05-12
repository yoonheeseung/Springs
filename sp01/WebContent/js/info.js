/**
 * info.js
 */

function check(){
	if($.trim($("#name").val())==""){
		alert("이름을 입력하세요");
		$("#name").val("").focus();
		return false;
	}
	if($.trim($("#addr").val())==""){
		alert("주소를 입력하세요");
		$("#addr").val("").focus();
		return false;
	}
}