package com.example.library;

import com.example.library.userServlets.AuthorizationUserServlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class UserRepository {


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
    public static int save(User myUser) throws SQLException {

        int status = 0;
        if(!checkLogin(myUser.getLogin())){
            return -1;
        }
        try {





                Connection connection = UserRepository.getConnection();


                PreparedStatement ps = connection.prepareStatement("insert into users(login,password,role) values (?,?,?)");


                ps.setString(1, myUser.getLogin());
                ps.setString(2, String.valueOf(myUser.getPassword().hashCode()));
                ps.setString(3, myUser.getRole());


                status = ps.executeUpdate();
                connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }


    public static List<User> getAllUsers() {
        List<User> listUsers = new ArrayList<>();
        try {
            Connection connection = BookRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from users where isblocked= false");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {


                User myUser=createUser(rs);

                listUsers.add(myUser);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }
    public static int delete(String login) {

        int status = 0;

        try {
            Connection connection = UserRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from users where login=?");
            ps.setString(1, login);
            status = ps.executeUpdate();

            connection.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return status;
    }
    public static int update(User myUser) {

        int status = 0;

        try {
            Connection connection = BookRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("update users set isblocked=? where login=? ");
            ps.setString(2, myUser.getLogin());
            ps.setBoolean(1, myUser.getIsBlocked());
            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return status;
    }

    public static int updatePass(User myUser) {

        int status = 0;

        try {
            Connection connection = BookRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("update users set password=? where login=? ");
            ps.setString(1, String.valueOf(myUser.getPassword().hashCode()));

            ps.setString(2,myUser.getLogin());
            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return status;
    }

    public static User createUser(ResultSet rs) throws SQLException {
        User myUser = new User();

        myUser.setId(rs.getInt(1));
        myUser.setRole(rs.getString(2));
        myUser.setPassword(rs.getString(3));
        myUser.setLogin(rs.getString(4));


        return myUser;
    }


    public static boolean checkLogin(String myLogin) throws SQLException {
        Connection connection = UserRepository.getConnection();
        PreparedStatement test=connection.prepareStatement("SELECT COUNT(*) FROM users WHERE login=?");
        int result=0;
        test.setString(1, myLogin);

        ResultSet res= test.executeQuery();
        if (res.next()){
            result = res.getInt("count");
        }

        return result == 0;

    }

    public static boolean checkPass(String myLogin,String myPassword) throws SQLException {
        Connection connection = UserRepository.getConnection();
        PreparedStatement test=connection.prepareStatement("SELECT count(id) FROM users WHERE  password=? and login=? and not isblocked=true ");

        test.setString(1,myPassword);
        test.setString(2,myLogin);

        ResultSet res= test.executeQuery();
        int result=0;
        if (res.next()){
            result = res.getInt("count");
        }

        return result>0;
    }
    public static void checkRole(String myLogin, String myPassword) throws SQLException {
        Connection connection = UserRepository.getConnection();
        PreparedStatement test=connection.prepareStatement("SELECT * FROM users WHERE  password=? and login=? and not isblocked=true ");

        test.setString(1,myPassword);
        test.setString(2,myLogin);

        ResultSet res= test.executeQuery();

        if (res.next()){
            AuthorizationUserServlet.role=res.getString("role");
            AuthorizationUserServlet.login=res.getString("login");
        }

    }

}
