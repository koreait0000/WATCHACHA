let tossPayments = TossPayments("test_ck_JQbgMGZzorzzXdypGB7rl5E1em4d");
let basicPay = document.querySelector('.section_center');
let premiumPay = document.querySelector('.section_right');

let orderId = new Date().getTime();

basicPay.addEventListener('click', ()=>{

   let paymentData = {
       amount: 8900,
       orderId: orderId,
       orderName: "베이직 이용권",
       successUrl: window.location.origin + "/success",
       failUrl: window.location.origin + "/fail",
   };

   tossPayments.requestPayment(paymentData);
});

premiumPay.addEventListener('click', ()=>{

    let paymentData = {
        amount: 12900,
        orderId: orderId,
        orderName: "프리미엄 이용권",
        successUrl: window.location.origin + "/success",
        failUrl: window.location.origin + "/fail",
    };

    tossPayments.requestPayment(paymentData);
});