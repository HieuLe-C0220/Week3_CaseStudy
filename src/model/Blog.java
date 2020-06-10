package model;

import java.util.Date;

public class Blog {
    private int id;
    private String header;
    private String content;
    private String author;
    private int category_id;
    private String censor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCensor() {
        return censor;
    }

    public void setCensor(String censor) {
        this.censor = censor;
    }

    public Blog() {
    }

    public Blog(String header, String content, int category_id) {
        this.header = header;
        this.content = content;
        this.category_id = category_id;
    }

    public Blog(String header, String content, String author, int category_id, String censor) {
        this.header = header;
        this.content = content;
        this.author = author;
        this.category_id = category_id;
        this.censor = censor;
    }

    public Blog(int id, String header, String content, String author, int category_id, String censor) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.author = author;
        this.category_id = category_id;
        this.censor = censor;
    }
}
