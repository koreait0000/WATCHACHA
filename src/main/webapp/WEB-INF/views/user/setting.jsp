<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<link href="/css/user/setting.css" rel="stylesheet">

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
                                    <h4>example@gmail.com</h4>
                                </div>
                            </div>
                        </div>
                        <div class="account_section_right">
                            <div class="account_section_btn">
                                <div class="email_change">
                                    <span>이메일 변경</span>
                                </div>
                                <div class="password_change">
                                    <span>비밀번호변경</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--------------------------계정끝---------------------------->

            </div>
        </div>
        <!--------------------------setting_container 끝---------------------->

        <!--------------------------이용권변경 btn 모달---------------------->
        <div class="change_right_modal_bg">

        </div>
        <!--------------------------이용권변경 btn 모달끝---------------------->


        <!--------------------------이메일변경 btn 모달---------------------->
        <div></div>
        <!--------------------------이메일변경 btn 모달끝---------------------->


        <!--------------------------비밀번호변경 btn 모달---------------------->
        <div></div>
        <!--------------------------비밀번호변경 btn 모달끝---------------------->



    </div>
    <!------------------------------setting_wrapper 끝------------------------->
</div>
<script src="/js/user/setting.js"></script>