package org.game;

import processing.core.PVector;

import java.awt.*;

public class Playergame extends AbstractCharacter{

  Color color;
  private static Playergame playerCharacter;
  PVector position;
  public Playergame(PVector position, PVector direction, DynamicBall window) {

    super(position, direction, window);
    this.color =new Color(240,10,10);
    this.position= new PVector(window.width/2, window.height);

  }

  public static Playergame getInstance(PVector position, PVector direction, DynamicBall window) {
    if (playerCharacter == null) {
      playerCharacter = new Playergame(position, direction, window);
    }
    return playerCharacter;
  }
  @Override
  public PVector getPosition() {
    return this.position;
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
  public void draw(DynamicBall window) {
    window.fill(color.getRed(), color.getGreen(), color.getGreen());
    window.rect(playerCharacter.getPosition().x,
        window.height-150,
        100,
        150);

  }

  // choose the one of 3kinds weapons
  public void weponChoose(){

  }

  // attack balls
  public void attack(){

  }

}
