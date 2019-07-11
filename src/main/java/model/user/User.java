package model.user;

import model.Default;

import java.sql.Timestamp;

public class User extends Default {
    public String name;
    public String email;
    public String password;

    public User(
        String id,
        Timestamp createdAt,
        Timestamp updatedAt,
        String name,
        String email,
        String password
    ){
        super(id,createdAt,updatedAt);
        //親（スーパー）クラスのコンソタラクタを呼び出す
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
