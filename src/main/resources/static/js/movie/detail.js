let liSpanElem = document.querySelectorAll('ul li span');
let prevElem = document.querySelector('.prev');
let nextElem = document.querySelector('.next');
let youtubeDiv = document.querySelector('.youtube_modal');

liSpanElem.forEach(e => {
   let infoDiv = document.querySelector('.info_modal');
   let episodeDiv = document.querySelector('.episode_modal')
   e.addEventListener('click', ()=>{
      //모달창 on/off
      if(e.textContent === 'Youtube'){
         document.querySelector('.step_1').classList.add('cursor');
         document.querySelector('.step_3').classList.add('cursor');
         document.querySelector('.step_2').classList.remove('cursor');
         youtubeDiv.classList.remove('hidden');
         infoDiv.classList.add('hidden');
         episodeDiv.classList.add('hidden');
      }else if(e.textContent === 'Info'){
         document.querySelector('.step_2').classList.add('cursor');
         document.querySelector('.step_3').classList.add('cursor');
         document.querySelector('.step_1').classList.remove('cursor');
         youtubeDiv.classList.add('hidden');
         episodeDiv.classList.add('hidden');
         infoDiv.classList.remove('hidden');
      }else if(e.textContent === 'Episode'){
         document.querySelector('.step_1').classList.add('cursor');
         document.querySelector('.step_2').classList.add('cursor');
         document.querySelector('.step_3').classList.remove('cursor');
         episodeDiv.classList.remove('hidden');
         youtubeDiv.classList.add('hidden');
         infoDiv.classList.add('hidden');
      }
   });
});

prevElem.addEventListener('click', () =>{
   let page = prevElem.dataset.page;
   let keyword = prevElem.dataset.keyword;
   if(page != 0){
      page-=10;
      pageChange(page, keyword);
   }
});
nextElem.addEventListener('click', () => {
   let page = nextElem.dataset.page;
   page+=10;
   let keyword = nextElem.dataset.keyword;
   pageChange(page, keyword);
});

function pageChange(page, keyword){
   fetch('/youtube?page='+page+'&keyword='+keyword,{
      method: 'put'
   }).then(res => res.json())
       .then(myJson => {
         console.log(myJson);
          let youtube_modal_child = youtubeDiv.children.item(1);
          youtube_modal_child.remove();
          //다음페이지 동적 생성
          let div = document.createElement('div');
          for(let i=0; i<myJson.change.hrefList.length; i++){
             let aDiv = document.createElement('a');
             aDiv.innerHTML = `<a href=${myJson.change.hrefList[i]} target="_blank"><img src=${myJson.change.ImgList[i]} width="500px" height="300px"><br>
            <div>${myJson.change.writerList[i]}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${myJson.change.cntList[i]}</div>
            <div>${myJson.change.titleList[i]}</div>
            </a>`;
             div.append(aDiv);
          }
          youtubeDiv.children.item(0).append(div);
       });
}