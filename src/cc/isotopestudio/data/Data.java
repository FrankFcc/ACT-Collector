/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.isotopestudio.data;

/*
 * Created by Mars Tan on 12/20/2016.
 * Copyright ISOTOPE Studio
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Data {

    public static void addUser(String username, String pw, String mail) {
        try {
            readUrlContent("http://tech.isotopestudio.cc/sql/addUser.php?username=" + username + "&pw=" + pw + "&mail=" + mail, 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addScore(String username, int year, int month, int day,
            String mark, String math, String english, String reading, String science, String essay, int composite) {
        try {
            System.out.println("http://tech.isotopestudio.cc/sql/addScore.php?"
                    + "username=" + username + "&year=" + year + "&month=" + month + "&day=" + day
                    + "&mark=" + mark + "&math=" + math + "&english=" + english + "&reading=" + reading + "&science=" + science + "&essay=" + essay + "&composite=" + composite);
            readUrlContent("http://tech.isotopestudio.cc/sql/addScore.php?"
                    + "username=" + username + "&year=" + year + "&month=" + month + "&day=" + day
                    + "&mark=" + mark + "&math=" + math + "&english=" + english + "&reading=" + reading + "&science=" + science + "&essay=" + essay + "&composite=" + composite, 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Score> getScoreByUser(String username) {
        ArrayList<Score> scores = new ArrayList<>();
        try {
            String data = readUrlContent("http://tech.isotopestudio.cc/sql/getScoreByUser.php?username=" + username, 10000);
            String[] scorelines = data.split(" ;");
            for (String score : scorelines) {
                String[] info = score.split(" ");
                scores.add(new Score(Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3]), info[4], Integer.parseInt(info[5]), Integer.parseInt(info[6]), Integer.parseInt(info[7]), Integer.parseInt(info[8]), Integer.parseInt(info[9]), Integer.parseInt(info[10])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }

    public static boolean identification(String username, String pw) {
        try {
            String data = readUrlContent("http://tech.isotopestudio.cc/sql/getUser.php", 10000);
            String[] users = data.split(" ;");
            for (String user : users) {
                String[] info = user.split(" ");
                if (username.equals(info[0])) {
                    return pw.equals(info[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Can't find user");
        return false;
    }

    public static boolean ifRepeated(String username) {
        try {
            String data = readUrlContent("http://tech.isotopestudio.cc/sql/getUser.php", 10000);
            String[] users = data.split(" ;");
            for (String user : users) {
                String[] info = user.split(" ");
                if (username.equals(info[0])) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String readUrlContent(String address, int timeout) throws IOException {
        StringBuilder contents = new StringBuilder(2048);
        BufferedReader br = null;

        try {
            URL url = new URL(address);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setConnectTimeout(timeout);
            huc.setReadTimeout(timeout);
            huc.setRequestMethod("GET");
            huc.connect();
            br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                contents.append(line);
            }
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contents.toString();
    }

}
