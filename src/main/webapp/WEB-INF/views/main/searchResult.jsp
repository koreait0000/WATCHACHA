<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<img src="<c:out value="${test.poster}"></c:out>"><br>
<c:out value="${test.name}"></c:out><br>

관련 영화 추천<br>
<c:forEach var="i" items="${test.relevant}">
    <img src="<c:out value="${i.relevantLink}"></c:out>"><br>
    <c:out value="${i.relevantName}"></c:out><br>
</c:forEach>
