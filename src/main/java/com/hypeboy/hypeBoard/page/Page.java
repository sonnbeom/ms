package com.hypeboy.hypeBoard.page;

import lombok.Getter;

import java.util.List;

@Getter
public class Page<T> {
    private List<T> content;
    private int currentPage;
    private int totalPages;
    private int pageSize;


    public Page(List<T> content, int currentPage, int totalPages, int pageSize) {
        this.content = content;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
    }

}
