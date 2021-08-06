<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" href="/css/common/chat.css">
<button id="chatBtn">
    Chat
</button>
<div id="chatDiv"class="hidden" >
    <div>
        <label><b>watchacha채팅방입니다.</b></label>
    </div>
    <div id="username" data-username="${username}">
        <div id="msgArea" data-username="${username}"></div>
        <div class="col-6">
            <div class="input-group mb-3">
                <input type="text" id="msg" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="button" id="button-send">전송</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/js/common/chat.js"></script>