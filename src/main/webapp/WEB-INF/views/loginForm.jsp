<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>로그인페이지</h1>
<hr/>

<c:if test="${param.error}">
    Invalid Email and password.
</c:if>

<form action="/login" method="post">
    <input type="text" name="username" placeholder="Email"><br>
    <input type="password" name="password" placeholder="PASSWORD"><br>
    <button>로그인</button>
</form>

<a href="/oauth2/authorization/google">구글로그인</a>
<a href="/oauth2/authorization/facebook">페이스북로그인</a>
<a href="/oauth2/authorization/naver">네이버로그인</a>

<a href="/joinForm">회원가입</a>