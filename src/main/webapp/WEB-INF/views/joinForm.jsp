<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>회원가입페이지</h1>
<hr/>
<form action="/join" method="post">
    <input type="text" name="nm" placeholder="USERNAME"><br>
    <input type="password" name="pw" placeholder="PASSWORD"><br>
    <input type="email" name="email" placeholder="EMAIL"><br>
    <input type="text" name="tel" placeholder="TELEPHONE"><br>
    <button>회원가입</button>
</form>