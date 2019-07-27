package model.micropost;

import model.Default;

import java.sql.Timestamp;
import java.util.ArrayList;

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

    public void updateMicropost() {
        Repository.updateMicropost(this);
    }

    public void destroyMicropost(){
        Repository.deleteMicropost(this);
    }
    public static ArrayList<Micropost> indexMyMicropost(String userID){
        return Repository.selectMyMicropost(userID);
    }

    public static ArrayList<Micropost> indexOtherMicropost(String userID){
        return Repository.selectOtherMicropost(userID);
    }


//    public updateMicropost() {
//
//    }
//
//    public destroyMicropost() {
//
//    }
}
