package cc.isotopestudio;


import cc.isotopestudio.GUI.LOGIN;
import cc.isotopestudio.GUI.MainScreen;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 44750
 */
public class Main {

    public static JFrame login;
    public static String username;
    public static JFrame MainScreen;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                login = new LOGIN();
                login.setVisible(true);
            }
        });
    }

}
