<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/user/joinForm.css">

    <div class="black_background">
    </div>
    <div class="bg_black">
        <div class="loginModal">
            <div class="modalHeader">
                <h3>회원가입</h3>
            </div>

            <form action="/join" id="form" method="post">
                <input  class="upper" type="text" name="nm" placeholder="  이름(2자이상)" required autofocus><br>
                <input type="email" name="email" placeholder="  이메일(example@gamil.com)" required><br>
                <input type="password" name="pw" placeholder="  비밀번호" required><br>
                <input class="down" type="tel" name="tel" placeholder="  전화번호" required><br>
                <br>
                <button class="loginBtn" onclick="return joinCheck();">회원가입</button>
            </form>
        </div>
    </div>
<script src="js/joinForm.js"></script>