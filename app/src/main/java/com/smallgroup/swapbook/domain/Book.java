package com.smallgroup.swapbook.domain;

public class Book {

    private String mName;
    private String mAuthor;
    private String mUrl;
    private String mIdUser;

    public Book(String mName, String mAuthor, String mUrl, String mIdUser) {
        this.mName = mName;
        this.mAuthor = mAuthor;
        this.mUrl = mUrl;
        this.mIdUser = mIdUser;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmIdUser() {
        return mIdUser;
    }

    public void setmIdUser(String mIdUser) {
        this.mIdUser = mIdUser;
    }
}
