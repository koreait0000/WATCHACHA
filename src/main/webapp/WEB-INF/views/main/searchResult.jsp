<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/main/searchResult.css">
    <div class="web_wapper">
        <div class="searchResultHeader"></div>
        <div>"${param.get("searchbar")}" 검색결과에 대한 영화입니다.</div>
        <div class="searchMovie">
            <div class="movie_Object">
                <img src="<c:out value="${test.poster}"></c:out>"><br>
                <c:out value="${test.name}"></c:out><br>
            </div>
        </div>
        <br>
        <div class="searchMovie_movie_relevant">
            <h2>관련 영화 추천</h2>
            <br>
            <div class="movie_relevant">
                <div class="movie_relevant1">
                    <c:forEach var="i" items="${test.relevant}">
                        <div class="movie_relevant2">
                            <img src="<c:out value="${i.relevantLink}"></c:out>"><br>
                            <c:out value="${i.relevantName}"></c:out><br>
                        </div>
                    </c:forEach>
                </div>
            </div>

        </div>
    </div>


