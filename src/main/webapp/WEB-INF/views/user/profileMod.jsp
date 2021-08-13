<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<link href="/css/user/profileMod.css" rel="stylesheet">
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal" />
    <div class="profileMod_wrapper">
        <div class="profileMod_container">
            <div class="profileMod_container_header">
                <h1>프로필 수정</h1>
            </div>
            <div class="profileMod_container_center">
                <%--이미지선택--%>
                <div class="container_left">
                    <c:choose>
                        <c:when test="${principal.user.mainProfile == null}">
                            <img src="/img/default.png">
                        </c:when>
                        <c:otherwise>
                            <img src="/pic/profile/${principal.user.iuser}/${principal.user.mainProfile}">
                        </c:otherwise>
                    </c:choose>
                    <div><input type="file" id="selectImgArr" multiple accept="image/*"></div>
                </div>
                <%--이름변경--%>
                <div class="container_right">
                    <div class="container_right_section">
                        <h5>이름</h5>
                        <div><input type="text" id="username" placeholder="${principal.user.nm}"></div>
                        <P>• 이름은 최소 2자, 최대 20자 까지 입력이 가능해요.</P>
                        <P>• 수정한 정보는 왓챠의 다른 서비스에서도 동일하게 표시됩니다.</P>
                    </div>
                </div>
            </div>
            <div class="profileMod_container_footer">
                <hr>
                <div>
                    <div class="clear_btn"><input type="button" id="btnUpload" value="완료" disabled></div>
                    <div class="cancle_btn"><input type="reset"  value="취소"></div>
                </div>
            </div>
            <%--<div id="displayImgList"></div>--%>
        </div>
    </div>
</sec:authorize>
<script src="/js/user/profileMod.js"></script>