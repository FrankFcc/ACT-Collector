package act.collector;

import act.collector.sql.MySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class SQLmanager {

    public static boolean init() {
        MySQL MySQL = new MySQL("43.242.34.93", "3306", "isotopes_act", "isotopes_admin", "ftpF0305M0424L0202");

        try {
            c = MySQL.openConnection();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库出错 Error1");
            return false;
        } catch (SQLException e) {
            System.out.println("数据库出错 Error2");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String username = keyboard.nextLine();
        String pw = keyboard.nextLine();
        String mail = keyboard.nextLine();
        addUser(username, pw, mail);
    }
    public static Connection c = null;

    public static boolean addUser(String username, String pw, String mail) {

        PreparedStatement statement;
        try {
            statement = c.prepareStatement("INSERT INTO users VALUES(?, ?, ?);");
            statement.setString(1, username);
            statement.setString(2, pw);
            statement.setString(3, mail);
            statement.execute();
        } catch (SQLException e1) {
            System.out.println("数据库出错 Error3");
            return false;
        }
        return true;
        // PlayerData.statement = statement;
    }

    public static boolean ifRepeated(String name) {
        String sql = "select * from users where username = ?";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean Identification(String username, String pw) {
        ResultSet res = null;
        try {
            Statement statement = c.createStatement();

            res = statement.executeQuery("SELECT * FROM users WHERE username=\'" + username + "\';");

            if (res.next()) {
                String realpw = res.getString("pw");
                if (realpw.equals(pw)) {
                    return true;
                }
            }
        } catch (SQLException ignored) {

        }
        return false;
    }

    public static boolean addData(String username, int year, int month, int day, String mark, int math,
            int english, int reading, int science, int essay, int composite) {

        PreparedStatement statement;
        try {
            statement = c.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            statement.setString(1, username);
            statement.setInt(2, year);
            statement.setInt(3, month);
            statement.setInt(4, day);
            statement.setString(5, mark);
            statement.setInt(6, math);
            statement.setInt(7, english);
            statement.setInt(8, reading);
            statement.setInt(9, science);
            statement.setInt(10, essay);
            statement.setInt(11, composite);
            statement.execute();
        } catch (SQLException e1) {
            System.out.println("数据库出错 Error3");
            return false;
        }
        return true;
        // PlayerData.statement = statement;
    }
}
