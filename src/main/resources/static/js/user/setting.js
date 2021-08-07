let right_payment = document.querySelector('.right_payment');
let change_right_modal_bg = document.querySelector('change_right_modal_bg');

right_payment.addEventListener('click', ()=>{
    change_right_modal_bg.classList.remove('hidden');
})