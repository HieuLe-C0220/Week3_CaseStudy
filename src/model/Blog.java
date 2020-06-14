package model;

import java.sql.Timestamp;
import java.util.Date;

public class Blog {
    private int id;
    private String header;
    private String content;
    private String author;
    private Timestamp date;
    private int category_id;
    private String censor;
    private int status;

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getCensor() {
        return censor;
    }

    public void setCensor(String censor) {
        this.censor = censor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Blog(String header, String author,Timestamp date, int category_id) {
        this.header = header;
        this.author = author;
        this.date = date;
        this.category_id = category_id;
    }
    public Blog(String header, String content, String author,Timestamp date, int category_id) {
        this.header = header;
        this.content = content;
        this.author = author;
        this.date = date;
        this.category_id = category_id;
    }

    public Blog(String header, String content,Timestamp date, int category_id, int status) {
        this.header = header;
        this.content = content;
        this.date = date;
        this.category_id = category_id;
        this.status = status;
    }
    public Blog(String header, String author, int category_id,Timestamp date, String censor) {
        this.header = header;
        this.author = author;
        this.category_id = category_id;
        this.date = date;
        this.censor = censor;
    }

    public Blog(String header, String content, String author, Timestamp date, int category_id, String censor, int status) {
        this.header = header;
        this.content = content;
        this.author = author;
        this.date = date;
        this.category_id = category_id;
        this.censor = censor;
        this.status = status;
    }

    public Blog(int id, String header, String content, String author, int category_id, Timestamp date, String censor, int status) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.author = author;
        this.category_id = category_id;
        this.date = date;
        this.censor = censor;
        this.status = status;
    }
}
