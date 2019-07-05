package model;

import java.sql.Timestamp;

public class Defoult {
    int id;
    Timestamp createdAt;
    Timestamp updateAt;

    public Defoult(int id,Timestamp createAt,Timestamp updateAt){
        this.id=id;
        this.createdAt=createdAt;
        this.updateAt=updateAt;

    }
}
