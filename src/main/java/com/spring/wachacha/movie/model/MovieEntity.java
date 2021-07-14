package com.spring.wachacha.movie.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class MovieEntity {
    private int display;
    private item[] items;

    @Data
    static class item {
        public String title;
        public String link;
        public String image;
        public String subtitle;
        public Date pubDate;
        public String director;
        public String actor;
        public float userRating;

    }
}
