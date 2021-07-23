package com.spring.wachacha.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    public List<String> mainpage(){
        List<String> rankPoster = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("http://www.moviechart.co.kr/rank/realtime/index/image").get();
            Elements el = doc.select("div.poster").select("img");
            for (Element e:el) {
                String src = e.attr("src");
                if(src.contains(".png")) continue;
                rankPoster.add(src.substring(src.indexOf("http"),src.lastIndexOf("jpg")+3));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return rankPoster;
    }
}
