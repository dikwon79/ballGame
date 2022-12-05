package org.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection extends DynamicBall{

  private Connection con;
  private Statement st;
  private ResultSet rs;

  private final String table = "score";

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
  public void selectAll(DynamicBall window) {

    //StringBuilder sb = new StringBuilder();
    //String sql = sb.append("select * from "+table+ "order by score desc").append(";").toString();
    String SQL = "SELECT * from score where 1 order by score desc limit 6";

    try {
      rs = st.executeQuery(SQL);

      window.text("level" ,window.width/4, window.height/2);
      window.text("score" ,window.width/4+200, window.height/2);
      int i =1;
      while (rs.next()) {

        window.text(rs.getInt("id") ,window.width/4, window.height/2+50*i);
        window.text(rs.getString("score") ,window.width/4+200, window.height/2+50*i);
        i++;
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
  //delete
  public void delete(int id) {

    StringBuilder sb = new StringBuilder();
    String sql = sb.append("delete from " + table + " where id = ")
        .append(id)
        .append(";")
        .toString();

    try {
      st.executeUpdate(sql);

    }catch (Exception e)
    {
      System.out.println("delete error : "+ e.getMessage());
    }
  }



  // modification

  public void update(int id, String name, int grade) {

    StringBuilder sb = new StringBuilder();
    String sql = sb.append("update " + table + " set")
        .append(" name = ")
        .append("'" + name + "',")
        .append(" grade = ")
        .append(grade)
        .append(" where id = ")
        .append(id)
        .append(";").toString();

    try {
      st.executeUpdate(sql);

    }catch (Exception e)
    {
      System.out.println("update error : "+ e.getMessage());
    }

  }

  //searching
  public void select(int id) {
    StringBuilder sb = new StringBuilder();
    String sql = sb.append("select * from " + table + " where")
        .append(" id = ")
        .append(id)
        .append(";").toString();
    try {
      ResultSet rs = st.executeQuery(sql);

      System.out.print("id");
      System.out.print("\t");
      System.out.print("name");
      System.out.print("\t");
      System.out.print("\n");

      while(rs.next()){
        System.out.print(rs.getInt("id"));
        System.out.print("\t");
        System.out.print(rs.getString("name"));
        System.out.print("\t");
        System.out.print("\n");
      }

    }catch (Exception e)
    {
      System.out.println("update error : "+ e.getMessage());
    }

  }
}
