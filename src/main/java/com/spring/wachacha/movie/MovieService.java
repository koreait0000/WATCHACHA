package com.spring.wachacha.movie;

import com.spring.wachacha.config.security.IAuthenticationFacade;
import com.spring.wachacha.main.MainService;
import com.spring.wachacha.main.model.MovieSearchModel;
import com.spring.wachacha.movie.model.MovieEntity;
import com.spring.wachacha.movie.model.MovieFavEntity;
import com.spring.wachacha.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private MainService mainService;
    @Autowired private UserMapper userMapper;
    @Autowired private IAuthenticationFacade auth;
    @Autowired private MovieMapper movieMapper;

    @Transactional(readOnly = true)
    public MovieEntity findByKeyword(String keyword){
        return movieApiClient.requestMovie(keyword);
    }

    //test
    public MovieSearchModel info(String keyword){
        MovieSearchModel movieSearchModel = new MovieSearchModel();
        String responseBody = mainService.naverApi(keyword);
        JSONParser jParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jParser.parse(responseBody);
            MovieSearchModel t = new MovieSearchModel();
            t.setList((List<JSONObject>) jsonObject.get("items"));
            JSONObject jsonObject1 = t.getList().get(0);
            String link = (String) jsonObject1.get("link");
            Document doc = Jsoup.connect(link).get();
            String poster = doc.select("div.mv_info_area").select("img").attr("src");
            String name = doc.select("h3.h_movie").select("a").first().text();

            /*specInfo span tag에 장르 국가만 담겨져있습니다.*/
            Elements specInfo = doc.select("p.info_spec").select("span");
            String nation = specInfo.get(1).select("a").text();
            String genre = specInfo.get(0).select("a").text();
            genre = genre.split(" ")[0];
            String previewUrl = "https://movie.naver.com/"+doc.select("ul.video_thumb").select("li").select("a").attr("href");

            /*예고영상을 띄우기 위해서 */
            Document doc2 = Jsoup.connect(previewUrl).get();
            previewUrl = "https://movie.naver.com/" + doc2.select("iframe._videoPlayer").attr("src");
            movieSearchModel.setName(name); /*해당영화제목*/
            movieSearchModel.setPoster(poster); /*포스터URL*/
            movieSearchModel.setPreviewUrl(previewUrl); /*예고편URL*/
            movieSearchModel.setNation(nation);
            movieSearchModel.setGenre(genre);
            System.out.println(link);//네이버 api로 받은 링크
            Elements el = doc.select("ul.thumb_link_mv").select("li");

            Map<String, Object> summary = new HashMap<>();
            summary.put("title",doc.select("div.story_area").select("h5").text());//소제목
            summary.put("content", doc.select("div.story_area").select("p").text());//줄거리
            movieSearchModel.setSummary(summary);
            Element info = doc.select("div.mv_info").get(1);
            movieSearchModel.setEngName(info.select("strong.h_movie2").text());
            Map<String, Object> spec = new HashMap<>();
            String[] spec_name = {"outline","director","appearance","rank","show"};
            Elements info_spec = info.select("dl.info_spec").select("dd");
            for(int i=0; i<info_spec.size(); i++){
                if(i == 2){
                    spec.put(spec_name[i],info_spec.get(i).text().substring(0,info_spec.get(i).text().length()-3));
                }else{
                    spec.put(spec_name[i],info_spec.get(i).text());
                }
            }
            String star = doc.select("div.netizen_score").select(".star_score").select("em").text();
            movieSearchModel.setSpec(spec);
            movieSearchModel.setStar(star);
            //bg_url 획득
            String bg_url = link.replace("basic","photoView");
            Document doc_url = Jsoup.connect(bg_url).get();
            movieSearchModel.setBg_url(doc_url.select(".viewer_img").select("img").attr("src"));

        } catch (Exception e){
            e.printStackTrace();
        }
        return movieSearchModel;
    }

    public Map<String, Object> Youtube(String keyword, String page){
        Map<String, Object> map = new HashMap<>();
        List<String> hrefList = new ArrayList();
        List<String> ImgList = new ArrayList();
        List<String> titleList = new ArrayList();
        List<String> writerList = new ArrayList();
        String url = "https://www.google.com/search?q=%EC%98%81%ED%99%94"+keyword+"+%EC%9C%A0%ED%8A%9C%EB%B8%8C&tbm=vid&sxsrf=ALeKk01qBi-AgEWm7Jjh2ZXJ2uq6DpSdWA:1627012528071&ei=sD36YPf3A8OQr7wPiYG0oAk&start="+page+"&sa=N&ved=2ahUKEwj3j5_-pfjxAhVDyIsBHYkADZQQ8tMDegQIARBR&biw=1299&bih=787&dpr=1";
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
            map.put("hrefList",hrefList);
            map.put("ImgList",ImgList);
            map.put("titleList",titleList);
            map.put("writerList",writerList);
            map.put("cntList",cnt);
            map.put("page",page);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }


    // 보고싶어요
    public int insMovieFav(MovieFavEntity param) {
        param.setIuser(auth.getLoginUserPk());
        System.out.println(param);
        return userMapper.insMyMovie(param);
    }
    public int delMovieFav(MovieFavEntity param) {
        param.setIuser(auth.getLoginUserPk());
        return userMapper.delMyMovie(param);
    }

    //보고싶어요 체크
    public int checkMyfav(String keyword){
        MovieFavEntity movieFavEntity;

        int num = 0;
        return num;
    }


}
