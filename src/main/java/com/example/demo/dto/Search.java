package com.example.demo.dto;

public class Search {
    private String keyword;

    public Search() {

    }

    public Search(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
