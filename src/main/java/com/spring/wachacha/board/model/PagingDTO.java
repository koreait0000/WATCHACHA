package com.spring.wachacha.board.model;

import lombok.Data;

@Data
public class PagingDTO {
    private int page;
    private int listLength = 10;
    private int minIndex;
    private int maxIndex;
    private String nation;
    private String genre;
    private String searchText;
    public PagingDTO(int page) {
        this.page = page;
        this.minIndex = page * listLength - listLength;
        this.maxIndex = page * listLength - 1;
    }
    public PagingDTO(int page, int listLength) {
        this.page = page;
        this.minIndex = page * listLength - listLength;
        this.maxIndex = page * listLength - 1;
    }
}
