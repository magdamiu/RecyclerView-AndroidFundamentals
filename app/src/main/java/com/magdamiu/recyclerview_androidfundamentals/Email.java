package com.magdamiu.recyclerview_androidfundamentals;

public class Email {
    private int id;
    private String fromName;
    private String subject;
    private String shortBody;

    public Email(int id, String fromName, String subject, String shortBody) {
        this.id = id;
        this.fromName = fromName;
        this.subject = subject;
        this.shortBody = shortBody;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getShortBody() {
        return shortBody;
    }

    public void setShortBody(String shortBody) {
        this.shortBody = shortBody;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id='" + id + '\'' +
                ", fromName='" + fromName + '\'' +
                ", title='" + subject + '\'' +
                ", shortBody='" + shortBody + '\'' +
                '}';
    }
}