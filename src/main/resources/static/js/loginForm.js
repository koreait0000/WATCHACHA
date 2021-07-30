//모달창 on/off, 비밀번호 찾기
let lossPw = document.querySelector('#lossPw');
let modal = document.querySelector('#modal');
let sendMail = document.querySelector('#sendMail');
let authCheck = document.querySelector('#authCheck');
let email = document.querySelector('.email');
let getPw = document.querySelector('#getPw');
let authCd = document.querySelector('.authCd');
let btnGetPw = document.querySelector('#btnGetPw');
let emailDiv = document.querySelector('#emailDiv');
let loginModal = document.querySelector('.loginModal');
let PasswordErrorMassage = document.querySelector('.PasswordErrorMassage');
lossPw.addEventListener('click', () =>{
    modal.classList.remove('hidden'); //모달 on
    loginModal.classList.add('hidden');//로그인창 hide
    sendMail.addEventListener('click', ()=>{
        fetch('/editPw',{
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email.value
            })
        })
            .then(res=>res.json())
            .then(myJson => {
                switch (myJson){
                    case 0:
                        PasswordErrorMassage.innerHTML='<br>존재하지 않는 이메일입니다.';
                        break;
                    case 1:
                        if(PasswordErrorMassage){
                            PasswordErrorMassage.classList.add('hidden');
                        }
                        sendMail.classList.add('hidden');
                        authCheck.classList.remove('hidden');
                        getPw.classList.remove('hidden');
                        fetch('/lossPw?email='+email.value)
                            .then(res => res.json())
                            .then(myJson => {
                                btnGetPw.addEventListener('click',()=>{
                                    if(myJson.auth == authCd.value){
                                        email.readOnly = 'true';
                                        authCd.classList.add('hidden');
                                        getPw.classList.add('hidden');
                                        let divElem = document.createElement('div');
                                        let divElem2 = document.createElement('div');
                                        let pwElem2 = document.createElement('input');
                                        let pwElem = document.createElement('input');
                                        let btnElem = document.createElement('button');
                                        authCheck.classList.add('hidden');
                                        pwElem2.setAttribute('type','text');
                                        pwElem2.setAttribute('name','editPw2');
                                        pwElem2.setAttribute('placeholder','비밀번호 확인');
                                        pwElem2.setAttribute('class', 'pw2')
                                        pwElem.setAttribute('type','text');
                                        pwElem.setAttribute('name','editPw');
                                        pwElem.setAttribute('placeholder','비밀번호');
                                        pwElem.setAttribute('class', 'pw1')
                                        btnElem.setAttribute('type','button');
                                        btnElem.setAttribute('id','editPwBtn');
                                        btnElem.innerText='비밀번호 변경';

                                        divElem.append(pwElem);
                                        divElem2.append(pwElem2);
                                        emailDiv.after(btnElem);
                                        emailDiv.after(divElem2);
                                        emailDiv.after(divElem);
                                        btnElem.addEventListener('click',()=>{
                                            if(pwElem.value === ''){
                                                alert('변경할 비밀번호를 입력해주세요');
                                                return;
                                            }
                                            if(pwElem.value === pwElem2.value){
                                                let data = {
                                                    email : email.value,
                                                    pw : pwElem.value
                                                }
                                                fetch('/editPw',{
                                                    method: 'post',
                                                    headers: {
                                                        'Content-Type': 'application/json'
                                                    },
                                                    body: JSON.stringify(data)
                                                }).then(res => res.json())
                                                    .then(myJson => {
                                                        if(myJson == 1){
                                                            alert('비밀번호가 변경되었습니다.');
                                                            modal.classList.add('hidden');
                                                        }else{
                                                            alert('비밀번호 변경에 실패하였습니다.');
                                                        }
                                                    })
                                            }else{
                                                alert('비밀번호를 확인해주세요.');
                                            }
                                        });
                                    }else{
                                        alert('인증번호를 확인해주세요.');
                                    }
                                });
                            });
                }
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