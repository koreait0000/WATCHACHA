let form = document.querySelector('#form');
let tel = form.tel;
let regExp = /^\d{3}\d{4}\d{4}$/;
let verify = false;

tel.addEventListener('keyup', e =>{
    if(regExp.test(tel.value)){
        verify = true;
    }else{
        verify = false;
    }
});

function joinCheck(){
    if(verify === false){
        let spanElem = document.createElement('span');
        spanElem.innerText = '전화번호를 확인해주세요.';
        tel.after(spanElem);
        return false;
    }
}