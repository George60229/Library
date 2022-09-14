package com.example.library;

import java.sql.*;

import static java.lang.System.out;

public class PenaltyRepository {
    public static Connection getConnection() {

        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/library";
        String user = "postgres";
        String password = "174180183";

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                out.println("Connected to the PostgreSQL server successfully.");
            } else {
                out.println("Failed to make connection!");
            }
        } catch (SQLException sqlException) {
            out.println(sqlException);
        }
        return connection;
    }
    public static int save(String myPenalty) throws SQLException {
        int status=0;


        try {





            Connection connection = UserInfoRepository.getConnection();


            PreparedStatement ps = connection.prepareStatement("insert into penalty(login) values (?)");


            ps.setString(1, myPenalty);



            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static boolean checkPenalty(String myLogin) throws SQLException {
        Connection connection = UserRepository.getConnection();
        PreparedStatement test = connection.prepareStatement("SELECT COUNT(*) FROM penalty WHERE login=? and payed=false");
        int result = 0;
        test.setString(1, myLogin);

        ResultSet res = test.executeQuery();
        if (res.next()) {
            result = res.getInt("count");
        }

        return result != 0;

    }
    public static int removePenalty(String login) {

        int status = 0;

        try {
            Connection connection = BookRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("update penalty set payed=true where login=? ");
            ps.setString(1, login);


            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return status;
    }
}
