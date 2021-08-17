<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<link href="/css/user/mypage.css" rel="stylesheet">
<link href="/css/user/mypagePoster.css" rel="stylesheet">
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal" />
    <div class="mypage_wrapper" data-my-iuser="${profile.iuser}">
        <div class="mypage_container">
            <div class="profile_header">
                <a href="/user/profileMod" class="profile_img">
                    <c:choose>
                        <c:when test="${profile.mainProfile == null}">
                            <img src="/img/default.png">
                        </c:when>
                        <c:otherwise>
                            <img src="/pic/profile/${profile.iuser}/${profile.mainProfile}">
                        </c:otherwise>
                    </c:choose>
                </a>
                <div class="profile_info">
                    <div class="profile_info_name">${profile.nm}</div>
                    <%--팔로워할곳--%>
                    <div class="follow_modal_container">
                        <div class="poster_container">
                            <span>포스터</span>
                            <span>${profile.postercnt}</span>
                        </div>
                        <div class="follower_container">
                            <span>팔로워</span>
                            <span>${profile.cntFollower}</span>
                        </div>
                        <div class="follow_container">
                            <span>팔로우</span>
                            <span>${profile.cntFollow}</span>
                        </div>
                        <c:if test="${profile.iuser != principal.user.iuser}">
                            <div class="follow_btn_box" data-to-iuser="${profile.iuser}">
                                <div class="follow_btn">팔로우</div>
                                <div class="unfollow_btn">언팔로우</div>
                                <div class="refollow_btn">맞팔로우</div>
                            </div>
                        </c:if>
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
        <div class="modal-follow hidden">
            <div>
                <div class="modal_container">
                    <i id="modal-follow-close" class="modal_close fas fa-times"></i>
                    <div class="modal_container_top">
                        <div id="title">팔로우</div>
                    </div>
                    <hr>
                    <div class="followCont"></div>
                </div>
            </div>
        </div>
    </div>
</sec:authorize>
<script src="/js/common/infiniteScroll.js"></script>
<script src="/js/user/mypage.js"></script>