<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/main/mainpage.css">
<div class="serch_bar">
</div>
    <div class="web_wapper">
        <div class="movieInfoSection">

            <div class="search_bar">
                <form>
                    <input type="text" name="searchbar" placeholder="search">
                </form>
            </div>

            <div class="web_header">
                <div class="movie__section">
                    <h2>미나리</h2>
                    <p>Minari 2021 Drama</p>
                    <p>최근 한달간 시청률 상위 5%작품</p>
                    <p>
                        “미나리는 어디서든 잘 자라” 낯선 미국, 아칸소로 떠나온 한국가족들에게 뭔가 해내는
                        걸 보여주고 싶은 아빠 ‘제이콥’ 은 자신만의 농장을 가꾸기 시작하고 엄마 ‘모니카’도
                        다시 일자리를 찾는다. 아직 어린아이들을 위해 모니카의 엄마 순자가 함께 살기로 하고
                        가방 가득 고춧가루, 멸치, 한약 그리 고 미나리를 담은 할머니가 도착한다.
                    </p>
                    <h4>감독 정이삭</h4>
                    <h4>출연 윤여정,스티브연,한예리</h4>
                    <h4>드라마 | 미국 | 2021년</h4>
                    <button>
                        재생
                    </button>
                </div>

            </div>
        </div>
    </div>

<div>
    <c:forEach var="i" items="${rankPoster}">
        <img src="<c:out value="${i}"></c:out>">
    </c:forEach>
</div>
