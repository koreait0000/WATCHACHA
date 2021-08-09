let right_payment = document.querySelector('.right_payment');
let email_change = document.querySelector('.email_change');
let password_change = document.querySelector('.password_change');
let close_modal = document.querySelectorAll('.close');

let right_modal = document.querySelector('.right_modal');
let change_email = document.querySelector('.change_email');
let change_password = document.querySelector('.change_password');

right_payment.addEventListener('click', ()=>{

    right_modal.classList.remove('hidden');
    close_modal.addEventListener('click', ()=>{
        right_modal.classList.add('hidden');
    });

});

email_change.addEventListener('click',()=>{

    change_email.classList.remove('hidden');
    close_modal.addEventListener('click', ()=>{
        change_email.classList.add('hidden');
    });

});

password_change.addEventListener('click', ()=>{

    change_password.classList.remove('hidden');
    close_modal.addEventListener('click', ()=>{
        change_password.classList.add('hidden');
    });

});

