package ee.bcs.koolitus.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by v on 16.04.2017.
 */
public class TestConnection {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/ajaveeb";
        String username = "root";
        String password = "valiit500";

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

    }

}
