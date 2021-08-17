const searchTextElem = document.querySelector('.profile_search #searchText')
const myFavListDivElem = document.querySelector('.profile_myFavList');
const myIuserVal = document.querySelector('.mypage_wrapper').dataset.myIuser;
const localConstElem = document.querySelector('#localConst');
infinityScrolling.url = `/user/getMyMovie`;
infinityScrolling.plusQuery = `&iuser=${myIuserVal}`;
infinityScrolling.makeItemList = makeMovieList;
infinityScrolling.setScrollInfinity(window);
infinityScrolling.getItemList(1);
function makeMovieList(movieList) {
    console.log(movieList);
    movieList.forEach(movie => {
        /*const iElem1 = document.createElement('i');
        iElem1.className = 'fas fa-heart';
        const divElem1 = document.createElement('div');
        divElem1.className = 'myfav_movie-footer';
        const iElem2 = document.createElement('i');
        iElem2.className = 'fas fa-play-circle';
        const divElem2 = document.createElement('div');
        divElem2.className = 'myfav_movie_hover';
        const spanElem = document.createElement('span');
        spanElem.innerText = movie.title;
        const imgElem = document.createElement('img');
        imgElem.src = movie.image;
        const aElem = document.createElement('a');
        aElem.href = `/movie/detail?keyword=${movie.title}&page=0`
        const divElem3 = document.createElement('div');
        divElem3.className = 'myfav_movie';
        const divElemOuter = document.createElement('div');
        divElemOuter.className = 'myfavMovie_List';
        myFavListDivElem.append(divElemOuter);
        divElemOuter.append(aElem);
        aElem.append(divElem3);
        divElem3.append(imgElem);
        divElem3.append(spanElem);
        divElem3.append(divElem2);
        divElem2.append(iElem2);
        divElem2.append(divElem1);
        divElem1.append(iElem1);*/
        const divElem = document.createElement('div');
        divElem.className = 'myfavMovie_List';
        divElem.innerHTML = `
            <a href="/movie/detail?keyword=${movie.title}&page=0">
                <div class="myfavMovie_List">
                    <div class="myfav_movie">
                        <section class="app" id="app" data-current-media="movie"> 
                            <article class="media-container">
                                <div class="movie-wrapper">
                                    <div class="movie">
                                        <div class="movie__front">                    
                                            <img src="${movie.image}" alt="cover">
                                        </div>
                                        <div class="movie__edge"></div>
                                        <div class="movie__side"></div>
                                    </div>
                                    <div class="movie-shadow"></div>
                                </div>
                            </article>
                        </section> 
                    </div>
                </div>
            </a>
            `
        myFavListDivElem.append(divElem);

        // = movieContainerElem.innerHTML += `<img src='https://image.tmdb.org/t/p/w500/${movie.poster_path}'>`;
    })
}
const isEmpty = function(value){
    if( value === "" || value == null || (typeof value == "object" && !Object.keys(value).length) ){
        return true;
    }else{
        return false;
    }
};

if(document.querySelector('.follow_btn_box') != null){
    const followBtnElem = document.querySelector('.follow_btn');
    const unfollowBtnElem = document.querySelector('.unfollow_btn');
    const refollowBtnElem = document.querySelector('.refollow_btn');
    const toIuserVal = document.querySelector('.follow_btn_box').dataset.toIuser;

    const followProc = {
        method: '',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        data: {
            to_iuser: toIuserVal
        },
        doFollow: function () {
            fetch('/user/follow', {
                method: this.method,
                body: JSON.stringify(this.data),
                headers: this.headers,
            }).then(res => res.json())
                .then(myJson => {
                    if(myJson === 1) {
                        checkFollow();
                    }else {
                        alert('팔로우 실패. 오류 발생.');
                    }
                })
        },
        unDoFollow: function () {
            fetch(`/user/follow/${toIuserVal}`, {
                method: this.method
            }).then(res => res.json())
                .then(myJson => {
                    if(myJson === 1) {
                        checkFollow();
                    }else {
                        alert('언팔로우 실패. 오류 발생.');
                    }
                })
        }
    }


    function checkFollow() {
        fetch(`/user/follow?to_iuser=${toIuserVal}`)
            .then(response => response.json())
            .then(myJson => {
                if(myJson.from_iuser === 1) {
                    followBtnElem.classList.add('hidden');
                    unfollowBtnElem.classList.remove('hidden');
                    refollowBtnElem.classList.add('hidden');
                }else if(myJson.to_iuser === 1 && myJson.from_iuser === 0 ) {
                    followBtnElem.classList.add('hidden');
                    unfollowBtnElem.classList.add('hidden');
                    refollowBtnElem.classList.remove('hidden');
                }else {
                    followBtnElem.classList.remove('hidden');
                    unfollowBtnElem.classList.add('hidden');
                    refollowBtnElem.classList.add('hidden');
                }
            })
    }
    checkFollow();

    followBtnElem.addEventListener('click', (e) => {
        followProc.method = 'POST';
        followProc.doFollow();
    })
    refollowBtnElem.addEventListener('click', (e) => {
        followProc.method = 'POST';
        followProc.doFollow();
    })
    unfollowBtnElem.addEventListener('click', (e) => {
        followProc.method = 'DELETE';
        followProc.unDoFollow();
    })
}
/********************************** 팔로우 모달 *****************************************************/
const followerContElem = document.querySelector('.follower_container');
const followContElem = document.querySelector('.follow_container');

