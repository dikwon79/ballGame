package org.game;

import processing.core.PVector;

import java.awt.*;

public class Weapon {
  private int type;
  private int speed =300;

  private  Weapon[] weapon;

  private float x;

  private float y;
  private int size;
  private int width;
  Color color;


  public Weapon(PVector position, PVector direction, DynamicBall window){
    super();
  }

  public Weapon(float x, float y, int size, int width, int speed, int type){

    this.x = x;
    this.y = y;
    this.size = size;
    this.width = width;
    this.speed = speed;
    this.type = type;

  }

  public void setX(float x) {
    this.x = x;
  }

  public void setY(float y) {
    this.y = y;
  }

  public int getType() {
    return type;
  }

  public int getSpeed() {
    return speed;
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }






  // weapon type chooose
  public int weaponChange(int type){

    //1. gun
    //2. arrow
    //3. double gun
    return type;
  }
  public void move() {
    setY(getY()-speed);

  }


}
