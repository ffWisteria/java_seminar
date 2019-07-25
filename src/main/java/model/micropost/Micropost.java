package model.micropost;

import model.Default;

import java.sql.Timestamp;

public class Micropost extends Default {
    private String content;
    private String userID;


    public Micropost(
        String id,
        Timestamp createdAt,
        Timestamp updatedAt,
        String content,
        String userID
    ){
        super(id, createdAt, updatedAt);
        this.content = content;
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void createMicropost() {
        Repository.insertMicropost(this);
    }

//    public updateMicropost() {
//
//    }
//
//    public destroyMicropost() {
//
//    }
}
