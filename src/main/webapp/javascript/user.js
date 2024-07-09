function checkEmail(event){
	// 이벤트 발생 객체
	const obj = event.target;						   	// button#check-email
	const target = obj.getAttribute("data-target"); 	// API 호출 위치
	const frm = obj.form;								// form 찾기
	
	const email = frm.email.value.trim();
	
	if(email.length === 0) {
		alert("이메일을 입력해 주세요. ");
		return;
	}
	
	// fetch 함수
	console.log(`${target}?email=${email}`);
	fetch(`${target}?email=${email}`).then(response => {
		console.log(response);
		return response.json();
	}).then(json => {
		console.log(json);
		// 중복 여부
		if(json.exist) {
			alert(`이미 사용중인 이메일 입니다.`)
			throw new Error(`중복된 이메일 입니다.`);
		} else {
			alert(`사용 가능한 이메일 입니다.`);
			frm.emailCheck.value = "y";
		}
	})
	.catch(error => console.error(error));
}


window.addEventListener("load", event => {
	document.getElementById("check-email").addEventListener("click", checkEmail);
	/*	
	// 가입 폼 Validation
	document.getElementById("join-form").addEventListener("submit", event => {
		const frm = event.target;
		
		event.preventDefault();
	
		// 이름 검증
		if(frm.name.value.trim().length === 0) {
			alert(`이름을 입력하세요`);
			frm.focus();
			return;
		} 
		// 비밀번호 검증
		if(frm.password.value.trim().length === 0) {
			alert(`비밀번호를 입력하세요`);
			frm.password.focus();
			return;
		}
		// email 검증
		if(frm.email.value.trim().length === 0) {
			frm.email.focus();
			return;
		}
		// 성별 검증
		const genders = document.querySelector('input[name=gender]:checked');
		if(genders === null) {		// 만약 선택된 radio가 없으면?
			alert("성별을 선택하세요");
			return;
		}
		// email중복 체크 여부 판단하기
		if(frm.emailCheck.value !== "y"){
			alert("이메일 중복 확인을 해주세오");
			return;
		}
		// 약관 동의 여부
		if(!frm.agree.checked) {
			alert("약관에 동의해주세요");
			return;
		}
		
		// 전송하기
		frm.submit();
	});
	*/
});