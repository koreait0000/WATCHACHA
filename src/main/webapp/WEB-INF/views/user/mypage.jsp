<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<link href="/css/user/mypage.css" rel="stylesheet">
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal" />
    <div class="mypage_wrapper">
        <div class="mypage_container">

            <div class="profile_header">
                <div class="profile_img"><a href="/user/profileMod">프로필수정</a></div>
                <div class="profile_info">
                    <div class="profile_info_name">${principal.user.nm}</div>
                    <%--팔로워할곳--%>
                    <div class="">팔로워뿌릴곳</div>
                </div>
            </div>
                <%-----------------------------profile_header끝----------------------%>

            <div class="profile_search">
                <form>
                    <input id="searchText" type="text" placeholder="Search...">
                    <input type="submit" hidden>
                </form>
            </div>
                <%-----------------------------profile_search끝----------------------%>

            <div class="profile_myFavList"></div>

                <%-----------------------------profile_myFavList끝----------------------%>

        </div>
    </div>
</sec:authorize>
<script src="/js/common/infiniteScroll.js"></script>
<script src="/js/user/mypage.js"></script>