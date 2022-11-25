package org.game;

import processing.core.PVector;

import static processing.core.PApplet.*;
import static processing.core.PApplet.sin;

public class Balls{
  private float xpos;
  private float ypos;
  private final float diameter;
  private float vx = 3;
  private float vy = -9;

  private int ballSpeed = -20;
  private final int id;
  private Balls[] others;
  private DynamicBall scene;



  Balls(float xin, float yin, float din, int idin, Balls[] oin,DynamicBall scene) {

    this.xpos = xin;
    this.ypos = yin;
    this.diameter = din;
    this.id = idin;
    this.others = oin;
    this.scene = scene;

  }
  public float getXpos() {
    return this.xpos;
  }

  public void setXpos(float xpos) {
    this.xpos = xpos;
  }

  public void setYpos(float ypos) {
    this.ypos = ypos;
  }

  public void setBallSpeed(int ballSpeed) {
    this.ballSpeed = ballSpeed;
  }

  public void setOthers(Balls[] others) {
    this.others = others;
  }

  public float getYpos() {
    return this.ypos;
  }

  public float getDiameter() {
    return this.diameter;
  }
  public void setVx(float ax) {
    this.vx = ax;
  }

  public float getVx() {
    return this.vx;
  }


  public void setVy(float ay) {
    this.vy = ay;
  }

  public float getVy() {
    return this.vy;
  }
  public void move() {

    //if the ball moves to the edge of the window, turn around.
    if (xpos + diameter / 2 > scene.width) {
      vx = vx * -1;
    } else if (xpos - diameter / 2 < 0) {
      vx = vx * -1;
    }

    //if the ball moves to the top,bottom of the screen, turn around.
    if (ypos + diameter / 2 > scene.height) {
       vy = ballSpeed;
    } else if (ypos - diameter / 2 < 0) {
       vy = ballSpeed;
    } else {
      vy += 0.5;
    }
    xpos += vx;
    ypos += vy;
  }

  public void collide() {
    for (int i = id + 1; i < others.length; i++) {
      float dx = others[i].xpos - xpos;
      float dy = others[i].ypos - ypos;
      float distance = sqrt(dx * dx + dy * dy);
      float minDist = others[i].diameter / 2 + diameter / 2;


      if (distance < minDist) {

        /* calculate angle between two ball */
        float angle = atan2(dy, dx);

        /*  Calculate the value at the time of a turnaround after a collision */
        float targetX = xpos + cos(angle) * minDist;
        float targetY = ypos + sin(angle) * minDist;
        float ax = (targetX - others[i].xpos) * scene.spring;
        float ay = (targetY - others[i].ypos) * scene.spring;
        vx -= ax;
        vy -= ay;

        //others[i].vx += ax;
        others[i].setVx(others[i].getVx() + ax);

        //others[i].vy += ay;
        others[i].setVy(others[i].getVy() + ay);

      }
    }
  }
  public void divide() {
    //with colldie - > one ball divides two;
  }

}
