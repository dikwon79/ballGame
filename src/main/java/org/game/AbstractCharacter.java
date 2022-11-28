package org.game;

import processing.core.PVector;

import java.util.Date;

public abstract class AbstractCharacter implements Idrawable, Icollidable  {
  protected PVector position;
  protected PVector direction;
  protected Date lastCollide;

  protected DynamicBall window;

  // multiplier for character speed
  protected float speed = 1f;
  // width of the character
  protected float width = 10f;
  // height of the character
  protected float height = 10f;

  public void setPosition(PVector position) {
    this.position = position;
  }

  public AbstractCharacter(PVector position, PVector direction, DynamicBall window) {
    this.position = position;
    this.direction = direction;
    this.lastCollide = new Date();
    this.window = window;
  }

  public boolean collided(Icollidable other) {
    return true;
  }
  public boolean outOfBounds() {
    return true;
  }
  public void bounce(float a) {

  }
}
