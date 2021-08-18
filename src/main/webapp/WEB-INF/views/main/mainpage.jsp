<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/main/mainpage.css">
<link rel="stylesheet" href="/css/main/mainRanking.css">
<link rel="stylesheet" href="/css/main/card.css">

<div class="web_wapper">
    <%--movieInfosection--%>
    <div class="movieInfoSection">
        <br>
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
            <div class="saerch">
                <div class="search_bar">
                    <i class="fas fa-search"></i>
                    <form action="/main/searchResult" method="get" autofocus>
                        <input type="text" name="searchbar" placeholder="search">
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
                    <div class="movie_info_section_first">
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
                        <div class="second_info_section">
                            <p class="info_section_first">
                                새로운 영화 정보를 실시간으로 즐기세요.<br>
                                새로운 영화 순위를 보고 예매를 하세요.
                            </p>
                            <p class="info_section_second">
                                저희 왓챠챠에서는 고객의 현명한 영화 선택을 위해 실시간으로<br>
                                영화 순위를 업데이트를하고 해당 영화에 대한 프리뷰, 리뷰 영상등을 <br>
                                준비 해놓습니다.
                            </p>
                            <div class="Ranking_btn"><a href="#1">영화랭킹 보러가기</a></div>
                        </div>
                    </div>
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                </div>

                <div class="carousel-item">
                    <div class="movie_info_section_third">
                        <div class="second_info_section">
                            <p class="info_section_first">
                                Watchacha에서 영화를 추천받아보세요.<br>
                                주위 친구들은 어떤 영화를 좋아할까요.
                            </p>
                            <p class="info_section_second">
                                왓챠챠에서 영화추천을 받아보세요.<br>
                                우리 주위의 영.잘.알들은 어떤 영화를 볼까요.<br>
                                준비해놓을게요.
                            </p>
                            <div class="Ranking_btn"><a href="#2">영화추천 받기</a></div>
                        </div>
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

    <%---------------------------------------------------박스오피스랭킹-------------------------------------------------------------------------------------------%>
    <div class="boxOffice_cotainer" id="1">
    <%---------------------------------------------------박스오피스랭킹-------------------------------------------------------------------------------------------%>
        <div id="hero-slides">
            <div id="header">
                <h4>Box Office Rankings</h4>
            </div>
            <hr>
            <div id="slides-cont">
                <div class="button" id="next"></div>
                <div class="button" id="prev"></div>
                <div id="slides">
                    <c:forEach var="i" items="${map.rankPoster}" varStatus="status">
                        <div class="slide" style="background-image: url(${i});">
                            <div class="number">${status.count}</div>
                            <div class="body">
                                <div class="headline"></div><a href="/movie/detail?keyword=${map.name[status.index]}&page=0">
                                <div class="link"><c:out value="${map.name[status.index]}"></c:out></div></a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div id="next-catch"></div>
                <div id="prev-catch"></div>
            </div>
        </div>
    </div>
    <%-- 팔로워들 영화추천 --%>
    <div class="recomand_movie_container" id="2">
        <div class="recomand_movie">
            <div id="header">
                <h4>'WATCHACHA'의 추천리스트</h4>
            </div>
            <hr>
            <%--회원들 좋아하는 영상리스트를 뿌릴거임--%>
            <div class="follower_fav_movie">
                <c:forEach items="${friends}" var="friend" varStatus="status">
                        <div class="follower_personal_fav">
                            <h4 style="color: #FFFFFF">'${friend[status.index].nm}'님이 좋아하는 영화</h4>
                            <div class="fav_movie">
                                <div class="personal_fav_list">
                                    <c:forEach items="${friend}" var="items">
                                        <div class="page-content">
                                            <div class="card" style="background-image: url(${items.image})">
                                                <div class="content">
                                                    <button class="btn" onclick="location.href='/movie/detail?keyword=${items.title}'">지금보러가기</button>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach><%--반복문이 끝나는곳--%>
                                </div>
                            </div>
                        </div>
                </c:forEach>
                <%--회원들이 좋아하는리스트 반복문 끝나는 곳 --%>
            </div>
        </div>
    </div>
</div><%--End web_wapper--%>
<script src="/js/mainpage.js"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/babel-polyfill/6.26.0/polyfill.min.js'></script>
<script  src="/js/main/mainRanking.js"></script>

