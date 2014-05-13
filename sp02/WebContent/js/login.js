/**
 *  login.js
 */

function check(){
	if($.trim($("#login_id").val())==""){
		alert("아이디를 입력하세요!");
		$("#login_id").val("").focus();
		return false;
	}
	if($.trim($("#login_pwd").val())==""){
		alert("비번을 입력하세요!");
		$("#login_pwd").val("").focus();
		return false;
	}
}

function join_check(){
	if($.trim($("#mem_id").val())==""){
		alert("아이디를 입력하세요!");
		$("#mem_id").val("").focus();
		return false;
	}
	
	$mem_pwd=$.trim($("#mem_pwd").val());
	$mem_pwd2=$.trim($("#mem_pwd2").val());
	
	if($mem_pwd==""){
		alert("비번을 입력하세요!");
		$("#mem_pwd").val("").focus();
		return false;
	}
	if($mem_pwd2==""){
		alert("확인 비번을 입력하세요!");
		$("#mem_pwd2").val("").focus();
		return false;
	}
	if($mem_pwd != $mem_pwd2){
		alert("확인 비번이 틀립니다.");
		$("#mem_pwd2").val("");
		$("#mem_pwd").val("").focus();
		return false;
	}
	if($.trim($("#mem_name").val())==""){
		alert("회원이름을 입력하세요!");
		$("#mem_name").val("").focus();
		return false;
	}
	if($.trim($("#mem_addr").val())==""){
		alert("회원주소를 입력하세요!");
		$("#mem_addr").val("").focus();
		return false;
	}
	if($.trim($("#mem_phone02").val())==""){
		alert("폰번호를 입력하세요!");
		$("mem_phone02").val("").focus();
		return false;
	}
	if($.trim($("#mem_phone03").val())==""){
		alert("폰번호를 입력하세요!");
		$("mem_phone03").val("").focus();
		return false;
	}
}