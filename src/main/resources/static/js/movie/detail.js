let liSpanElem = document.querySelectorAll('ul li span');

liSpanElem.forEach(e => {
   let youtubeDiv = document.querySelector('.youtube_modal');
   let infoDiv = document.querySelector('.info_modal');
   e.addEventListener('click', ()=>{
      //모달창 on/off
      if(e.textContent === 'Youtube'){
         document.querySelector('.step_2').classList.remove('cursor');
         document.querySelector('.step_1').classList.add('cursor');
         youtubeDiv.classList.remove('hidden');
         infoDiv.classList.add('hidden');
      }else if(e.textContent === 'Info'){
         document.querySelector('.step_2').classList.add('cursor');
         document.querySelector('.step_1').classList.remove('cursor');
         youtubeDiv.classList.add('hidden');
         infoDiv.classList.remove('hidden');
      }
   });
});