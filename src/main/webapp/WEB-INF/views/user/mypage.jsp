<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<link href="/css/user/mypage.css" rel="stylesheet">
<link href="/css/user/mypagePoster.css" rel="stylesheet">
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal" />
    <div class="mypage_wrapper">
        <div class="mypage_container">
            <div class="profile_header">
                <a href="/user/profileMod" class="profile_img">
                    <c:choose>
                        <c:when test="${principal.user.mainProfile == null}">
                            <img src="/img/default.png">
                        </c:when>
                        <c:otherwise>
                            <img src="/pic/profile/${principal.user.iuser}/${principal.user.mainProfile}">
                        </c:otherwise>
                    </c:choose>
                </a>
                <div class="profile_info">
                    <div class="profile_info_name">${principal.user.nm}</div>
                    <%--팔로워할곳--%>
                    <div class="">
                        <div class="follow_btn">팔로우</div>
                        <div class="unfollow_btn">언팔로우</div>
                    </div>
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
            <div class="myFavList_container">
                <div class="profile_myFavList"></div>
            </div>

                <%-----------------------------profile_myFavList끝----------------------%>

        </div>
    </div>
</sec:authorize>
<script src="/js/common/infiniteScroll.js"></script>
<script src="/js/user/mypage.js"></script>