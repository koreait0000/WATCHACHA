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
                    <c:if test="${profile.iuser != principal.user.iuser}">
                        <div class="follow_btn_box" data-to-iuser="${profile.iuser}">
                            <div class="follow_btn">구독하기</div>
                            <div class="unfollow_btn">구독취소하기</div>
                            <div class="refollow_btn">구독하기</div>
                        </div>
                    </c:if>
                    <%--팔로워할곳--%>
                    <div class="follow_modal_container">
                        <div class="poster_container">
                            <span>${profile.postercnt}</span>
                            <span style="font-weight: normal">MyList</span>
                        </div>
                        <div class="follower_container">
                            <span>${profile.cntFollower}</span>
                            <span style="font-weight: normal">팔로워</span>
                        </div>
                        <div class="follow_container">
                            <span>${profile.cntFollow}</span>
                            <span style="font-weight: normal">팔로우</span>
                        </div>
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

            <div class="movie_option">
                <select id="movie_nation">
                    <option value="">국가</option>
                    <option value="">인도</option>
                    <option value="">일본</option>
                    <option value="">영국</option>
                    <option value="">스페인</option>
                    <option value="">캐나다</option>
                    <option value="">대만</option>
                    <option value="">이탈리아</option>
                    <option value="">중국</option>
                    <option value="">미국</option>
                    <option value="">한국</option>
                </select>
                <select id="movie_gerne">
                    <option value="">장르</option>
                    <option value="">TV드라마</option>
                    <option value="">SF</option>
                    <option value="">모험</option>
                    <option value="">가족</option>
                    <option value="">틴에이저</option>
                    <option value="">판타지</option>
                    <option value="">재난</option>
                    <option value="">로맨틱코미디</option>
                    <option value="">스포츠</option>
                    <option value="">서부극</option>
                    <option value="">음악</option>
                    <option value="">전쟁</option>
                    <option value="">미스터리</option>
                </select>
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
                    <div class="comming_soon">
                        <img src="/img/comming.png" width="500rem">

                    </div>
                </div>
            </div>
        </div>
    </div>
</sec:authorize>
<script src="/js/common/infiniteScroll.js"></script>
<script src="/js/user/mypage.js"></script>