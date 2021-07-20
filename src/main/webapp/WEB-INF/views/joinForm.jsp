<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>회원가입페이지</h1>
<hr/>
<form action="/join" method="post">
    <input type="text" name="nm" placeholder="USERNAME" required autofocus><br>
    <input type="password" name="pw" placeholder="PASSWORD" required><br>
    <input type="email" name="email" placeholder="EMAIL" required><br>
    <input type="text" name="tel" placeholder="TELEPHONE" required><br>
    <button>회원가입</button>
</form>