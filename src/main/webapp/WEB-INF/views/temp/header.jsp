<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<link rel="stylesheet" href="/css/common/header.css">
<script defer src="/js/common/common.js"></script>

<header>
    <div class="header_container">
        <div class="header_left">
            <!-- 왓챠로고 -->
            <a href="/">
                <img class="logo" src="/img/왓챠로고/wachacha.png">
            </a>
        </div>
        <!-- 로그인하지 않은 모든 사용자(로그인 중인 사용자에게는 보이지 않음) -->
        <sec:authorize access="isAnonymous()">
            <div class="header_right">
                <a  class="loginBtn" href="/loginForm">
                    로그인
                </a>
            </div>
        </sec:authorize>

        <!-- 로그인 중인 사용자 -->
        <sec:authorize access="isAuthenticated()">
            <div>
                <ul>
                    <li>홈</li>
                </ul>
            </div>
            <div class="header_right">
                <a  class="loginBtn" href="/logout">
                    로그아웃
                </a>
            </div>

        </sec:authorize>

<%--        <div class="header_right">--%>
<%--            <a  class="loginBtn" href="#">--%>
<%--                <h4>로그인</h4>--%>
<%--            </a>--%>
<%--        </div>--%>
    </div>

</header>

