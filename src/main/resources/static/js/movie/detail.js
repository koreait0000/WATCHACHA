let liSpanElem = document.querySelectorAll('ul li span');
let prevElem = document.querySelector('.prev');
let nextElem = document.querySelector('.next');
let youtubeDiv = document.querySelector('.youtube_modal');
let step_1 = document.querySelector('.step_1')
let step_2 = document.querySelector('.step_2')
let step_3 = document.querySelector('.step_3')
let movie_play_btn = document.querySelector('.movie_play_btn');
let movie_fav = document.querySelector('.movie_fav');
let movie_review_Object= document.querySelector('.movie_review_Object');
const loadingElem = document.querySelector('.loading');

step_1.style.cursor = 'default';
step_2.style.cursor = 'pointer';
step_3.style.cursor = 'pointer';

hideLoading = function() { loadingElem.classList.add('hidden');}
showLoading = function() { loadingElem.classList.remove('hidden'); }

let page = 0;
let keyword = prevElem.dataset.keyword;
prevElem.style.cursor = 'default';

pageChange(page, keyword);
liSpanElem.forEach(e => {
   let infoDiv = document.querySelector('.info_modal');
   let episodeDiv = document.querySelector('.episode_modal')
   e.addEventListener('click', ()=>{
      //모달창 on/off
      if(e.textContent === 'Youtube'){
         step_1.style.cursor = 'pointer';
         step_2.style.cursor = 'default';
         step_3.style.cursor = 'pointer';
         infoDiv.classList.add('hidden');
         youtubeDiv.classList.remove('hidden');
         episodeDiv.classList.add('hidden');
      }else if(e.textContent === 'Info'){
         this.hideLoading();
         step_1.style.cursor = 'default';
         step_2.style.cursor = 'pointer';
         step_3.style.cursor = 'pointer';
         youtubeDiv.classList.add('hidden');
         episodeDiv.classList.add('hidden');
         infoDiv.classList.remove('hidden');
      }else if(e.textContent === 'Episode'){
         this.hideLoading();
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
   if(page !== 0){
      page-=10;
      this.showLoading();
      pageChange(page, keyword);
      if(page === 0) {
         prevElem.style.cursor = 'default';
      }
   }
});
nextElem.addEventListener('click', () => {
   page += 10;
   prevElem.style.cursor = 'pointer';
   this.showLoading();
   pageChange(page, keyword);
});

function pageChange(page, keyword){
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
      prevElem.classList.remove('hidden');
      nextElem.classList.remove('hidden');
   })
}
movie_play_btn.addEventListener('click', ()=>{
   let div = document.createElement('div');
   div.classList.add('play_big_modal');
   div.innerHTML =
       `<h1>안녕하세요 예시</h1>`
})
/*보고싶어요*/
let movie_love = document.querySelector('.movie_love');
let movie_hate = document.querySelector('.movie_hate');

movie_love.addEventListener('click',()=>{

   const data = {
      title: keyword,
      image: movie_fav.dataset.poster,
      genre: movie_fav.dataset.genre,
      nation: movie_fav.dataset.nation
   }
   console.log(data);

   fetch('/movie/movieFav',{
      method: 'POST',
      headers: {
         'Accept': 'application/json',
         'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
   })
       .then(res => res.json())
       .then(myJson =>{
          if(myJson.result === 0) {
             alert('오류가 발생했습니다.');
          }else if(myJson.result === 1) {
             movie_love.classList.add('hidden');
             movie_hate.classList.remove('hidden');
          }
         }
       )




});


movie_hate.addEventListener('click', ()=>{
   const data = {
      title: keyword,
      image: movie_fav.dataset.poster,
      genre: movie_fav.dataset.genre,
      nation: movie_fav.dataset.nation
   }
   console.log(data);

   fetch('/movie/movieFav',{
      method: 'DELETE',
      headers: {
         'Accept': 'application/json',
         'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
   })
       .then(res => res.json())
       .then(myJson =>{
              if(myJson.result === 0) {
                 alert('오류가 발생했습니다.');
              }else if(myJson.result === 1) {
                 movie_hate.classList.add('hidden');
                 movie_love.classList.remove('hidden');
              }
           }
       )

});
function my_movie_add(){
   fetch()
}