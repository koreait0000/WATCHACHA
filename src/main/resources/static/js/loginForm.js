//모달창 on/off, 비밀번호 찾기
let lossPw = document.querySelector('#lossPw');
let modal = document.querySelector('#modal');
let sendMail = document.querySelector('#sendMail');
let authCheck = document.querySelector('#authCheck');
let email = document.querySelector('.email');
let getPw = document.querySelector('#getPw');
let authCd = document.querySelector('.authCd');
let btnGetPw = document.querySelector('#btnGetPw');

lossPw.addEventListener('click', () =>{
    modal.classList.remove('hidden'); //모달 on

    sendMail.addEventListener('click', ()=>{
        sendMail.classList.add('hidden');
        authCheck.classList.remove('hidden');
        getPw.classList.remove('hidden');
        fetch('/lossPw?email='+email.value)
            .then(res => res.json())
            .then(myJson => {
                btnGetPw.addEventListener('click',()=>{
                    if(myJson.auth == authCd.value){
                        email.readOnly = 'true';
                        authCheck.classList.add('hidden');
                        // getPw.classList.add('hidden');
                        let pwElem = document.createElement('input');
                        sendMail.append(pwElem);
                        btnGetPw.innerHTML='비밀번호 변경';
                    }
                });
            });
    });
});


let isRecaptchachecked=false;

$('.upper').on('keyup', function(k) {
    if (k.keyCode == 13) {
        doLogin();
    }
});
//비밀번호 인풋 박스 엔터 누를시
$('.down').on('keyup', function(k) {
    if (k.keyCode == 13) {
        doLogin();
    }
});

function doLogin(){
    let id = $(".upper");
    let password = $(".down");
    if(id.val().indexOf('@') < 1 || id.val().indexOf('.') < 1){
        alert('이메일 형식으로 입력해주세요.');
        id.focus();
        return false;
    }
    if(id.val().trim() == ''){
        alert('아이디를 입력하세요.');
        id.focus();
        return false;
    }
    if(password.val().trim() == '') {
        alert('비밀번호를 입력하세요.');
        password.focus();
        return false;
    }
    if(!isRecaptchachecked){
        alert('인증 체크를 해주세요.');
        $("#recaptcha").focus();
        return false;
    }
    let email = $('.upper').val();
    return doVaildRecaptcha(email);
}

function recaptchaCallback(){// 리캡챠 체크 박스 클릭시 isRecaptchachecked 값이 true로 변경
    isRecaptchachecked = true;
}

function doVaildRecaptcha(email){
    let captcha = 1;
    $.ajax({
        url: '/valid-recaptcha',
        type: 'post',
        data: {
            recaptcha: $("#g-recaptcha-response").val()
        },
        success: function (data) {
            switch (data) {
                case 0:
                    console.log("자동 가입 방지 봇 통과");
                    captcha = 0;
                    $('.loginform').submit();
                    break;
                case 1:
                    alert("자동 가입 방지 봇을 확인 한뒤 진행 해 주세요.");
                    break;
                default:
                    alert("자동 가입 방지 봇을 실행 하던 중 오류가 발생 했습니다. [Error bot Code : " + Number(data) + "]");
                    break;
            }
        }
    });
    if (captcha != 0) {
        return false;
    }
}