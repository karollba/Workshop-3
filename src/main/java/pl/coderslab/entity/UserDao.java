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
    private static final String REMOVE_USER_BY_ID = "DELETE FROM users WHERE id = ?;";
    private static final String UPDATE_USER = "UPDATE uzytkownicy SET username = ?, email = ? WHERE id = ?;";
    private static final String GET_USER_BY_ID = "SELECT * FROM uzytkownicy WHERE id = ?;";
    private static final String EDIT_USER_EMAIL = "UPDATE uzytkownicy SET email = ? WHERE id = ?;";
    private static final String EDIT_USER_PASSWORD = "UPDATE uzytkownicy SET password = ? WHERE id = ?;";

    public static List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL_USERS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
                user.setId(resultSet.getInt("id"));
                users.add(user);
            }

        }
        return users;

    }

    public static void removeUserById(int id) throws SQLException {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(REMOVE_USER_BY_ID)) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }

    }

    public static User getUserById(int id) throws SQLException {
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_USER_BY_ID)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User(
                            resultSet.getString("username"),
                            resultSet.getString("email"),
                            resultSet.getString("password")
                    );
                    user.setId(resultSet.getInt("id"));
                    return user;

                }
            }
        }
        return null;
    }

    public static void editUser() throws SQLException {

        // nazwa
        // email
        //haslo
    }

    public static void updateUser(int id, String username, String email) throws SQLException {
        // musisz przekazac id tutaj z kliknietego wczesniej uzytkownika
        try (Connection conn = DbUtil.getConnection();
        PreparedStatement statement = conn.prepareStatement(UPDATE_USER)) {

            statement.setString(1, username);
            statement.setString(2, email);
            statement.setInt(3, id);
            statement.executeUpdate();
        }
    }
}