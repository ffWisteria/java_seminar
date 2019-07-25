package model;

import java.sql.Timestamp;

public class Default {
    private String id;
    private Timestamp createdAt;
    private Timestamp updateAt;

    public Default(String id, Timestamp createdAt, Timestamp updateAt){
        this.id=id;
        this.createdAt=createdAt;
        this.updateAt=updateAt;
    }

    public String getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }
}
