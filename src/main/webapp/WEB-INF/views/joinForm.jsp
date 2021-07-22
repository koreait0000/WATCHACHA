<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/user/joinForm.css">

    <div class="black_background">
    </div>
    <div class="bg_black">
        <div class="loginModal">
            <div class="modalHeader">
                <h3>회원가입</h3>
            </div>

            <form action="/join" method="post">
                <input  class="upper" type="text" name="nm" placeholder="  이름(2자이상)" required autofocus><br>
                <input type="email" name="email" placeholder="  이메일(example@gamil.com)" required><br>
                <input type="password" name="pw" placeholder="  영문,숫자,특문 중 2개 조합 이상" required><br>
                <input class="down" type="text" name="tel" placeholder="  전화번호" required><br>
                <br>
                <input class="loginBtn" type="submit" value="회원가입">
            </form>
            <div class="joinForm footer">
                <label>
                    <input class="upper" type="checkbox" required placeholder="전체약간에 동의합니다."> <br>
                </label>
                <label>
                    <input type="checkbox"  required> 왓챠와 넷플릭스 그리고 유튜브 프로젝트입니다.<br>
                </label>
                <label>
                    <input type="checkbox" required> 왓차차 서비스 이용약간에 동의합니다.(필수)<br>
                </label>
                <label>
                    <input class="bottom" type="checkbox"  required> 개인정보수집에 동의합니다.(필수)<br>
                </label>
            </div>
        </div>
    </div>


