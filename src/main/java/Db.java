import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by Владелец on 03.04.2017.
 */
public class Db {
    BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
    Scanner in = new Scanner(System.in);


    private final  String HOST = "jdbc:mysql://localhost:3306/mydbtest";
    private final  String USERNAME = "root";
    private final  String PASSWORD = "root";

    private static final String INSERT_NEW = "INSERT INTO books VALUES(?,?,?,?,?,?)";
    private static final String DELETE = "delete from books where id = ?";
    private static final String GET_ALL = "select id, bookname, author from books";
    private static final String GET_ONE = "select * from books where id = ?";

    private Connection connection;

    public Db(){
        try{
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    void add() throws SQLException, IOException {
        System.out.println("ID-?");
        int id = in.nextInt();
        System.out.println("имя книги");
        String title = s.readLine();
        System.out.println("автор");
        String author = s.readLine();
        System.out.println("описание");
        String descript = s.readLine();
        System.out.println("издатель");
        String publish = s.readLine();
        System.out.println("страницы");
        int pageam = in.nextInt();



        PreparedStatement prepstat = connection.prepareStatement(INSERT_NEW);
        prepstat.setInt(1,id);
        prepstat.setString(2,title);
        prepstat.setString(3,descript);
        prepstat.setString(4,author);


        prepstat.setInt(5,pageam);
        prepstat.setString(6,publish);

        prepstat.execute();



    }


    void del() throws SQLException {
        System.out.println("ID-?");
        int id = in.nextInt();
        PreparedStatement prepstat = connection.prepareStatement(DELETE);
        prepstat.setInt(1,id);
        prepstat.execute();

    }

    void getAll() throws SQLException {
        PreparedStatement prepstat = connection.prepareStatement(GET_ALL);
        ResultSet rs = prepstat.executeQuery();

        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String author = rs.getString(3);
            System.out.printf("id: %d, name: %s, author: %s %n", id, name, author);
        }




    }

    void getOne() throws SQLException {
        PreparedStatement prepstat = connection.prepareStatement(GET_ONE);
        System.out.println("id-?");
        int ids = in.nextInt();
        prepstat.setInt(1,ids);

        ResultSet rs = prepstat.executeQuery();

        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String author = rs.getString(3);
            String descrip = rs.getString(4);
            int pageam = rs.getInt(5);
            String publish = rs.getString(6);
            System.out.printf("id: %d, name: %s, author: %s,descr: %s, pageam: %d, publish: %s %n ", id, name, author,descrip,
                    pageam, publish);
        }
    }

}
