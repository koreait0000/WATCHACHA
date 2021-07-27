<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/css/user/loginForm.css">
<script src='https://www.google.com/recaptcha/api.js'></script>
    <div class="black_background">
    </div>
    <div class="bg_black">
        <div class="loginModal">
            <div class="modalHeader">
                <h3>로그인</h3>
                <P>비밀번호를 잊어버리셨나요?</P>
            </div>
            <c:if test="${auth eq 0 }"><span>이메일 인증을 해주세요.</span></c:if>
            <c:if test="${auth eq 1 }"><span>이메일 인증이 완료되었습니다.</span></c:if>
            <form class="loginform" action="/login" method="post">
                <input class="upper" type="text" name="email" placeholder="  이메일(example@gamil.com)">
                <input class="down" type="password" name="password" placeholder="  비밀번호">
                <br>
                <div id="recaptcha" class="g-recaptcha" data-sitekey="6Lf-IYQbAAAAAGNjne1KZ2lqMRe9KC_xw1pOVPlo" data-callback="recaptchaCallback"></div>
                <button class="loginBtn" onclick="return doLogin();">로그인</button>
            </form>

            <h3 class="Another">다른방법으로 로그인하기</h3>
            <div class="oauthLogin">
                <a href="/oauth2/authorization/google"><img src="/img/home/login/구글로그인.png"></a>
                <a href="/oauth2/authorization/facebook"><img src="/img/home/login/페이스북로그인.png"></a>
                <a href="/oauth2/authorization/naver"><img src="/img/home/login/네이버로그인.png"></a>
                <a href="/oauth2/authorization/kakao"><img src="/img/home/login/카카오로그인.png"></a>
            </div>
        </div>
    </div>

<script>
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
                            $.ajax({
                                url: '/login',
                                type: 'post',
                                data: {
                                    email
                                },
                                success: () =>{
                                    location.href='/main/mainpage';
                                }
                            });
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
</script>

