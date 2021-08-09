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
                <div class="profile_img"></div>
                <div class="profile_info">
                    <div class="profile_info_name">${principal.user.nm}</div>
                    <%--팔로워할곳--%>
                    <div class="">팔로워뿌릴곳</div>
                </div>
            </div>
                <%-----------------------------profile_header끝----------------------%>

            <div class="profile_search">
                <form>
                    <input type="text" placeholder="Search...">
                    <input type="submit" hidden>
                </form>
            </div>
                <%-----------------------------profile_search끝----------------------%>

            <div class="profile_myFavList">
                <div class="myfavMovie_List">
                    <c:forEach  begin="1" end="5" step="1" varStatus="status">
                        <div class="myfav_movie">
                            <img>
                            <span>제목</span>
                            <div class="myfav_movie_hover">
                                <i class="fas fa-play-circle"></i>
                                <div class="myfav_movie_footer">
                                    <i class="fas fa-heart"></i>
                                    <h5>평점</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="profile_myFavList">
                <div class="myfavMovie_List">
                    <c:forEach  begin="1" end="5" step="1" varStatus="status">
                        <div class="myfav_movie">
                            <img>
                            <span>제목</span>
                            <div class="myfav_movie_hover">
                                <i class="fas fa-play-circle"></i>
                                <div class="myfav_movie_footer">
                                    <i class="fas fa-heart"></i>
                                    <h5>평점</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="profile_myFavList">
                <div class="myfavMovie_List">
                    <c:forEach  begin="1" end="5" step="1" varStatus="status">
                        <div class="myfav_movie">
                            <img>
                            <div class="myfav_movie_hover">
                                <i class="fas fa-play-circle"></i>
                                <div class="myfav_movie_footer">
                                    <i class="fas fa-heart"></i>
                                    <h5>평점</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
                <%-----------------------------profile_myFavList끝----------------------%>

        </div>
    </div>
</sec:authorize>
<script src="/js/user/mypage.js"></script>