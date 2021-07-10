package com.example.nask.model;

import java.util.List;

public class SwapiAllCharacters {

    private Integer count;
    private Integer pages;
    private String next;
    private String previous;
    private List<SwapiCharacter> results;

    /*getters and setters*/

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

    public List<SwapiCharacter> getResults() {
        return results;
    }

    public void setResults(List<SwapiCharacter> results) {
        this.results = results;
    }
}
