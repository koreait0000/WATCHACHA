let right_payment = document.querySelector('.right_payment');
let email_change = document.querySelector('.email_change');
let password_change = document.querySelector('.password_change');

right_payment.addEventListener('click', ()=>{
    let right_modal = document.querySelector('.right_modal');
    right_modal.classList.remove('hidden');
    let close_modal = document.querySelector('.fas');
    close_modal.addEventListener('click', ()=>{
        right_modal.classList.add('hidden');
    })
});

email_change.addEventListener('click',()=>{
    let change_email = document.querySelector('.change_email');
    change_email.classList.remove('hidden');
    let close_modal = document.querySelector('.fas');
    close_modal.addEventListener('click', ()=>{
        change_email.classList.add('hidden');
    })
})