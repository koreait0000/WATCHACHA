resetBtnElem = document.querySelector('.resetBtn');

resetBtnElem.addEventListener('click', ()=>{
    fetch('/user/resetProfileImg',{
    }).then( res => res.json())
        .then(myJson =>{

        })
})