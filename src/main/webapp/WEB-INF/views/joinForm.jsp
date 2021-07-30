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
<%--            <div class="joinForm footer">--%>
<%--                <label>--%>
<%--                    <input class="upper" type="checkbox" required placeholder="전체약간에 동의합니다."> <br>--%>
<%--                </label>--%>
<%--                <label>--%>
<%--                    <input type="checkbox"  required> 왓챠와 넷플릭스 그리고 유튜브 프로젝트입니다.<br>--%>
<%--                </label>--%>
<%--                <label>--%>
<%--                    <input type="checkbox" required> 왓차차 서비스 이용약간에 동의합니다.(필수)<br>--%>
<%--                </label>--%>
<%--                <label>--%>
<%--                    <input class="bottom" type="checkbox"  required> 개인정보수집에 동의합니다.(필수)<br>--%>
<%--                </label>--%>
<%--            </div>--%>
        </div>
    </div>
<script src="js/joinForm.js"></script>