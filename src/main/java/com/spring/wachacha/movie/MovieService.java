package com.spring.wachacha.movie;

import com.spring.wachacha.movie.model.MovieEntity;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieApiClient movieApiClient;

    @Transactional(readOnly = true)
    public MovieEntity findByKeyword(String keyword){
        return movieApiClient.requestMovie(keyword);
    }
//test
    public void info(String keyword){

    }

    public void Youtube(String keyword, Model model){
        List<String> hrefList = new ArrayList();
        List<String> ImgList = new ArrayList();
        List<String> titleList = new ArrayList();
        List<String> writerList = new ArrayList();
        int page = 0;
        String url = "https://www.google.com/search?q="+keyword+"+%EC%9C%A0%ED%8A%9C%EB%B8%8C&tbm=vid&sxsrf=ALeKk01qBi-AgEWm7Jjh2ZXJ2uq6DpSdWA:1627012528071&ei=sD36YPf3A8OQr7wPiYG0oAk&start="+page+"&sa=N&ved=2ahUKEwj3j5_-pfjxAhVDyIsBHYkADZQQ8tMDegQIARBR&biw=1299&bih=787&dpr=1";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements el = doc.select("a.rGhul");
            String[] cnt = ((doc.select("div.ij69rd.UHe5G")).text().split(" ")); //조회수
            for (Element e:el) {
                hrefList.add(e.attr("href"));
                Document doc2 = Jsoup.connect(e.attr("href")).get();
                ImgList.add(doc2.select("link[itemprop=thumbnailUrl]").attr("href")); //썸네일
                titleList.add(doc2.title().substring(0,doc2.title().length()-10)); //제목
                writerList.add(doc2.select("link[itemprop=name]").attr("content")); //작성자
            }
            model.addAttribute("hrefList",hrefList);
            model.addAttribute("ImgList",ImgList);
            model.addAttribute("titleList",titleList);
            model.addAttribute("writerList",writerList);
            model.addAttribute("cntList",cnt);
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("error","해당 영상이 없습니다.");
        }

    }
}
