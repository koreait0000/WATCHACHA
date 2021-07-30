let form = document.querySelector('#form');
let tel = form.tel;
let pw = form.pw;
let loginBtn = document.querySelector('.loginBtn');
let regExp = /\d{3}\d{4}\d{4}/;
let verify = false;

tel.addEventListener('keyup', e =>{
    if(regExp.test(tel.value)){
        console.log('같다!');
        verify = true;
    }
});

loginBtn.addEventListener('click', () =>{
    let email = form.email.value;
    let tel = form.tel.value;
    if(verify === true){
        console.log('됨');
    }else{
        let spanElem = document.createElement('span');
        spanElem.innerText = '전화번호를 확인해주세요.';
        tel.append(spanElem);
    }
});