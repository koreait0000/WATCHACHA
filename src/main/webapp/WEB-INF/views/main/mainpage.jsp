<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/main/mainpage.css">

<div class="web_wapper">
    <div class="movieInfoSection">
        <br>
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="/img/main/mainpage/1.jpg" class="d-block w-200" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>First slide label</h5>
                        <p>Some representative placeholder content for the first slide.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="..." class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Second slide label</h5>
                        <p>Some representative placeholder content for the second slide.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="..." class="d-block w-100" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Third slide label</h5>
                        <p>Some representative placeholder content for the third slide.</p>
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
<%--        <div class="search_bar">--%>
<%--            <i class="fas fa-search"></i>--%>
<%--            <form class="search_form" action="searchResult" method="get">--%>
<%--                <input type="text" name="searchbar"autofocus placeholder="search">--%>
<%--                <button></button>--%>
<%--            </form>--%>
<%--        </div>--%>

<%--        <div class="web_header">--%>
<%--            <div class="movie__section">--%>
<%--                <h2>미나리</h2>--%>
<%--                <p>Minari  2021  Drama</p>--%>
<%--                <p>최근 한달간 시청률 상위 5%작품</p>--%>
<%--                <p>--%>
<%--                    “미나리는 어디서든 잘 자라” 낯선 미국, 아칸소로 떠나온 한국가족들에게 뭔가 해내는--%>
<%--                    걸 보여주고 싶은 아빠 ‘제이콥’ 은 자신만의 농장을 가꾸기 시작하고 엄마 ‘모니카’도--%>
<%--                    다시 일자리를 찾는다. 아직 어린아이들을 위해 모니카의 엄마 순자가 함께 살기로 하고--%>
<%--                    가방 가득 고춧가루, 멸치, 한약 그리 고 미나리를 담은 할머니가 도착한다.--%>
<%--                </p>--%>
<%--                <P>--%>
<%--                    감독 정이삭<br>--%>
<%--                    출연 윤여정,스티브연,한예리<br>--%>
<%--                    드라마 | 미국 | 2021년<br>--%>
<%--                </P>--%>

<%--                <button class="playbutton">--%>
<%--                    <i class="fas fa-play-circle"></i>--%>
<%--                    <h4>재생</h4>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div><%--End movieInfoSection--%>


        <%--박스오피스랭킹--%>
        <div class="Box__Office__Ranking">
            <div class="Box__Office__Ranking1">
                <i class="fas fa-ticket-alt"></i>
                <h4>Box Office Rankings</h4>
            </div>
            <hr>
            <div class="Box__Office__poster">
                <c:forEach var="i" items="${map.rankPoster}" varStatus="status">
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