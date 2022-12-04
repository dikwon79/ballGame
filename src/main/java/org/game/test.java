package org.game;

import processing.core.PApplet;

public class test {

    public static void main(String[] Args) {

      DbConnection connection = new DbConnection();
      System.out.println("connection: " + connection.isAdmin("1","50"));
      connection.selectAll();
      //connection.insert("2","150");



    }
  }

