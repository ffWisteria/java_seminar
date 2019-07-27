package model.micropost;

import lib.mysql.Client;

import java.sql.*;
import java.util.ArrayList;

public class Repository extends Client {
    public static void insertMicropost(Micropost micropost) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // SQL 文の用意
            String sql = "insert into microposts" +
                    "(content, created_at, updated_at, user_id)" +
                    " values (?, ?, ?, ?)";

            // DB へのコネクションを作成する
            connection = create();

            // 現在時間の取得
            // user インスタンスの生成
            Timestamp currentTime =
                    new Timestamp(System.currentTimeMillis());

            // セキュリティの一つ。
            // sql文を入力されてしまった時にデータが消えてしまうかもしれないから
            // 実行するSQL文とパラメータを指定する
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, micropost.getContent());//?1
            preparedStatement.setTimestamp(2, currentTime);//?2
            preparedStatement.setTimestamp(3, currentTime);//?2
            preparedStatement.setString(4, micropost.getUserID());//?4

            // SQL 文の実行
            preparedStatement.executeUpdate();
            return;

        } catch (SQLException e) {
            // 例外発生時の処理
            //ログを残す
            e.printStackTrace();
            return;

        } finally {
            // クローズ処理
            //ファイルを閉じる
            close(connection, preparedStatement, resultSet);
        }
    }
    public static ArrayList<Micropost> selectMyMicropost(String userID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;



        try {
            String sql = "select * from microposts where user_id = ?";

            connection = create();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userID);

            // SQL 文を実行し、結果を保存する
            resultSet = preparedStatement.executeQuery();

            // 結果を User Entity に整形したうえで、users リストに逐一追加する
            ArrayList<Micropost> microposts = new ArrayList<>();
            while (resultSet.next()) {
                Micropost micropost = new Micropost(
                        String.valueOf(resultSet.getString("id")),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getString("content"),
                        resultSet.getString("user_id")
                );
                //userというリストにデータを追加する
                microposts.add(micropost);
            }
            return microposts;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    public static ArrayList<Micropost> selectOtherMicropost(String userID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "select * from microposts where user_id != ?";

            connection = create();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userID);

            // SQL 文を実行し、結果を保存する
            resultSet = preparedStatement.executeQuery();

            // 結果を User Entity に整形したうえで、users リストに逐一追加する
            ArrayList<Micropost> microposts = new ArrayList<>();
            while (resultSet.next()) {
                Micropost micropost = new Micropost(
                        String.valueOf(resultSet.getString("id")),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getString("content"),
                        resultSet.getString("user_id")
                );
                //userというリストにデータを追加する
                microposts.add(micropost);
            }
            return microposts;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    public static void updateMicropost(Micropost micropost){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "update microposts set content = ?, updated_at = ? where id = ?";

            connection = create();

            Timestamp currentTime =
                    new Timestamp(System.currentTimeMillis());

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, micropost.getContent());
            preparedStatement.setTimestamp(2, currentTime);
            preparedStatement.setInt(3, Integer.parseInt(micropost.getId()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    public static void deleteMicropost(Micropost micropost){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "delete from microposts where id=?";

            connection = create();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,Integer.parseInt(micropost.getId()));

            preparedStatement.executeUpdate();
            return;
        }catch (SQLException e) {
            // 例外発生時の処理
            //ログを残す
            e.printStackTrace();
            return;

        } finally {
            // クローズ処理
            //ファイルを閉じる
            close(connection, preparedStatement, resultSet);
        }
    }
}
//    public static ArrayList<User> selectUsers() {
//        //Userというクラスの型をリスト化している
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        try {
//            String sql = "select * from users";
//
//            connection = create();
//
//            preparedStatement = connection.prepareStatement(sql);
//
//            // SQL 文を実行し、結果を保存する
//            resultSet = preparedStatement.executeQuery();
//
//            // 結果を User Entity に整形したうえで、users リストに逐一追加する
//            ArrayList<User> users = new ArrayList<>();
//            while (resultSet.next()) {
//                User user = new User(
//                        String.valueOf(resultSet.getString("id")),
//                        resultSet.getTimestamp("created_at"),
//                        resultSet.getTimestamp("updated_at"),
//                        resultSet.getString("name"),
//                        resultSet.getString("email"),
//                        resultSet.getString("password")
//                );
//                //userというリストにデータを追加する
//                users.add(user);
//            }
//            return users;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//
//        } finally {
//            close(connection, preparedStatement, resultSet);
//        }
//    }
//
//    public static User selectUserByID(String id) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        try {
//            String sql = "select * from users where id = ?";
//
//            connection = create();
//
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, Integer.parseInt(id));
//
//            resultSet = preparedStatement.executeQuery();
//
//            User user = null;
//            while (resultSet.next()) {
//                user = new User(
//                        String.valueOf(resultSet.getString("id")),
//                        resultSet.getTimestamp("created_at"),
//                        resultSet.getTimestamp("updated_at"),
//                        resultSet.getString("name"),
//                        resultSet.getString("email"),
//                        resultSet.getString("password")
//                );
//            }
//            return user;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//
//        } finally {
//            close(connection, preparedStatement, resultSet);
//        }
//    }
//
//    public static User selectUserByEMail(String email) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        try {
//            String sql = "select * from users where email = ?";
//
//            connection = create();
//
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, email);
//
//            resultSet = preparedStatement.executeQuery();
//
//            User user = null;
//            while (resultSet.next()) {
//                user = new User(
//                        String.valueOf(resultSet.getString("id")),
//                        resultSet.getTimestamp("created_at"),
//                        resultSet.getTimestamp("updated_at"),
//                        resultSet.getString("name"),
//                        resultSet.getString("email"),
//                        resultSet.getString("password")
//                );
//            }
//            return user;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//
//        } finally {
//            close(connection, preparedStatement, resultSet);
//        }
//    }
//}
