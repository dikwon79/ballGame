package org.game;

import processing.core.PVector;

import java.util.Date;

public abstract class AbstractCharacter implements Idrawable, Icollidable  {
  protected PVector position;
  protected PVector direction;
  protected Date lastCollide;

  // multiplier for character speed
  protected float speed = 1f;
  // width of the character
  protected float width = 10f;
  // height of the character
  protected float height = 10f;

  public AbstractCharacter(PVector position, PVector direction) {
    this.position = position;
    this.direction = direction;
    this.lastCollide = new Date();
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
