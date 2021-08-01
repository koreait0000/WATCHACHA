<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/main/searchResult.css">
<div class="web_wapper">
    <div class="searchResultHeader"></div>
        <div class="searchResult_Param">
            <span class="param_searchbar">'${param.get("searchbar")}'</span>
            <c:if test="${!empty test.poster}">
                <span class="param_searchbar2">검색결과</span>
            </c:if>
            <c:if test="${empty test.poster}">
                <span class="param_searchbar2">검색결과가 없습니다.</span>
                <div class="falesWapper">
                    <div class="falesWapper_center">
                        <div><img src="/img/main/searchResult/image 1.png"></div>
                        <h2>헤헤헷 검색결과가 없습니다.</h2>
                    </div>
                </div>
            </c:if>
        </div>

    <c:if test="${!empty test.poster}">
        <div class="searchMovie">
            <div class="movie_Object">
                <a href="/movie/detail?keyword=${test.name}&page=0">
                    <div><img src="<c:out value="${test.poster}"></c:out>"></div>
                    <div><c:out value="${test.name}"></c:out></div>
                </a>
            </div>
        </div>
        <%--연관 검색 결과--%>
        <div class="searchMovie_movie_relevant">
            <div class="searchResult_Param">
                <span class="param_searchbar">'${param.get("searchbar")}'</span>
                <span class="param_searchbar2">와 비슷한 장르에요.</span>
            </div>
            <div class="movie_relevant">
                <div class="movie_relevant1">
                    <c:forEach var="i" items="${test.relevant}">
                        <div class="movie_relevant2">
                            <a href="/movie/detail?keyword=${i.relevantName}&page=0">
                                <div><img src="<c:out value="${i.relevantLink}"></c:out>"></div>
<%--                                TODO:아래 span태그 왜 넣었는지? -현민- --%>
                                <span class="movie_relevant_name"><h4><c:out value="${i.relevantName}"></c:out></h4></span>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </c:if>
</div>