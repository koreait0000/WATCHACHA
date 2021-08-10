package com.spring.wachacha.board.model;

import lombok.Data;

@Data
public class PagingDTO {
    private int page;
    private int listLength = 10;
    private int minIndex;
    private String nation;
    private String genre;
    private String searchText;
    public PagingDTO(int page) {
        this.page = page;
        this.minIndex = (page - 1) * listLength;
    }
    public PagingDTO(int page, int listLength) {
        this.page = page;
        this.minIndex = (page - 1) * listLength;
        this.listLength = listLength;
    }
}
