let uploadFile = '';

const resetBtnElem = document.querySelector('#reset_btn');
const usernameElem = document.querySelector('#username'); /*이름*/
const selectImgArrElem = document.querySelector('#selectImgArr'); /*이미지*/
const btnUploadElem = document.querySelector('#btnUpload');
// const displayImgListElem = document.querySelector('#displayImgList'); /*보이는거*/
const profileImgElem = document.querySelector('#profileImg');

usernameElem.addEventListener('keyup',()=>{
    /*이름을 적었을때 활성화*/
    toggleBtnUpload();
});

function toggleBtnUpload(){
    //버튼 비활성화
    btnUploadElem.disabled = true;
    if(usernameElem.value.length > 2 || uploadFile != null){
        //이름 길이에따라 버튼활성화
        btnUploadElem.disabled = false;
    }
}

btnUploadElem.addEventListener('click', ()=>{

   const data = new FormData(); //key-value로 전송해주게하는 form

   if(usernameElem.value.length > 0){
       data.append(usernameElem.name, usernameElem.value);
       //console.log(usernameElem.value);
   }
   if(uploadFile != null){
       data.append('imgArr',uploadFile);
       // console.log(uploadFile);
   }
    fetch('/user/uploadProfile',{
        method: 'POST',
        body: data
    }).then(res => res.json())
        .then(myJson =>{
            switch (myJson.result){
                case 0:
                    alert('다시 등록해주세요');
                    break;

                case 1:
                    location.href = '/user/mypage';
                    break;
            }
        })

});

/*이미지를 넣어주는거*/
selectImgArrElem.addEventListener('change',()=>{
   const files = selectImgArrElem.files;
    uploadFile = files[0];
   /*이미지를 보여주는거*/
   displaySelectedImgArr();
});



// 보이게하는거
function displaySelectedImgArr(){
    toggleBtnUpload();
   // displayImgListElem.innerHTML=''; /*일단비우기*/
    const reader = new FileReader();
    reader.readAsDataURL(uploadFile);

    reader.onload = () => {
        profileImgElem.src = reader.result;
    }
}

resetBtnElem.addEventListener('click', ()=>{
    fetch('/user/resetProfileImg',{
    }).then( res => res.json())
        .then(myJson =>{
        })
})
