package org.game;

import processing.core.PVector;

import static processing.core.PApplet.*;
import static processing.core.PApplet.sin;

public class Balls extends AbstractCharacter{

  private float vx = 5;
  private float vy = -9;
  private int[] speedarray = {-18, -15, -12, -9};
  private int ballSpeed = -20;

  // direction change
  private boolean direciton = false;

  private Balls[] others;
  private DynamicBall scene;

  private float x,y;


  Balls(PVector position,float width, float height ,float vx ,float x,float y, DynamicBall window) {
    super(position,width,height,window);
    this.x = position.x;
    this.y = position.y;
    this.position = position;
    this.width = width;
    this.height= height;
    this.scene = window;
    this.vx = vx;

  }

  public float getXpos() {
    return this.position.x;
  }


  public float getYpos() {
    return this.position.y;
  }

  public float getDiameter() {
    return this.width;
  }

  public float getDirection() {
    return this.vx;
  }

  public void setDirection(float vx){
    this.vx = vx;
  }
  @Override
  public void move() {
    //System.out.println(this.vx);
    //if the ball moves to the edge of the window, turn around.
    position.x = x;
    position.y = y;
    if (position.x + width / 2 > scene.width) {
      vx = vx * -1;
    } else if (this.position.x - width / 2 < 0) {
      vx = vx * -1;
    }


    //if the ball moves to the top,bottom of the screen, turn around.
    if (position.y + width / 2 > scene.height) {
       vy = vy * -1;
    } else if (position.y - width / 2 < 0) {
       vy = vy * -1;
    } else {
      vy += 0.5;
    }

    position.x += vx;
    x += vx;
    y += vy;

    position.y += vy;

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
    if (c instanceof Weapon) {

      System.out.println("ball collide");
      window.removeObj(c);
      window.removeObj(this); //  ball delete
      if(this.width > 50) {
        window.ballDouble(this);
      }

      window.score += 1;
    }
    if (c instanceof Playergame) {
      System.out.println("player was dead");

    }

  }

  @Override
  public void draw(DynamicBall window) {
    move();
    window.noStroke();
    window.fill(126,133,17);
    window.drawCircle(this.getXpos(), this.getYpos(), this.getDiameter());

  }
}
