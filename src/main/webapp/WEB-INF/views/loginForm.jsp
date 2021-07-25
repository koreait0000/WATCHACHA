<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <form class="loginform" action="/login" method="post">
                <input class="upper" type="text" name="username" placeholder="  이메일(example@gamil.com)">
                <input class="down" type="password" name="password" placeholder="  비밀번호">
                <br>
                <div id="recaptcha" class="g-recaptcha" data-sitekey="6Lf-IYQbAAAAAGNjne1KZ2lqMRe9KC_xw1pOVPlo" data-callback="recaptchaCallback"></div>
                <input class="loginBtn" type="submit" value="로그인">
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
    var isRecaptchachecked=false;

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
        let id = $(".upper").val();
        let password = $(".down").val();

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
            alert('리캡차 인증 체크를 해주세요.');
            $("#recaptcha").focus();
            return false;
        }

        doVaildRecaptcha();
    }

    function recaptchaCallback(){// 리캡챠 체크 박스 클릭시 isRecaptchachecked 값이 true로 변경

        isRecaptchachecked = true;

    }


    function doVaildRecaptcha(){
        var formData= $(".loginform").serialize();
        $.ajax({
            type: 'POST',
            contentType: "application/x-www-form-urlencoded",
            url:'/valid-recaptcha',
            data: formData,
            dataType: 'text',
            cache : false,
            success: function(data){
                if(data == 'success'){
                    console.log(data);
                    console.log('리캡챠 성공!');
                    $('#loginForm').submit(); //리캡쳐 성공후 로그인 id,pw 체킹 (security 사용)
                }
                else{
                    alert('인증되지 않은 주소입니다.');
                }
            },
            error:function(xhr,status,error){
                console.log(error);
            }
        });
    }
</script>

