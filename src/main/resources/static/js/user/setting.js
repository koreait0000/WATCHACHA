let right_payment = document.querySelector('.right_payment');
let email_change = document.querySelector('.email_change');
let password_change = document.querySelector('.password_change');
let close_modal = document.querySelectorAll('.close');

let right_modal = document.querySelector('.right_modal');
let change_email = document.querySelector('.change_email');
let change_password = document.querySelector('.change_password');
let btnGetPw = document.querySelector('#btnGetPw');
let checkpw = document.querySelector('#checkpw');

right_payment.addEventListener('click', ()=>{
    right_modal.classList.remove('hidden');
    close_modal.addEventListener('click', ()=>{
        right_modal.classList.add('hidden');
    });
});


//작업하는동안 주석함 필요하면 푸셈
// email_change.addEventListener('click',()=>{
//
//     change_email.classList.remove('hidden');
//     close_modal.addEventListener('click', ()=>{
//         change_email.classList.add('hidden');
//     });
//
// });

password_change.addEventListener('click', ()=>{

    change_password.classList.remove('hidden');
    // close_modal.addEventListener('click', ()=>{
    //     change_password.classList.add('hidden');
    // });

});

checkpw.addEventListener('click', () => {
    let oldpw = document.querySelector('#oldPw');
    fetch('/selUser', {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            email: oldpw.dataset.email,
            pw: oldpw.value
        })
    }).then(res => res.json())
        .then(myJson => {
            switch (myJson){
                case 0: //비번 일치하지않음
                    let span = document.createElement('span');
                    span.className ='error';
                    span.innerText = '비밀번호를 확인해주세요.';
                    if(!document.querySelector('.error')){
                        $('#oldPw').after(span);
                    }
                    break;
                case 2:
                    let spanError = document.querySelector('.error');
                    if(spanError){
                        spanError.remove();
                    }
                    checkpw.classList.add('hidden');
                    btnGetPw.classList.remove('hidden');
                    btnGetPw.addEventListener('click', () =>{
                        let newPw = document.querySelector('#newPw');
                        let newPw2 = document.querySelector('#newPw2');
                        if(newPw.value === newPw2.value){
                            fetch('/editPw',{
                                method: 'post',
                                headers: {
                                    'Content-Type': 'application/json'
                                },
                                body: JSON.stringify({
                                    email: oldpw.dataset.email,
                                    pw: newPw.value
                                })
                            }).then(res => res.json())
                                .then(myJson => {
                                    switch (myJson){
                                        case 0:
                                            alert('비밀번호를 변경실패.');
                                            break;
                                        case 1:
                                            alert('비밀번호를 변경하였습니다.');
                                            location.href='/logout';
                                            break;
                                    }
                                })
                        }
                    })
                    break;
            }
        })
});