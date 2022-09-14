package com.example.library;

import com.example.library.userServlets.AuthorizationUserServlet;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.example.library.BookRepository.createBook;
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
    public static List<UserInfo> getAllUsersInfo() {
        List<UserInfo> listUsers = new ArrayList<>();
        try {
            Connection connection = BookRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("select book,login from users_info");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {


                UserInfo myUserInfo=new UserInfo();
                myUserInfo.setBook(rs.getString(1));
                myUserInfo.setLogin(rs.getString(2));



                listUsers.add(myUserInfo);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }
    public static boolean CheckDate(Book myBook,String login,Date nowDate) {


            Date oldDate=nowDate;

        try {
            Connection connection = BookRepository.getConnection();



            PreparedStatement ps = connection.prepareStatement("select days from users_info where book=? and login=?");
            ps.setString(1, myBook.getName());
            ps.setString(2,login );


            ResultSet rs = ps.executeQuery();
            if(rs.next()){
               oldDate=rs.getDate("days");

            }
            Calendar calendarStart = Calendar.getInstance();
            calendarStart.setTimeInMillis(oldDate.getTime());

            Calendar calendarEnd = Calendar.getInstance();
            calendarEnd.setTimeInMillis(nowDate.getTime());

            long difference = calendarEnd.getTimeInMillis() - calendarStart.getTimeInMillis();
            long days = difference /(24* 60 * 60 * 1000);

            if(days>UserInfo.DAYS){
                connection.close();
                return false;
            }

        connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return true;

    }
    public static int updateAmount(Book myBook,String login) {

        int status=0;


        try {
            Connection connection = BookRepository.getConnection();



            PreparedStatement ps = connection.prepareStatement("delete from users_info where book=? and login=?");
            ps.setString(1, myBook.getName());
            ps.setString(2,login );


            status=ps.executeUpdate();
            connection.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return status;
    }

    public static int save(UserInfo myUserInfo) throws SQLException {
        int status=0;


        try {





            Connection connection = UserInfoRepository.getConnection();


            PreparedStatement ps = connection.prepareStatement("insert into users_info(login,days,book) values (?,?,?)");


            ps.setString(1, myUserInfo.getLogin());
            ps.setDate(2, myUserInfo.getDays());
            ps.setString(3, myUserInfo.getBook());


            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
return status;
    }
    public static List<Book> getMyBook(String userName) {

        List<Book> listBooks = new ArrayList<>();

        try {
            Connection connection = BookRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("select book from users_info where login=?");
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Book myBook=new Book();
            myBook.setName(rs.getString("book"));


                listBooks.add(myBook);
            }
            connection.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return listBooks;
    }
}
