<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<link href="/css/user/profileMod.css" rel="stylesheet">
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal" />
    <div class="profileMod_wrapper">
        <div class="profileMod_container">
            <!--프로필의 iuser 값이랑 세션의 iuser값이 같아야한다. -->
            <form action="/user/modProfile" method="post" enctype="multipart/form-data">
                myprofile
                <img src="/pic/profile/{iuser}/{img}(iuser=${principal.user.iuser}, img=${principal.user.mainProfile})">
                <br>
                이미지 : <input type="file" name="file" multiple accept="image/*" >
                <input type="submit" value="완료" style="color: white">
                <input type="reset" value="수정" style="color: white">
            </form>
        </div>
    </div>
</sec:authorize>
<script src="/js/user/profileMod.js"></script>