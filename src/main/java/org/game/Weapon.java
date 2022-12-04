package org.game;

import processing.core.PVector;

import java.awt.*;

public class Weapon extends AbstractCharacter{
  private int type;
  private int speed =300;

  private  Weapon[] weapon;

  private int size;
  private float width;
  private float height;

  Color color;


  public Weapon(PVector position,float width, float height , DynamicBall window){
    super(position, width , height, window);
    this.width = width;
    this.height = height;
    this.position = position;
    this.window = window;
    this.color =new Color(50,80,10);
  }


  public void move() {
    PVector Position = new PVector(position.x, position.y-speed);
    setPosition(Position);

  }
  @Override
  public void setPosition(PVector position) {
    this.position = position;
  }
  @Override
  public void draw(DynamicBall window) {
    move();
    window.noStroke();
    window.fill(127,255,0);
    window.rect(getPosition().x+50,getPosition().y-150,10,500);
    if(getPosition().y-150<0){
      window.removeObj(this);
    }
  }

  @Override
  public boolean collided(Icollidable c) {
    return false;
  }

  @Override
  public PVector getPosition() {
    return this.position;
  }

  @Override
  public float getWidth() {
    return this.width;
  }

  @Override
  public float getHeight() {
    return this.height;
  }

  @Override
  public void collideBehaviour(Icollidable c) {

    if (c instanceof Balls) {
      System.out.println("player was dead");
    }
  }


}
