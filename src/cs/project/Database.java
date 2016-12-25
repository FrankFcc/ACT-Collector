/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.project;

/**
 *
 * @author Administrator
 */
/*public class CSProject {

    /**
     * @param args the command line arguments
     */
import java.sql.*;
public class Database {

 private Connection conn;
 private Statement stmt;
 private String url = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=dbname";
 private String classforname = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
 private String uid = "sa";
 private String pwd = "password";
 

 
 /**
  * <p>通过Microsoft JDBC驱动获得数据库连接</p>
  * @return Connection
  * @exception ClassNotFoundException, SQLException
  */
 public Connection getConnection()
 {
  try
  {
   Class.forName(classforname);
   if (conn == null || conn.isClosed())
    conn = DriverManager.getConnection( url, uid, pwd);
  }
  catch (ClassNotFoundException ex)
  {
   ex.printStackTrace();
  }
  catch (SQLException ex)
  {
   ex.printStackTrace();
  }
  return conn;  
 }

}

    

