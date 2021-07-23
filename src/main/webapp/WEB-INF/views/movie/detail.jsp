<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:forEach var="i" items="${hrefList}" varStatus="status">
        <a href="<c:out value="${i}"></c:out>"><img src="${ImgList[status.index]}" width="500px" height="300px"><br>
            <c:out value="${writerList[status.index]}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${cntList[status.index]}"></c:out><br>
            <c:out value="${titleList[status.index]}"></c:out>
        </a><br>
    </c:forEach>
</div>