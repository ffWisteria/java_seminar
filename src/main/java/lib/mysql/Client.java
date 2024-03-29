package lib.mysql;

import java.sql.*;

public class Client {
    private final static String HOST_NAME = "db";
    private final static String DATABASE_NAME = "java_seminar";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "root";
    private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private final static String DRIVER_URL = "jdbc:mysql://" + HOST_NAME + ":3306/" + DATABASE_NAME + "?useUnicode=true&characterEncoding=utf-8";

    protected static Connection create() {
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Can't Find JDBC Driver.\n");
        } catch (SQLException e) {
            System.out.println("Connection Error.\n");
        }
        return null;
    }

    protected static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
            }
        }
    }
}