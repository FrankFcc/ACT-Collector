/*
 * Registered.java
 *
 * Created on __DATE__, __TIME__
 */
package cc.isotopestudio.GUI;

import cc.isotopestudio.data.Data;
import javax.swing.JOptionPane;

/**
 *
 * @author __USER__
 */
public class Registered extends javax.swing.JFrame {

    /**
     * Creates new form Registered
     */
    public Registered() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
	//GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(
                new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Set Your Account：");
        getContentPane().add(
                jLabel1,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1,
                        -1));

        getContentPane().add(
                jTextField1,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 200,
                        -1));

        jLabel2.setText("Set the password：");
        getContentPane().add(
                jLabel2,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1,
                        -1));

        getContentPane().add(
                jPasswordField1,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110,
                        200, -1));

        jLabel3.setText("Repeat the password：");
        getContentPane().add(
                jLabel3,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1,
                        -1));

        getContentPane().add(
                jPasswordField2,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150,
                        200, -1));

        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(
                jButton1,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1,
                        -1));

        this.setTitle("Sign up：");
        this.setSize(400, 300);
    }// </editor-fold>
    //GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String name = jTextField1.getText();
        String pwd = jPasswordField1.getText();
        String pwd2 = jPasswordField2.getText();
        if (name == null || name.equals("")) {
            JOptionPane.showMessageDialog(null, "请输入用户名！");
            return;
        }

        if (pwd == null || pwd.equals("")) {
            JOptionPane.showMessageDialog(null, "请输入密码！");
            return;
        }

        if (pwd2 == null || pwd2.equals("")) {
            JOptionPane.showMessageDialog(null, "请确认密码！");
            return;
        }

        if (!pwd.equals(pwd2)) {
            JOptionPane.showMessageDialog(null, "两次密码输入不一致！");
            return;
        }
        if (Data.ifRepeated(name)) {
            JOptionPane.showMessageDialog(null, "用户名已存在！");
        } else {
            Data.addUser(name, pwd, "");
            JOptionPane.showMessageDialog(null, "注册成功！");
            this.setVisible(false);
        }

    }

	//GEN-BEGIN:variables
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}