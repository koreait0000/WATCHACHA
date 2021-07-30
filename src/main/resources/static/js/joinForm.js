let form = document.querySelector('#form');
let tel = form.tel;
let pw = form.pw;
let loginBtn = document.querySelector('.loginBtn');
let regExp = /\d{3}\d{4}\d{4}/;
let verify = false;

tel.addEventListener('keyup', e =>{
    if(regExp.test(tel.value)){
        console.log('됫다');
        verify = true;
    }
});

function joinCheck(){
    console.log('클릭함');
    let email = form.email.value;
    let telVal = form.tel.value;
    if(verify == true){
        console.log('됨');
    }else{
        console.log('안됨');
        let spanElem = document.createElement('span');
        spanElem.innerText = '전화번호를 확인해주세요.';
        tel.append(spanElem);
        return false;
    }
};