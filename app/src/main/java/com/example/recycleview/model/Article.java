package com.example.recycleview.model;

public class Article {
    private int image;
    private String source;
    private String time;
    private String title;
    private String likes;
    private String dislikes;
    private String bookmarks;
    private String sources;
    private int number;

    public Article(int image, String source, String time, String title, String likes, String dislikes, String bookmarks, String sources, int number) {
        this.image = image;
        this.source = source;
        this.time = time;
        this.title = title;
        this.likes = likes;
        this.dislikes = dislikes;
        this.bookmarks = bookmarks;
        this.sources = sources;
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDislikes() {
        return dislikes;
    }

    public void setDislikes(String dislikes) {
        this.dislikes = dislikes;
    }

    public String getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(String bookmarks) {
        this.bookmarks = bookmarks;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
