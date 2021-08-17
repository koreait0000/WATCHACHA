const searchTextElem = document.querySelector('.profile_search #searchText')
const myFavListDivElem = document.querySelector('.profile_myFavList');
infinityScrolling.url = '/user/getMyMovie';
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