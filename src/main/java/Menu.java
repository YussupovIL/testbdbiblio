
import com.mysql.jdbc.Statement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by Владелец on 25.03.2017.
 */
public class Menu extends Db{



    private final static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    //Database db = new Database();

    BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
    Scanner in = new Scanner(System.in);


    void ShowCommands() throws IOException, SQLException {
        int choice=0;
        System.out.println("1.просмотр зарегистрированных изданий");
        System.out.println("2.Добавление нового издания");
        System.out.println("3.просмотр информации выбранного издания");
        System.out.println("4.удаление выбранного издания");
        System.out.println("5.выход");
        choice = in.nextInt();

        switch(choice){
            case 1:

                getAll();
                System.out.println("Данные заполнены! Выберете следующую команду");
                ShowCommands();
                break;
            case 2:

                add();
                System.out.println("Издание добавлено");
                ShowCommands();
                break;
            case 3:

                getOne();
                ShowCommands();
                break;
            case 4:

                del();
                System.out.println("Элемент удален");
                ShowCommands();
                break;
            case 5:
                break;

            default:
                System.out.println("Ошибка! Попробуйте заново");
                ShowCommands();
                break;
        }








    }







    }









