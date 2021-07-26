<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
<head>
  <title>구매하기</title>
  <meta charset="utf-8"/>
  <meta http-equiv="x-ua-compatible" content="ie=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
  <link rel="stylesheet" href="/css/pay/index.css" />
</head>
<body>
  <div class="payHeader"></div>
<section>
  <img src="https://www.misope.co.kr/data/goods/19/10/44//2387/2387_detail_090.png" style="max-width: 100%" />
  <h3>토스 티셔츠</h3>
  <span>19,000 원</span>
  <p>----------------------</p>
  <div><label><input type="radio" name="method" value="카드" checked/>신용카드</label></div>
  <div><label><input type="radio" name="method" value="가상계좌"/>가상계좌</label></div>
  <p>----------------------</p>
  <button id="payment-button">결제하기</button>
</section>

<script src="https://js.tosspayments.com/v1"></script>
<script>
  var tossPayments = TossPayments("test_ck_JQbgMGZzorzzXdypGB7rl5E1em4d");
  var button = document.getElementById("payment-button");

  var orderId = new Date().getTime();

  button.addEventListener("click", function () {
    var method = document.querySelector('input[name=method]:checked').value; // "카드" 혹은 "가상계좌"

    var paymentData = {
      amount: 19000,
      orderId: orderId,
      orderName: "토스 티셔츠",
      customerName: "이토페",
      successUrl: window.location.origin + "/success",
      failUrl: window.location.origin + "/fail",
    };

    if (method === '가상계좌') {
      paymentData.virtualAccountCallbackUrl = window.location.origin + '/virtual-account/callback'
    }

    tossPayments.requestPayment(method, paymentData);
  });
</script>
</body>
</html>
