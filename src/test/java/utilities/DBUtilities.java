package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtilities {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    public static ResultSet resultSet;


    public static void createMysqlConnection(String schema) {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://test.kesifplus.com:3306/"+schema,
                    "root",
                    "cMk76oD4Z9dP"  //http://test.kesifplus.com:8080
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createMysqlTestConnection() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://www.kesifplus.com:3306/kesifplus",
                    "root",
                    "12345678"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createSqliteConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\test\\resources\\SqliteDatabase.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeDatabase() {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeQuery(String sql) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, Object>> getUsersInfoSqlite() {

        List<Map<String, Object>> mapList = new ArrayList<>();

        executeQuery("SELECT * from Users");
        try {
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("userId", resultSet.getInt(1));
                map.put("email", resultSet.getString(2));
                map.put("firstName", resultSet.getString(3));
                map.put("age", resultSet.getInt(4));

                mapList.add(map);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(mapList.toString());
        return mapList;
    }

    public static List<Map<String, Object>> getUsersInfoMysql() {


        List<Map<String, Object>> mapList = new ArrayList<>();

        executeQuery("SELECT * from users");
        try {
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("userId", resultSet.getInt(1));
                map.put("email", resultSet.getString(2));

                mapList.add(map);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapList;
    }
}
