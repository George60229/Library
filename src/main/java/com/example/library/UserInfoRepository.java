package com.example.library;

import java.sql.*;

import static java.lang.System.out;

public class UserInfoRepository {


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
    public static int save(UserInfo myUserInfo) throws SQLException {
        int status=0;


        try {





            Connection connection = UserInfoRepository.getConnection();


            PreparedStatement ps = connection.prepareStatement("insert into users_info(login,days,book) values (?,?,?)");


            ps.setString(1, myUserInfo.getLogin());
            ps.setInt(2, myUserInfo.getDays());
            ps.setString(3, myUserInfo.getBook());


            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
return status;
    }
    public static String getMyBook(String userName) {

        String res="";

        try {
            Connection connection = BookRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("select book from users_info where login=?");
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            res =rs.getString("book");
        }
            connection.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return res;
    }
}
