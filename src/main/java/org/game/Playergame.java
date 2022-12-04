package org.game;

import processing.core.PImage;
import processing.core.PVector;

import java.awt.*;

import static processing.awt.ShimAWT.loadImage;

public class Playergame extends AbstractCharacter{

  PImage playerimg;
  Color color;
  float width;
  float height;
  private static Playergame playerCharacter;
  PVector position;
  public Playergame(PVector position, float width, float height, DynamicBall window) {

    super(position, width, height, window);
    this.color =new Color(240,10,10);
    this.position= new PVector(window.width/2, window.height);
    this.width = 100;
    this.height = 150;

  }

  public static Playergame getInstance(PVector position, float width, float height, DynamicBall window) {
    if (playerCharacter == null) {
      playerCharacter = new Playergame(position, width, height, window);
    }
    return playerCharacter;
  }
  @Override
  public PVector getPosition() {
    return this.position;
  }

  @Override
  public float getWidth() {
    return width;
  }

  @Override
  public float getHeight() {
    return height;
  }

  @Override
  public void move() {

  }

  // colliding with balls makes game over.
  @Override
  public void collideBehaviour(Icollidable c) {

    if (c instanceof Balls) {
      System.out.println("player was dead");
    }


  }

  @Override
  public void draw(DynamicBall window) {
    window.fill(color.getRed(), color.getGreen(), color.getGreen());

    playerimg = window.loadImage("/src/main/java/org/game/data/player.png");
    window.image(playerimg,playerCharacter.getPosition().x, window.height-150,width,height);
    //window.rect(playerCharacter.getPosition().x,
     //   window.height-150,
      //  width,
      //  height);

  }



}
