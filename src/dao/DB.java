package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pstm;
    private int ok;

    private void getConnection(){
        String url="jdbc:mysql://localhost:3306/gestion_users";
        String user="root";
        String password="";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void initPrepar(String sql){
        try{
            getConnection();
            pstm=conn.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet executeSelct(){
        rs=null;
        try {
            rs= pstm.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public int executeMaj(){
        try{
            ok= pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }
    public void closeConnection(){
        try {
            if(conn!=null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public PreparedStatement getPstm() {
        return pstm;
    }
}
