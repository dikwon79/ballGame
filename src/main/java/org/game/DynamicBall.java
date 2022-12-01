package org.game;


import processing.core.PImage;
import processing.core.PVector;

import java.awt.*;
import java.util.ArrayList;

public class DynamicBall extends Main {

  PImage img, endBtn, start, end;
  private ArrayList<Idrawable> drawables = new ArrayList<Idrawable>();
  private boolean isMainScreen = false;
  //game start page
  int numBalls = 1;
  int num = -1;//weapon
  float gravity = 0.5f;
  /* energy lost to other balls */
  float friction = -0.5f;

  /* error around edge of ball */
  float spring = 0.05f;
  DynamicBall a;
  Balls[] balls = new Balls[numBalls];

  private int currentNumberWeapon = 0;
  private ArrayList<Weapon> addWeapon = new ArrayList<Weapon>();
  private int maxWeapon = 500;

  private Playergame player;
  public void setup() {
    surface.setTitle("Dynamic Ball game");
    img = loadImage("/src/main/java/org/game/data/intro.jpg");
    endBtn = loadImage("/src/main/java/org/game/data/endBtn.png");
    start = loadImage("/src/main/java/org/game/data/start.png");
    end = loadImage("/src/main/java/org/game/data/exit.png");
    Music introMusic = new Music("intromusic.mp3", true);
    introMusic.start();

    for (int i = 0; i < numBalls; i++) {
      balls[i] = new Balls((float)300,(float)300 ,300,i,balls,this);}

    // Initialize player
    PVector playerDirection = new PVector(1, 1).normalize();
    PVector playerPosition = new PVector(width / 2f, height / 2f);
    // Singleton player
    Playergame player = Playergame.getInstance(playerPosition, playerDirection, this);
    addPlayer(player);

    //weapon



  }
  public void keyPressed(){
    switch(keyCode){
      case RIGHT:

        player.setPosition(player.getPosition().add(new PVector(10,0)));
        break;
      case LEFT:
        player.setPosition(player.getPosition().add(new PVector(-10,0)));
        break;
      case 32:

        Weapon weapon = new Weapon(player.getPosition().x +50,height-150,4,1,100,0 );
        addWeapon(weapon);
        break;
      default:

        break;



    }


  }
  public void addWeapon(Weapon weapon) {

    addWeapon.add(weapon);

  }
  public void drawCircle(float x, float y, float diameter) {
    ellipse(x, y, diameter, diameter);
  }

  public void addPlayer(Playergame player) {
    this.player = player;
    this.drawables.add(player);

  }

  public void draw() {
    //background(10);


    if (isMainScreen){
      img = loadImage("/src/main/java/org/game/data/level1.jpg");
      image(img, 0, 0);
      for (Balls ball : balls) {

        //ball.collide();
        ball.move();
        noStroke();
        fill(126,133,17);
        drawCircle(ball.getXpos(), ball.getYpos(), ball.getDiameter());

      }
      for (Idrawable d : drawables) {
        d.draw(this);
      }

      for (Weapon f : addWeapon) {

        f.move();
        noStroke();
        fill(127,255,0);
        rect(f.getX(),
            f.getY(),
            10,
            1900);

      }

    }else {
      image(img, 0, 0);
      fill(204, 204, 204);
      rect(0, 0, 1280, 40);
      image(endBtn, 1230, 7, 30, 30);
      image(start, 100, 300, 300, 70);
      image(end, 100, 400, 300, 70);
    }

  }
  public void mouseClicked(){
    if ((mouseX > 1230 && mouseX < 1280 ) && (mouseY > 7 && mouseY < 37))
    {
      System.exit(0);

    }
    if ((mouseX > 100 && mouseX < 400 ) && (mouseY >300 && mouseY < 370))
    {
      isMainScreen = true;
    }
    if ((mouseX > 100 && mouseX < 400 ) && (mouseY >400 && mouseY < 470))
    {
      System.exit(0);

    }

  }
  public void mouseDragged(){
     /** int x =
     int y = a.windowY;
     // surface.setLocation(100, 100);
     surface.setLocation(x - mouseX, y-mouseY);
   // surface.setLocation(mouseX, mouseY); */
  }

  public void settings() {
    size(1280, 720);
  }

}
