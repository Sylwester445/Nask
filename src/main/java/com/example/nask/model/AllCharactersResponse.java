package com.example.nask.model;

import java.util.List;

public class AllCharactersResponse {

    private String next;
    private String previous;

    private Integer count;
    private Integer pages;
    private List<CharacterResponse> elements;

    /*getters and setters*/

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<CharacterResponse> getElements() {
        return elements;
    }

    public void setElements(List<CharacterResponse> elements) {
        this.elements = elements;
    }
}
