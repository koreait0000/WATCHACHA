<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--info창--%>
<link href="/css/movie/detail.css" rel="stylesheet">
<div class="bg_detail" style="background-image:linear-gradient( rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7) ), url(${movie.bg_url});"> <!--배경화면-->


        <div class="info_modal"> <!-- 인포 !-->
            <div class="info_modal_section">
                <div class="movie_nm">${movie.name}</div> <!-- 영화 제목 !-->
                <div class="nm_star">
                    <div class="movie_engName">${movie.engName}</div> <!-- 영화 영어부제목 !-->
                    <div class="movie_star">평점 ${movie.star}</div> <!-- 평점(별점) !-->
                </div>

                <c:if test="${!empty movie.summary.title}">
                    <div class="movie_summary_title"><c:out value="${movie.summary.title}"></c:out></div> <!-- 줄거리 제목 !-->
                </c:if>
                <div class="movie_summary_content"><c:out value="${movie.summary.content}"></c:out></div><!-- 줄거리 내용 !-->

                <div class="movie_outline_Div"> <!-- 영화 개요부분 !-->
                    <%--<div>${movie.spec.outline}</div> <!-- 개요 !-->--%>
                    <div class="movie_spec_director">감독  ${movie.spec.director}</div> <!-- 감독 !-->
                    <div class="movie_spec_appearance">배우  ${movie.spec.appearance}</div> <!-- 출연 !-->
                    <div class="movie_spec_rank">${movie.spec.rank}</div> <!-- 등급 !-->
                    <c:if test="${!empty movie.spec.outline}">
                        <div class="movie_spec_outline">${movie.spec.outline}</div> <!-- 흥행 !-->
                    </c:if>
                </div>
                <div class="info_modal_footer">
                    <div class="movie_play_btn">
                        <a href="#"><i class="fas fa-play-circle"> 재생</i></a>
                    </div>
                    <div class="movie_fav">
                        <a href="#"><i class="fas fa-plus"> 보고싶어요</i></a>
                    </div>
                </div>
            </div>
        </div>
    <div class="loading"><img src="/img/loading.gif"></div>

    <%--youtube 모달창--%>
    <div class="centerContainer">
        <div class="youtube_modal hidden">
            <div class="movie_review_Object">
                <button class="prev" data-keyword="${param.keyword}">
                    <i class="fas fa-arrow-circle-left"></i>
                </button>
                <button class="next" data-keyword="${param.keyword}">
                    <i class="fas fa-arrow-circle-right"></i>
                </button>
                <c:forEach var="i" items="${youtube.hrefList}" varStatus="status">
                    <div class="item">
                        <a href="<c:out value="${i}"></c:out>" target="_blank"><img src="${youtube.ImgList[status.index]}"width="300px" height="200px">
                            <div class="txt_post">
                                <div class="txt_post_header">
                                    <c:out value="${youtube.writerList[status.index]}"></c:out>
                                    <c:out value="${youtube.cntList[status.index]}"></c:out><br>
                                </div>
                                <div class="txt_post_section">
                                    <c:out value="${youtube.titleList[status.index]}"></c:out>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <div class="episode_modal hidden">
        <h1>에피소드 모달임</h1>
    </div>

    <%--info, youtube 모달 on/off 버튼--%>
    <div class="modal_btn">
        <ul>
            <li><span class="step_1"><i class="fas fa-info-circle"></i>Info</span></li>
            <li><span class="step_2"><i class="fab fa-youtube"></i>Youtube</span></li>
            <li><span class="step_3">Episode</span></li>
        </ul>
    </div>
</div>
<script src="/js/movie/detail.js"></script>