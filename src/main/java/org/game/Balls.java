package org.game;

import processing.core.PVector;

public class Balls{
  private float xpos;
  private float ypos;
  private final float diameter;
  private float vx = 0;
  private float vy = 0;
  private final int id;
  private Balls[] others;


  Balls(float xin, float yin, float din, int idin, Balls[] oin) {

    this.xpos = xin;
    this.ypos = yin;
    this.diameter = din;
    this.id = idin;
    this.others = oin;

  }

  public void collide() {
    // judge the point with meeting wepon bullet
  }
  public void divide() {
    //with colldie - > one ball divides two;
  }

}
