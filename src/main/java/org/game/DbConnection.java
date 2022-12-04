package org.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection {

  private Connection con;
  private Statement st;
  private ResultSet rs;

  private String table = "score";

  public DbConnection(){
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","ab9371573!abcD");
      st = con.createStatement();

    }
    catch(Exception e)
    {
      System.out.println("Database error : "+e.getMessage());
    }
  }

  //all data search
  public void selectAll() {

    StringBuilder sb = new StringBuilder();
    String sql = sb.append("select * from "+table).append(";").toString();
    String SQL = "SELECT * from score where 1";

    try {
      rs = st.executeQuery(SQL);
      System.out.print("id");
      System.out.print("\t");
      System.out.print("score");
      System.out.print("\n");
      while (rs.next()) {
        System.out.print(rs.getInt("id"));
        System.out.print("\t");
        System.out.print(rs.getString("score"));
        System.out.print("\n");
      }
    } catch (Exception e) {
      System.out.println("database alldata search error : " + e.getMessage());
    }


  }

  // add data
  public void insert(String id, String score) {

    StringBuilder sb = new StringBuilder();
    String sql = sb.append("insert into " + table + " values(")
        .append("'" + id + "',")
        .append("'" + score + "'")
        .append(");")
        .toString();
    System.out.println(sql);
    try {
      st.executeUpdate(sql);
    } catch (Exception e) {
      System.out.println("database searching error : " + e.getMessage());
    }
  }
  public boolean isAdmin(String id, String score){
    try{
      String SQL = "SELECT * from score where 1";
      rs = st.executeQuery(SQL);
      if (rs.next()) {
        return true;
      }
    }catch (Exception e)
    {
      System.out.println("database searching error : "+ e.getMessage());
    }
    return false;


  }
}
