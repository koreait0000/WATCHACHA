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
                <p id="lossPw">비밀번호를 잊어버리셨나요?</p>
            </div>
            <div class="errorMassage">
                <c:if test="${auth eq 0 }"><span>이메일 인증을 해주세요.</span></c:if>
                <c:if test="${auth eq 1 }"><span>이메일 인증이 완료되었습니다.</span></c:if>
                <c:if test="${param.param ne error}">아이디 또는 비밀번호를 확인해주세요.</c:if>
            </div>
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
<%--    비밀번호 찾기 모달창--%>
    <div id="modal" class="hidden">
        <div class="modal_aline">
            <div class="modal_box">
                <div class="modal_box1">
                    <div class="modal_box1_header">
                        <h3>비밀번호찾기</h3>
                        <i class="fas fa-times"></i>
                    </div>
                    <div class="PasswordErrorMassage"></div>
                        <div id="emailDiv"><input type="email" class="email" name="email" required placeholder="이메일(example@gmail.com)"></div>
                        <button id="sendMail" type="button" class="goAuth">인증번호 발송</button>
                        <div id="authCheck" class="hidden"><label><input class="authCd" type="text" name="auth" required placeholder="인증번호"></label></div>
                        <div id="getPw" class="hidden"><button id="btnGetPw" type="button">비밀번호 찾기</button> </div>
                </div>
            </div>
        </div>
    </div>
<script src="/js/loginForm.js"></script>