let form = document.querySelector('#form');
let tel = form.tel;
let pw = form.pw;
let loginBtn = document.querySelector('.loginBtn');
let regExp = /^\d{3}-\d{3,4}-\d{4}$/;

tel.addEventListener('keyup', () =>{
    if(regExp.test(pw.value)){
        console.log('다르다!');
    }
});
loginBtn.addEventListener('click', () =>{
    let email = form.email.value;
    let tel = form.tel.value;
});