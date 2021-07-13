<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
     header{ height: 100px; background-color:lightgray; border-bottom: 1px solid rgb(73, 73, 73);}
    .header_container{ display: flex; justify-content: space-between; margin: 0 2%; }
    .header_left>img{ width: 140px; margin-top: 10px;}
    .header_right{padding-top: 30px; display: flex;}
    .header_right a{text-decoration: none;
        font-family: "Noto Sans KR", sans-serif;
        font-weight: bold;
        font-size: 14.7px;
        color: rgb(27, 27, 27);
        width: 106px;
        padding: 12px 0px;
        border-radius: 213px;
        background-color: #fff;
        text-align: center;
    }
</style>
<header>
    <div class="header_container">
        <div class="header_left">
            <!-- 왓챠로고 -->
            <img class="logo" src="../img/왓챠로고/wachacha.png">
        </div>

        <div class="header_right">
            <a  class="loginBtn" href="#">로그인</a>
        </div>
    </div>
</header>