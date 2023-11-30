package com.example.jsptest;

import java.sql.*;
import java.util.Scanner;

public class JDBCTest2 {
    public String signin(String uid, String upw) {
        Connection conn = null; //연결하는 객체
        Statement statement = null; //sql 을 실행하는 객체
        ResultSet resultSet = null; //sql 결과를 저장하는 객체

        String id ="kty";
        String passward ="qwer1234";



        try{
            // Connection을 얻기 위해 필요한 url 역시, 벤더사마다 다르다.
            // mysql은 "jdbc:mysql://localhost/사용할db이름" 이다.
            String url = "jdbc:mysql://192.168.72.30/test";
            // @param  getConnection(url, userName, password);
            // @return Connection
            conn = DriverManager.getConnection(url, id, passward);
            System.out.println("Connection SECCESS");
            statement = conn.createStatement();



            String sql = "INSERT INTO user VALUES ('"+uid+"','"+upw+"');";
            Integer i = statement.executeUpdate(sql); //영향을 받은 행 갯수를 반환
            System.out.println(i);
        }

        catch(SQLException e){
            System.out.println("에러: " + e);
            return "SIGNIN FAIL";
        }
        finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "SIGNIN SECCUESS";
    }


}
