package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtilities;

import java.sql.*;

public class databaseSD {

    Connection connection;

    Statement statement;

    PreparedStatement preparedStatement;

    ResultSet resultSet;

    /*
    Database islemleri ivcin dört temel adimimiz var;
    CRUD
    method     return          use method          sql syntax

    Read   -> ResultSet   ->  execute query       Select * FROM tablename

    ------------------------------- Üstteki komut okuyor, alttakiler manipüle ediyor! --------------------
    Create  -> int        ->  execute Update      INSERT INTO columnNames VALUES(columnValues)  --! Eger columnName ler sirali bir sekilde deger atayacaksan INTO yazmana gerek yok sira bozulacaksa INTO yaz

    Update  -> int        -> execute Update       UPDATE degisecekColumn SET neIleDegisecek

    Delete  -> int        -> execute Update       DELETE silinecekColumn FROM tableName
     */

    String email = "ogn.deneme@ogn.com";
    @Given("connection mysql database")
    public void  connectionMysqlDatabase() {
        // getConnection hata gösteriyor try-catch ile cevrele
        try {
            connection = DriverManager.getConnection("jdbc:mysql://test.kesifplus.com:3306/kesifplus",
                    "root",
                    "cMk76oD4Z9dP");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @When("we create new user")
    public void weCreateNewUser() {
    }

    @Then("assert new user in database")
    public void assertNewUserInDatabase() {
        boolean flag = false;
        // Buradaki komutlar da hata verecek, try-catch kullan!
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `users`");
        } catch (SQLException e) {
            e.printStackTrace();
        }

            try {
                while(resultSet.next()){  //DB'de kac kayit var bilmiyoruz. Next olmadigi duruma kadar gidecek
                    System.out.println("resultSet.getString(\"email\") = " + resultSet.getString("email"));
                    // SQL'de indexlerimiz HER ZAMAN 1'den BASLAR!!!
                    System.out.println("resultSet.getInt(1) = " + resultSet.getInt(1));
                    if (resultSet.getString("email").equals(email)) {
                        flag=true;
                        break;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        //yukaridaki if döngüsü ile alt satirdaki assertion'u bagladik. Böylece fazla is yükünden de kurtuluyoruz
        Assert.assertTrue("kullanici bulunamadi",flag);
    }

    @Test
    public void sqLiteDataBase() {

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+"\\src\\test\\resources\\SqliteDatabase.db");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * from users");

            while (resultSet.next()){
                System.out.println("resultSet.getString(\"firstName\") = " + resultSet.getString("firstName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void name() {

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home")+"\\Downloads");
    }

    @When("sql database bilgisi yazdir")
    public void sqlDatabaseBilgisiYazdir() {
        DBUtilities.getUsersInfoSqlite();
    }
}
