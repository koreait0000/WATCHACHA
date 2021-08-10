<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<link href="/css/user/setting.css" rel="stylesheet">
<sec:authorize access="isAuthenticated()">
<sec:authentication property="principal" var="principal" />
<div class="setting_bg">
    <div class="setting_wrapper">
        <!--------------------------setting_container 시작------------------------------->
        <div class="setting_container">
            <div class="setting_container_header"><h3>설정</h3></div>
            <div class="setting_container_section">
                <!--------------------------이용권------------------------------->
                <div class="right">
                    <div class="right_header"><h4>이용권</h4></div>
                    <div class="right_section">
                        <div class="right_section_left">
                            <div class="right_detail"><h4>상세정보</h4></div>
                            <div class="right_result">
                                <div class="right_result_Msg">
                                    <!--결제정보에 따라서 값이 변화되는곳-->
                                    <h4>아직결제정보가 없습니다.</h4>
                                    <h5>다양하고 많은 그리고 양질의 컨텐츠를 즐겨보세요.</h5>
                                </div>
                            </div>
                        </div>
                        <div class="right_section_right">
                            <div class="right_payment">
                                <span>이용권변경</span>
                            </div>
                        </div>
                    </div>
                </div>
                <!------------------------이용권 끝----------------------------->

                <!--------------------------계정------------------------------->
                <div class="account">
                    <div class="account_header"><h4>계정</h4></div>
                    <div class="account_section">
                        <div class="account_section_left">
                            <div class="account_detail"><h4>이메일</h4></div>
                            <div class="account_result">
                                <div class="account_result_Msg">
                                    <!--결제정보에 이메일 값이 변화되는곳-->
                                    <h4>${principal.user.email}</h4>
                                </div>
                            </div>
                        </div>
                        <div class="account_section_right">
                            <c:choose>
                                    <c:when test="${principal.user.provider eq 'local'}">
                                        <div class="account_section_btn">
                                            <div class="password_change">
                                                <span>비밀번호변경</span>
                                            </div>
                                        </div>
                                    </c:when>
                                <c:otherwise>
                                    <div class="social_Msg">
                                        <h5>'소셜로그인'은</h5>
                                        <h6>비밀번경이 불가능합니다.</h6>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                <!--------------------------계정끝---------------------------->

            </div>
        </div>
        <!--------------------------setting_container 끝---------------------->

        <!--------------------------이용권변경 btn 모달---------------------->
        <div class="right_modal hidden">
            <div class="change_right_modal_bg">
                <div class="change_right_container">
                    <div class="right_modal_header">
                        <h2>이제 프리미엄으로 즐기세요!</h2>
                        <i class="fas fa-times close1"></i>
                    </div>
                    <div class="right_modal_center">
                        <div class="section_left">
                            <div class="left1"></div>
                            <div class="left2">동시에 재생이 가능한 수 </div>
                            <div class="left3">지원하는 최대 화질</div>
                            <div class="left4">HDR 10+의 선명한 화질</div>
                            <div class="left5">저장 가능한 다운로드 영상 수</div>
                        </div>

                        <div class="section_center">
                            <div class="center1">
                                <h5>베이직 이용권</h5>
                                <P>월 8,900원</P>
                            </div>
                            <div class="center2">1</div>
                            <div class="center3">Full HD</div>
                            <div class="center4">X</div>
                            <div class="center5">5</div>
                        </div>


                        <div class="section_right">
                            <div class="right1">
                                <h5>프리미엄이용권</h5>
                                <P>월 12,900원</P>
                            </div>
                            <div class="right2">4</div>
                            <div class="right3">Ultra HD 4K</div>
                            <div class="right4">O</div>
                            <div class="right5">100</div>
                        </div>

                    </div>
                    <div class="right_modal_footer">
                        <%--<div class="payment_btn" id="payment-button">
                            <span>결제</span>
                        </div>--%>
                    </div>
                </div>
            </div>
        </div>
        <!--------------------------이용권변경 btn 모달끝---------------------->

        <!--------------------------비밀번호변경 btn 모달---------------------->
        <div class="change_password hidden">
            <div class="change_password_bg">
                <div class="change_password_container">
                    <!--header-->
                    <div class="change_password_header">
                        <div>
                            <h5>비밀번호 변경</h5>
                            <span>비밀번호가 변경되면 로그인된 모든 디바이스에서 다시 로그인해야 합니다.</span>
                        </div>
                        <i class="fas fa-times close2"></i>
                    </div>

                    <!--form-->
                        <div class="change_password_form">
                                <input type="password" id="oldPw" data-email="${principal.user.email}" placeholder="기존 비밀번호">
                                <button id="checkpw">비밀번호 확인</button>
                                <input type="password" id="newPw" placeholder="새 비밀번호">
                                <input type="password" id="newPw2" placeholder="새 비밀번호 확인">
                                <button class="hidden" id="btnGetPw">변경하기</button>
                        </div>
                </div>
            </div>
        </div>
        <!--------------------------비밀번호변경 btn 모달끝---------------------->


    </div>
    <!------------------------------setting_wrapper 끝------------------------->
</div>
</sec:authorize>
<script src="/js/user/setting.js"></script>
<script src="https://js.tosspayments.com/v1"></script>
<script src="/js/user/setting2.js"></script>
