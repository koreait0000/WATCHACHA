<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<link href="/css/user/profileMod.css" rel="stylesheet">
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal" />
    <div class="profileMod_wrapper">
        <div class="profileMod_container">
            <div class="profileMod_container_header"><h1>프로필 수정</h1></div>
            <div class="profileMod_container_center">
                <div class="profileMod_container_left">
                    <!--프로필의 iuser 값이랑 세션의 iuser값이 같아야한다. -->
                    <form action="/user/modProfile" method="post" enctype="multipart/form-data">
                        <c:choose>
                            <c:when test="${principal.user.mainProfile == null}">
                                <img src="/img/default.png">
                            </c:when>
                            <c:otherwise>
                                <img src="/pic/profile/${principal.user.iuser}/${principal.user.mainProfile}">
                            </c:otherwise>
                        </c:choose>
                        <br>
                        <input type="file" name="file" multiple accept="image/*" >
                        <input type="submit" value="완료" style="color: white">
                    </form>
                </div>
                <div class="profileMod_container_right"></div>
            </div>
            <div class="profileMod_container_footer">
                <div class="resetBtn">수정</div>
            </div>
        </div>
    </div>
</sec:authorize>
<script src="/js/user/profileMod.js"></script>