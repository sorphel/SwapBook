package com.smallgroup.swapbook.domain;

import java.util.HashMap;

public class Book {

    private String mTitle;
    private String mAuthor;
    private String mUrl;
    private String mIdUser;

    public Book(String mTitle, String mAuthor, String mUrl, String mIdUser) {
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mUrl = mUrl;
        this.mIdUser = mIdUser;
    }

    public Book(HashMap<String, Object> bookMap){

    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mName) {
        this.mTitle = mName;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getIdUser() {
        return mIdUser;
    }

    public void setIdUser(String mIdUser) {
        this.mIdUser = mIdUser;
    }
}
