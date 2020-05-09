package com.smallgroup.swapbook.domain;

import java.util.HashMap;
import java.util.Map;

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

    public Book(HashMap<String, Object> data){
        this.mTitle = "" + data.get("bookName").toString();
        this.mAuthor = "" + data.get("bookAuthor").toString();
        this.mUrl = "" + data.get("bookImage").toString();
        if (data.get("user") != null){
            this.mIdUser = "" + data.get("user");
        }
        else{
            this.mIdUser = null;
        }
    }

    public HashMap<String, Object> convertToMap(){
        HashMap<String, Object> data = new HashMap<String, Object>();

        data.put("bookName", "" + this.getTitle());
        data.put("bookAuthor", "" + this.getAuthor());
        data.put("bookImage", "" + this.getUrl());
        data.put("user", "" + this.getIdUser());

        return data;
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
