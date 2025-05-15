package org.example;

import org.example.entities.DAO;

import java.sql.*;

public class Main {
    public static void createBUser(int loginId, String email,
                                   String userPassword, String phoneNumber, String firstName, String lastName) {
        String url = "jdbc:postgresql://slon.felk.cvut.cz:5432/manaeste";
        String username = "manaeste";
        String password = "33180402Tp";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             CallableStatement statement = connection.prepareCall("{call create_buser(?, ?, ?, ?, ?, ?)}")) {

            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            statement.setInt(1, loginId);
            statement.setString(2, email);
            statement.setString(3, userPassword);
            statement.setString(4, phoneNumber);
            statement.setString(5, firstName);
            statement.setString(6, lastName);

            statement.execute();

            System.out.println("User registered successfully.");

        } catch (SQLException e) {
            System.out.println("Error occurred during user registration: " + e.getMessage());
        }
    }

    public static void createPost(int postId, int blogId, int authorId, String title, String content, Time time, Date date) {
        String url = "jdbc:postgresql://slon.felk.cvut.cz:5432/manaeste";
        String username = "manaeste";
        String password = "33180402Tp";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO \"Post\" (post_id, blog_id, author_id, post_title, post_content, post_time, post_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, postId);
                statement.setInt(2, blogId);
                statement.setInt(3, authorId);
                statement.setString(4, title);
                statement.setString(5, content);
                statement.setTime(6, time);
                statement.setDate(7, new java.sql.Date(date.getTime()));

                statement.executeUpdate();

                System.out.println("Post created successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred during post creation: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        int loginId = 1012; // UNIQUE
        String email = "as@gs.or"; // UNIQUE
        String userPassword = "password1211111";
        String phoneNumber = "1610000"; // UNIQUE
        String firstName = "P";
        String lastName = "P";

        DAO dao = new DAO();

        /* DAO */
//        dao.createUser(loginId, email, userPassword, phoneNumber, firstName, lastName);
//        dao.createPost(32002, 1, 1, "Test post2", "Test content2");
//        dao.followBlog(1, 2);
//        dao.unfollowBlog(1, 2);
//        dao.createBlog(54, "Test blog4",  21, 2);


        /* NON-DAO */
//        createBUser(loginId, email, userPassword, phoneNumber, firstName, lastName);
//        createPost(32002, 1, 1, "Test post2", "Test content2", new Time(System.currentTimeMillis()), new Date(System.currentTimeMillis()));

    }
}
