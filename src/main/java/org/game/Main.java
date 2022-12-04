package org.game;

import processing.core.PApplet;


public class Main extends PApplet{
  public static void main(String[] Args) {
    String[] appletArgs = new String[]{"window"};
    DynamicBall window = new DynamicBall();
    PApplet.runSketch(appletArgs, window);

  }
}