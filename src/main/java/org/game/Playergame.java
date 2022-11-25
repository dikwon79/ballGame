package org.game;

import processing.core.PVector;

public class Playergame extends AbstractCharacter{

  public Playergame(PVector position, PVector direction) {
    super(position, direction);
  }

  @Override
  public PVector getPosition() {
    return null;
  }

  @Override
  public float getWidth() {
    return 0;
  }

  @Override
  public float getHeight() {
    return 0;
  }

  // colliding with balls makes game over.
  @Override
  public void collideBehaviour(Icollidable c) {

  }

  @Override
  public void draw() {

  }

  // choose the one of 3kinds weapons
  public void weponChoose(){

  }

  // attack balls
  public void attack(){

  }
}
