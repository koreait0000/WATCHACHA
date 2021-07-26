package com.spring.wachacha.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MainService {

    public Map<String, Object> mainpage(){
        Map<String, Object> map = new HashMap<>();
        List<String> rankPoster = new ArrayList<>();
        List<String> name = new ArrayList<>();
        List<String> chart_num = new ArrayList<>();
        List<String> open = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("http://www.moviechart.co.kr/rank/realtime/index/image").get();
            Elements img = doc.select("div.poster").select("img");
            Elements posterName = doc.select("h4");
            Elements openDay = doc.select("p.open");
            Elements chart = doc.select("div.chart_num");
            for (Element e:img) {
                String src = e.attr("src");
                if(src.contains(".png")) continue;
                rankPoster.add(src.substring(src.indexOf("http"),src.lastIndexOf("jpg")+3));
            }
            for (Element e:posterName) {
                name.add(e.text());
            }
            for (Element e:openDay) {
                open.add(e.text().substring(6));
            }
            for (Element e:chart) {
                chart_num.add(e.text().substring(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        map.put("rankPoster", rankPoster);
        map.put("name", name);
        map.put("chart_num", chart_num);
        map.put("open", open);
        return map;
    }

    public void searchResult(String searchbar) {

        String clientId = "kKpU7wItpaTp7lBzqcNo"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "isV9qCZKQW"; //애플리케이션 클라이언트 시크릿값"

        String text = null;

        try {
            text = URLEncoder.encode(searchbar, "UTF-8");
            System.out.println("인코딩후 text " + text);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }

        String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + text;    // json 결과

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);

        System.out.println(responseBody);

    }

    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }

}
