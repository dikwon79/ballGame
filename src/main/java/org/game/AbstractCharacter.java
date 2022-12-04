package org.game;

import processing.core.PVector;

import java.util.Date;

public abstract class AbstractCharacter implements Idrawable, Icollidable  {
  protected PVector position;

  protected float width = 10f;
  // height of the character
  protected float height = 10f;
  protected Date lastCollide;
  protected DynamicBall window;


  public AbstractCharacter(PVector position, float width, float height, DynamicBall window) {
    this.position = position;
    this.width = width;
    this.height = height;
    this.lastCollide = new Date();
    this.window = window;
  }

  public void setPosition(PVector position) {
    this.position = position;
  }

  @Override
  public BoundingBox getBoundingBox() {
    return new BoundingBox(this.getPosition(), this.getWidth(), this.getHeight());
  }
  @Override
  public float getWidth() {
    return this.width;
  }
  @Override
  public PVector getPosition() {
    return this.position;
  }
  @Override
  public float getHeight() {
    return this.height;
  }



  public boolean collided(Icollidable other) {
    if (this.equals(other)) {
      return false;
    }
    BoundingBox otherBounds = other.getBoundingBox();
    boolean collides = getBoundingBox().collides(otherBounds);

    return collides;
  }
  public abstract void move();

}
