package model;

public class Comment {
    private String comment;
    private String author;
    public void setText(String comment) {
        this.comment = comment;

    }
    public String getText() {
        return comment;

    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
}
