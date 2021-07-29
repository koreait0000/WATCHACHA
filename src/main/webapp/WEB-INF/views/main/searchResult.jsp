<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/main/searchResult.css">
    <div class="web_wapper">
        <div class="searchResultHeader"></div>
        <div class="searchResult_Param">
            <span class="param_searchbar">'${param.get("searchbar")}'</span>
            <span class="param_searchbar2">검색결과</span>
        </div>

        <div class="searchMovie">
            <div class="movie_Object">
                <img src="<c:out value="${test.poster}"></c:out>"><br>
                <c:out value="${test.name}"></c:out><br>
            </div>
        </div>
        <br>
        <div class="searchMovie_movie_relevant">
            <div class="searchResult_Param">
                <span class="param_searchbar">'${param.get("searchbar")}'</span>
                <span class="param_searchbar2">와 비슷한 장르에요.</span>
            </div>


            <br>
            <div class="movie_relevant">
                <div class="movie_relevant1">
                    <c:forEach var="i" items="${test.relevant}">
                        <div class="movie_relevant2">
                            <img src="<c:out value="${i.relevantLink}"></c:out>"><br>
                            <span class="movie_relevant_name"><h4><c:out value="${i.relevantName}"></c:out><br></h4></span>
                        </div>
                    </c:forEach>
                </div>
            </div>

        </div>
    </div>


