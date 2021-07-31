<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--info창--%>
<link href="/css/movie/detail.css" rel="stylesheet">
<div class="bg_detail" style="background-image: url(${movie.bg_url});">
    <div class="info_modal"> <!-- 인포 !-->
        <div>${movie.name}</div> <!-- 영화 제목 !-->
        <div>${movie.engName}</div> <!-- 영화 영어부제목 !-->
        <div>${movie.star}</div> <!-- 평점(별점) !-->
        <div> <!-- 영화 개요부분 !-->
            <div>${movie.spec.outline}</div> <!-- 개요 !-->
            <div>${movie.spec.director}</div> <!-- 감독 !-->
            <div>${movie.spec.appearance}</div> <!-- 출연 !-->
            <div>${movie.spec.rank}</div> <!-- 등급 !-->
            <c:if test="${!empty movie.spec.outline}">
                <div>${movie.spec.outline}</div> <!-- 흥행 !-->
            </c:if>
        </div>

        <c:if test="${!empty movie.summary.title}">
            <div><c:out value="${movie.summary.title}"></c:out></div> <!-- 줄거리 제목 !-->
        </c:if>
        <div><c:out value="${movie.summary.content}"></c:out></div><!-- 줄거리 내용 !-->
    </div>
    <%--youtube 모달창--%>
    <div class="youtube_modal hidden">
        <c:forEach var="i" items="${hrefList}" varStatus="status">
            <a href="<c:out value="${i}"></c:out>"><img src="${ImgList[status.index]}" width="500px" height="300px"><br>
                <c:out value="${writerList[status.index]}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${cntList[status.index]}"></c:out><br>
                <c:out value="${titleList[status.index]}"></c:out>
            </a><br>
        </c:forEach>
    </div>
    <%--info, youtube 모달 on/off 버튼--%>
    <div>
        <ul>
            <li><span class="step_1">Info</span></li>
            <li><span class="step_2 cursor">Youtube</span></li>
        </ul>
    </div>
</div>
<script src="/js/movie/detail.js"></script>