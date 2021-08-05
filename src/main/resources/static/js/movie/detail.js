let liSpanElem = document.querySelectorAll('ul li span');
let prevElem = document.querySelector('.prev');
let nextElem = document.querySelector('.next');
let youtubeDiv = document.querySelector('.youtube_modal');
let step_1 = document.querySelector('.step_1')
let step_2 = document.querySelector('.step_2')
let step_3 = document.querySelector('.step_3')
let movie_play_btn = document.querySelector('.movie_play_btn');

let movie_review_Object= document.querySelector('.movie_review_Object');
step_1.style.cursor = 'default';
step_2.style.cursor = 'pointer';
step_3.style.cursor = 'pointer';

let page = 0;
let keyword = prevElem.dataset.keyword;
prevElem.style.cursor = 'default';

liSpanElem.forEach(e => {
   let infoDiv = document.querySelector('.info_modal');
   let episodeDiv = document.querySelector('.episode_modal')
   e.addEventListener('click', ()=>{
      //모달창 on/off
      if(e.textContent === 'Youtube'){
         pageChange(page,keyword);
         step_1.style.cursor = 'pointer';
         step_2.style.cursor = 'default';
         step_3.style.cursor = 'pointer';
         infoDiv.classList.add('hidden');
         youtubeDiv.classList.remove('hidden');
         episodeDiv.classList.add('hidden');
         prevElem.classList.remove('hidden');
         nextElem.classList.remove('hidden');

      }else if(e.textContent === 'Info'){
         step_1.style.cursor = 'default';
         step_2.style.cursor = 'pointer';
         step_3.style.cursor = 'pointer';
         youtubeDiv.classList.add('hidden');
         episodeDiv.classList.add('hidden');
         infoDiv.classList.remove('hidden');
      }else if(e.textContent === 'Episode'){
         step_1.style.cursor = 'pointer';
         step_2.style.cursor = 'pointer';
         step_3.style.cursor = 'default';
         episodeDiv.classList.remove('hidden');
         youtubeDiv.classList.add('hidden');
         infoDiv.classList.add('hidden');
      }
   });
});

prevElem.addEventListener('click', () =>{
   page-=10;
   pageChange(page, keyword);
   if(page === 0) {
      prevElem.style.cursor = 'default';
   }
});
nextElem.addEventListener('click', () => {
   page += 10;
   prevElem.style.cursor = 'pointer';
   pageChange(page, keyword);
});

function pageChange(page, keyword){
   this.showLoading();
   fetch('/youtube?page='+page+'&keyword='+keyword,{
      method: 'put'
   }).then(res => res.json())
       .then(myJson => {
          let youtube_movie = document.querySelectorAll('.item');
          youtube_movie.forEach( e=>{
             e.remove();
          })
          //다음페이지 동적 생성
          for(let i=0; i<myJson.change.hrefList.length; i++){
             let div = document.createElement('div');
             div.classList.add('item');
             div.innerHTML =
            `<a href=${myJson.change.hrefList[i]} target="_blank"><img src=${myJson.change.ImgList[i]} width="300px" height="200px">
               <div class="txt_post">
                   <div class="txt_post_header">${myJson.change.writerList[i]}${myJson.change.cntList[i]}</div>
                   <div class="txt_post_section">${myJson.change.titleList[i]}</div>
               </div>
            </a>`;
             movie_review_Object.append(div);
          }
       }).catch( err =>{
          console.log(err);
   }).then(()=>{
      this.hideLoading();
   })
}
movie_play_btn.addEventListener('click', ()=>{
   let div = document.createElement('div');
   div.classList.add('play_big_modal');
   div.innerHTML = 
       `<h1>안녕하세요 예시</h1>`
})
const loadingElem = document.querySelector('.loading');
hideLoading = function() { loadingElem.classList.add('hidden');}
showLoading = function() { loadingElem.classList.remove('hidden'); }