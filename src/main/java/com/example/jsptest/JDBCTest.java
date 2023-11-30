package com.example.jsptest;

import java.sql.*;

public class JDBCTest {

    Connection conn = null; //연결하는 객체
    Statement statement = null; //sql 을 실행하는 객체
    ResultSet resultSet = null; //sql 결과를 저장하는 객체

    public JDBCTest() {


    }

    public String findId(String input) {
        String value = "";

        try{
            // Connection을 얻기 위해 필요한 url 역시, 벤더사마다 다르다.
            // mysql은 "jdbc:mysql://localhost/사용할db이름" 이다.

            // @param  getConnection(url, userName, password);
            // @return Connection
            String id ="kty";
            String passward ="qwer1234";
            String url = "jdbc:mysql://192.168.72.30/test";
            try {
                conn = DriverManager.getConnection(url, id, passward);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                //throw new RuntimeException(e);
            }
            System.out.println("Connection SUCCESS");

            String sql = "select * from user WHERE uid ="+input+";";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.print(resultSet.getString(1));
                System.out.print("  ");
                System.out.print(resultSet.getString(2));
                System.out.print("\n");

            }
            value = resultSet.getString(1) + " " + resultSet.getString(2);
            System.out.printf("result :" +value);
        }

        catch(SQLException e){
            System.out.println("ERROR: " + e);
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
        return value;
    }

    public String login(String uid, String upw) {
        String value = "";

        try{
            // Connection을 얻기 위해 필요한 url 역시, 벤더사마다 다르다.
            // mysql은 "jdbc:mysql://localhost/사용할db이름" 이다.

            // @param  getConnection(url, userName, password);
            // @return Connection
            String id ="kty";
            String passward ="qwer1234";
            String url = "jdbc:mysql://192.168.72.30/test";
            try {
                conn = DriverManager.getConnection(url, id, passward);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                //throw new RuntimeException(e);
            }
            System.out.println("Connection SUCCESS");

            String sql = "select * from user WHERE uid ='"+uid+"' AND upw='"+upw+"';";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                value = resultSet.getString(1) + " " + resultSet.getString(2);
                System.out.printf("result :" +value);

            }

        }

        catch(SQLException e){
            System.out.println("ERROR: " + e);
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
        return value;
    }
}