const modalFollowElem = document.querySelector('.modal-follow');
const modalFollowTitleElem = modalFollowElem.querySelector('#title');
const modalFollowCloseElem = document.querySelector('.modal-follow #modal-follow-close');

const modalFollowItemConElem = modalFollowElem.querySelector('.followCont'); //안의내용물

/*팔로워를 클릭했을경우*/
followerContElem.addEventListener('click', ()=>{
    modalFollowTitleElem.innerText = '팔로워';
    modalFollowElem.classList.remove('hidden');
    modalFollowItemConElem.innerHTML=''; //비우고
    //프로필 사용자를 팔로우한 사람들 리스트
    fetch(`getFollowerList?iuserYou=${myIuserVal}`)
        .then(res=> res.json())
        .then(myJson =>{
            if (myJson.length > 0){
                myJson.forEach(item =>{
                    const cont = makeFollowItem(item);
                    modalFollowItemConElem.append(cont);
                });
            }
        });
});

/*팔로우를 클릭했을경우*/
followContElem.addEventListener('click', ()=>{
    modalFollowElem.classList.remove('hidden');
    modalFollowTitleElem.innerText = '팔로우';
    modalFollowItemConElem.innerHTML = '';
    //프로필 사용자가 팔로우한 사람들 리스트
    fetch(`getFollowList?iuserYou=${myIuserVal}`)
        .then(res => res.json())
        .then(myJson => {
            if(myJson.length > 0){
                myJson.forEach(item =>{
                    const cont = makeFollowItem(item);
                    modalFollowItemConElem.append(cont);
                });
            }
        });
});

/*모달창 닫기*/
modalFollowCloseElem.addEventListener('click', ()=>{
    modalFollowElem.classList.add('hidden');
})

/*프로필이미지 div만들기 개개인 */
function makeFollowItem(item){
    const globalContElem = document.querySelector('#globalConst');
    const loginIuser = globalContElem.dataset.iuser;

    const cont = document.createElement('div');
    cont.className = 'follow-item';
    const img = document.createElement('img');
    img.className = 'profile wh30 pointer';
    img.src = `/pic/profile/${item.iuser}/${item.mainProfile}`;
    img.onerror = () => { img.style.visibility = 'hidden'; }
    img.addEventListener('click', ()=> {
        moveToProfile(item.iuser); //feed.js 에 있는 메소드
    });

    const nm = document.createElement('div');
    const nmText = document.createElement('span');
    nmText.innerText = item.nm;
    nmText.className = 'pointer';
    nmText.addEventListener('click', ()=> {
        moveToProfile(item.iuser); //feed.js 에 있는 메소드
    });
    nm.append(nmText);

    const btn = document.createElement('input');
    btn.className = 'instaBtn pointer';
    btn.dataset.follow = '0';
    btn.addEventListener('click', () => {
        const follow = parseInt(btn.dataset.follow);
        followProc(follow, item.iuser, btn);
    });

    cont.append(img);
    cont.append(nm);
    if(parseInt(loginIuser) !== item.iuser) {
        btn.type = 'button';
        if(item.isMeFollowYou) {
            btn.dataset.follow = '1';
            btn.value = '팔로우 취소';
        } else {
            btn.classList.add('instaBtnEnable');
            btn.value = '팔로우';
        }
        cont.append(btn);
    }
    return cont;
}

/*프로필 화면으로 이동*/
function moveToProfile(iuser) {
    location.href = `/user/mypage?iuser=${iuser}`;
}

