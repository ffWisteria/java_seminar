//MVCのモデルに当たる
package model.user;

import model.Default;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class User extends Default {
    public final static String currentUserKey = "currentUser";

    private String name;
    private String email;
    private String password;

    public User(
        String id,
        Timestamp createdAt,
        Timestamp updatedAt,
        String name,
        String email,
        String password
    ){
        super(id,createdAt,updatedAt);
        //親（スーパー）クラスのコンストラクタを呼び出す
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

    public void createUser(){
        this.hashPassword();
        Repository.insertUser(this);
    }

    public boolean authenticateUser(HttpServletRequest request) {
        User persistedUser = Repository.selectUserByEMail(this.email);
        if (persistedUser == null) {
            return false;
        }

        this.hashPassword();
        if (this.password.equals(persistedUser.password)) {
            HttpSession session = request.getSession();
            session.setAttribute(currentUserKey, persistedUser);

            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<User> indexUsers(){
        return Repository.selectUsers();
    }

    public void hashPassword(){
        this.password=getHash(this.email,this.password);
    }

    private String getHash(String email, String password) {
        final String HASH_ALGORITHM = "SHA-256";
        final int STRETCH_COUNT = 1024;
        final String FIXED_SALT = "vBjRGHZ6awqJL9JDQuNftAzaPSnHszQN";

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String salt = email + FIXED_SALT;
        messageDigest.update(salt.getBytes());
        byte[] hashed = messageDigest.digest(password.getBytes());

        for (int i = 0; i < STRETCH_COUNT; i++) {
            hashed = messageDigest.digest(hashed);
        }
        return getHexString(hashed);
    }

    private String getHexString(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append(Integer.toHexString((bytes[i] >> 4) & 0x0f));
            stringBuffer.append(Integer.toHexString(bytes[i] & 0x0f));
        }
        return stringBuffer.toString();
    }

    public static User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (User) session.getAttribute(currentUserKey);
    }

    public static void logoutUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(currentUserKey);
    }
}
