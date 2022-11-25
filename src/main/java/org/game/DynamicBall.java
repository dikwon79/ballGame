package org.game;


import processing.core.PApplet;
import processing.core.PImage;

import java.awt.event.MouseEvent;

public class DynamicBall extends Main {

  PImage img, endBtn, start, end;
  private boolean isMainScreen = false;
  //game start page

  public void setup() {
    surface.setTitle("Dynamic Ball game");
    img = loadImage("/src/main/java/org/game/data/intro.jpg");
    endBtn = loadImage("/src/main/java/org/game/data/endBtn.png");
    start = loadImage("/src/main/java/org/game/data/start.png");
    end = loadImage("/src/main/java/org/game/data/exit.png");
    Music introMusic = new Music("intromusic.mp3", true);
    introMusic.start();
  }
  public void draw() {
    //background(10);


    if (isMainScreen){
      img = loadImage("/src/main/java/org/game/data/level1.jpg");
      image(img, 0, 0);




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
     //int x = .
    //int y = windowY;
    //windowMove(mouseX,mouseY);
    //surface.setLocation(x - mouseX, y-mouseY);
  }

  public void settings() {
    size(1280, 720);
  }

}
