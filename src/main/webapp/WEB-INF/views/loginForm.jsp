<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/user/loginForm.css">
    <div class="black_background">
    </div>
    <div class="bg_black">
        <div class="loginModal">
            <div class="modalHeader">
                <h3>로그인</h3>
                <P>비밀번호를 잊어버리셨나요?</P>
            </div>

            <form action="/login" method="post">
                <input class="upper" type="text" name="username" placeholder="  이메일(example@gamil.com)">
                <input class="down" type="password" name="password" placeholder="  비밀번호">
                <br>
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


