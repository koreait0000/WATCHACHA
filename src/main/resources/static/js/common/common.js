loginBtnElem = document.querySelector('.loginBtn');
userProfileElem = document.querySelector('.header_right');
userProfileModalElem = document.querySelector('.userProfile_modal');

userProfileElem.addEventListener('mouseover', ()=>{
    userProfileModalElem.classList.remove('hidden');
});

userProfileElem.addEventListener('mouseout',()=>{
    userProfileModalElem.classList.add('hidden');
});