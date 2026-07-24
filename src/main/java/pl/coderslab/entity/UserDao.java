package pl.coderslab.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.DbUtil;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

import static javax.management.remote.JMXConnectorFactory.connect;
import static pl.coderslab.DbUtil.*;

public class UserDao {

    private static String GET_ALL_USERS = "SELECT * FROM uzytkownicy";

    public static List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL_USERS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("pasword")
                );
                user.setId(resultSet.getInt("id"));
                users.add(user);
            }

        }
        return users;
    }
}