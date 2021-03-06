<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%--info창--%>
<link href="/css/movie/detail.css" rel="stylesheet">
<link rel="stylesheet" href="/css/common/chat.css">
<script defer src="/js/movie/detail.js"></script>
<div class="bg_detail" style="background-image:linear-gradient( rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7) ), url(${movie.bg_url});"> <!--배경화면-->
    <div class="wrapper">
        <div class="test">
            <div class="search">
                <div class="search_bar">
                    <i class="fas fa-search"></i>
                    <form action="/main/searchResult" method="get" autofocus>
                        <input type="text" name="searchbar" placeholder="search">
                        <button></button>
                    </form>
                </div>
            </div>
        </div>
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
                        <div class="movie_spec_outline" data-genre="${movie.spec.outline}">${movie.spec.outline}</div> <!-- 흥행 !-->
                    </c:if>
                </div>
                <div class="info_modal_footer">
                    <div class="movie_play_btn">
                        <i class="fas fa-play-circle"> 재생</i>
                    </div>
                    <div class="movie_fav"
                         data-genre="${movie.genre}" data-nation="${movie.nation}"
                         data-poster="${movie.poster}">
                        <div class="movie_love">
                            <c:if test="${movieFav == 0}">
                                <i class="fas fa-plus"> 보고싶어요</i>
                            </c:if>
                        </div>
                        <div class="movie_hate">
                            <c:if test="${movieFav == 1}">
                                <i class="fas fa-check-circle"> 보고싶어요</i>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%--리뷰영상 모달--%>
        <div class="preview_modal hidden">
            <div class="preview_modal_video">
                <div class="preview_modal_container">
                    <div class="preview_modal_header"><div class="modal_close"><i class="fas fa-times"></i></div></div>
                    <div class="preview_modal_section">
                        <iframe width="1130px" height="673px" src="${movie.previewUrl}" title="${movie.name}" frameborder="0" allowfullscreen ></iframe>
                        <%--채팅창--%>
                        <section>
                            <div id="chatDiv"class="hidden">
                                <div class="chatDiv_container">
                                    <div class="chatDiv_section">
                                        <div id="msgArea" data-username="${username}"></div> <%--문자열이 찍히는공간--%>
                                        <div class="col-6"> <%--보내는곳--%>
                                            <div class="input-group mb-3">
                                                <input type="text" id="msg" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2">
                                                <div class="input-group-append">
                                                    <button class="btn btn-outline-secondary" type="button" id="button-send">전송</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        </div>

        <%--youtube 모달창--%>
        <div class="centerContainer">
            <div class="youtube_modal hidden">
                <div class="loading">
                    <div class="loading-dots">
                        <div class="bounce"></div>
                        <div class="bounce2"></div>
                        <div class="bounce3"></div>
                    </div>
                </div>
                <%--로딩창--%>
                <div class="movie_review_Object">
                    <button class="prev hidden" data-keyword="${param.keyword}">
                        <i class="fas fa-arrow-circle-left"></i>
                    </button>
                    <button class="next hidden" data-keyword="${param.keyword}">
                        <i class="fas fa-arrow-circle-right"></i>
                    </button>
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
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.2/sockjs.min.js"></script>
<script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
<script src="/js/common/chat.js"></script>
