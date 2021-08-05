<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/main/mainpage.css">

<div class="web_wapper">
    <div class="movieInfoSection">
        <br>
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
            <div class="saerch">
                <div class="search_bar">
                    <i class="fas fa-search"></i>
                    <form action="/main/searchResult" method="get" autofocus>
                        <label><input type="text" name="searchbar" placeholder="search"></label>
                        <button></button>
                    </form>
                </div>
            </div>
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="movie_info_section_second">
                            <div class="WATCHACHA_section">
                                <div class="WATCHACHA_section_Logo"><h1>WATCAHCAH</h1></div>
                                <div class="testtesttest">
                                    <h3>다양하고 새로운 영화 정보들을 이곳에서 즐기세요.<br>
                                        해당 페이지는 실시간 업데이트 됩니다. </h3>
                                    <P>여러 유튜버들의 리뷰 영상을 이곳에서 간편하게 즐기세요.</P>
                                </div>
                            </div>
                    </div>
<%--                    <div class="movie_info_section_first">--%>
<%--                        <div class="movie_info_section1">--%>

<%--                        </div>--%>
<%--                    </div>--%>
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                </div>

                <div class="carousel-item">
                    <div class="movie_info_section_second">
                        <div class="WATCHACHA_section">
                            <div class="WATCHACHA_section_Logo">
                                <h1>WATCAHCAH</h1>
                                <div class="WATCHACHA_section_Logo_description">
                                    <h3>다양하고 새로운 영화 정보들을 이곳에서 즐기세요.<br>
                                        해당 페이지는 실시간 업데이트 됩니다. </h3>
                                    <P>여러 유튜버들의 리뷰 영상을 이곳에서 간편하게 즐기세요.</P>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                </div>

                <div class="carousel-item">
                    <div class="movie_info_section_third">

                    </div>
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div><%--End movieInfoSection--%>

<%--        <div class="test">--%>
<%--            <div class="innerTest1"></div>--%>
<%--            <div class="innerTest2"></div>--%>
<%--            <div class="innerTest3"></div>--%>
<%--        </div>--%>
        <%--박스오피스랭킹--%>
        <div class="Box__Office__Ranking">
            <div class="Box__Office__Ranking__header">
                <i class="fas fa-ticket-alt"></i>
                <h4>Box Office Rankings</h4>
            </div>
            <hr>
            <div class="Box__Office__poster">
                <c:forEach var="i" items="${map.rankPoster}" varStatus="status">
                    <div class="item">
                        <a href="/movie/detail?keyword=${map.name[status.index]}&page=0">
                            <div class="Box__Office__poster1">
                                <img src="<c:out value="${i}"></c:out>">
                                <div class="Box__Office__poster__info">
                                    <span style="color: #FFFFFF"><c:out value="${map.name[status.index]}"></c:out></span><br>
                                    <span style="color: #FFFFFF"><c:out value="${map.open[status.index]}"></c:out></span>
                                    <span style="color: yellow">
                                       <i class="fas fa-star"><c:out value="${map.chart_num[status.index]}"></c:out></i>
                                   </span>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div><%--End of BoxOfficeRanking--%>

        <%-- 팔로워들 영화추천 --%>
        <div class="Box__Office__Ranking">
            <div class="Box__Office__Ranking1">
                <i class="fas fa-ticket-alt"></i>
                <h4>추천 Movie</h4>
            </div>
            <hr><%--줄밑부분--%>
            <%--회원들 좋아하는 영상리스트를 뿌릴거임--%>
            <div class="follower_fav_movie">
                <c:forEach  begin="1" end="3" step="1" varStatus="status">
                    <div class="follower_personal_fav">
                        <h4 style="color: #FFFFFF">누구누구 님이 좋아하는 영화</h4>
                            <%--반복문이 돌아가는곳--%>
                        <c:forEach  begin="1" end="5" step="1" varStatus="status">
                            <div class="personal_movie">
                                <img>
                                <span>제목</span>
                            </div>
                        </c:forEach>
                            <%--반복문이 끝나는곳--%>
                    </div>
                </c:forEach>
                <%--회원들이 좋아하는리스트 반복문 끝나는 곳 --%>
            </div>
        </div>
</div><%--End web_wapper--%>
<script src="/js/mainpage.js"></script>