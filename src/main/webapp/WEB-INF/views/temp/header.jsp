<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/common/header.css">
<script defer src="/js/common/common.js"></script>
    <!-- 로그인하지 않은 모든 사용자(로그인 중인 사용자에게는 보이지 않음) -->
    <sec:authorize access="isAnonymous()">
        <div class="header_container">
            <div class="header_left">
                <a href="/"><img class="logo" src="/img/왓챠로고/wachacha.png"></a>
            </div>
            <c:choose>
                <c:when test="${empty loginForm}">
                    <div class="header_right">
                        <a  class="loginBtn" href="/loginForm">로그인</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="header_right">
                        <a  class="loginBtn" href="/joinForm">회원가입</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </sec:authorize>

    <!-- 로그인 중인 사용자 -->
    <sec:authorize access="isAuthenticated()">
        <div class="header_container">
            <div class="header_left">
                <a href="/main/mainpage"><img class="logo" src="/img/왓챠로고/wachacha.png"></a>
            </div>
            <div class="header_right">
                <a  class="loginBtn" href="/logout">로그아웃</a>
            </div>
        </div>
    </sec:authorize>
