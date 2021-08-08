let right_payment = document.querySelector('.right_payment');
let email_change = document.querySelector('.email_change');
let password_change = document.querySelector('.password_change');
const close_modal = document.querySelector('.close');

right_payment.addEventListener('click', ()=>{
    let right_modal = document.querySelector('.right_modal');
    right_modal.classList.remove('hidden');
    close_modal.addEventListener('click', ()=>{
        right_modal.classList.add('hidden');
    })
});

email_change.addEventListener('click',()=>{
    let change_email = document.querySelector('.change_email');
    change_email.classList.remove('hidden');
    close_modal.addEventListener('click', ()=>{
        change_email.classList.add('hidden');
    })
})

password_change.addEventListener('click', ()=>{
    let change_password = document.querySelector('.change_password');
    change_password.classList.remove('hidden');
    close_modal.addEventListener('click', ()=>{
        change_password.classList.add('hidden');
    })
})