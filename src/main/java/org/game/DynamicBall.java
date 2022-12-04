package org.game;


import processing.core.PImage;
import processing.core.PVector;

import java.awt.*;
import java.util.ArrayList;

public class DynamicBall extends Main {

  PImage img, endBtn, start, end;
  private ArrayList<Idrawable> drawables = new ArrayList<Idrawable>();
  private ArrayList<Icollidable> collidables = new ArrayList<Icollidable>();

  private ArrayList<AbstractCharacter> characters = new ArrayList<AbstractCharacter>();

  private ArrayList<Icollidable> removeQuearray = new ArrayList<Icollidable>();

  private ArrayList<Balls> addBallsQue = new ArrayList<Balls>();

  //private ArrayList<Balls> addBallimsi = new ArrayList<Balls>();
  private int  isMainScreen = 0;

  private int currentNumberWeapon = 0;
  private ArrayList<Weapon> addWeapon = new ArrayList<Weapon>();


  private int maxWeapon = 500;

  private Playergame player;
  //game start page
  int numBalls = 1;

  int score =0;
  private int currentNumber = 0;

  DynamicBall a;




  public void setup() {
    surface.setTitle("Dynamic Ball game");
    img = loadImage("/src/main/java/org/game/data/intro.jpg");
    endBtn = loadImage("/src/main/java/org/game/data/endBtn.png");
    start = loadImage("/src/main/java/org/game/data/start.png");
    end = loadImage("/src/main/java/org/game/data/exit.png");


    Music introMusic = new Music("intromusic.mp3", true);
    introMusic.start();


    for (int i = 0; i < numBalls; i++) {

      PVector Position = new PVector(300, 300);
      Balls balls = new Balls(Position,300,300, 5,Position.x,Position.y, this);
      addBalls(balls);
    }


    // Initialize player
    float playerWidth = 100;
    float playerHeight = 150;
    PVector playerPosition = new PVector(width / 2f, height / 2f);
    // Singleton player
    Playergame player = Playergame.getInstance(playerPosition, playerWidth, playerHeight , this);
    addPlayer(player);

    //weapon


  }

  public void ballDouble(Balls c){
      PVector Position = new PVector(c.position.x,c.position.y);
      Balls balls = new Balls(Position,c.width/2,c.height/2,5,c.position.x,c.position.y,this);
      addBallsQue.add(balls);

      PVector Position2 = new PVector(c.position.x,c.position.y);
      Balls balls2 = new Balls(Position2,c.width/2,c.height/2, -5,c.position.x,c.position.x,this);
      addBallsQue.add(balls2);

  }
  public void keyPressed(){
    switch(keyCode){
      case RIGHT:

        player.setPosition(player.position.add(new PVector(15,0)));
        break;
      case LEFT:
        player.setPosition(player.position.add(new PVector(-15,0)));
        break;
      case 32:
        PVector Position = new PVector(player.position.x,player.position.y+50);
        Weapon weapon = new Weapon(Position,100,height-150,this);
        addWeapon(weapon);
        break;
      default:

        break;



    }


  }
  public void addWeapon(Weapon weapon) {

    this.addWeapon.add(weapon);
    this.drawables.add(weapon);
    this.collidables.add(weapon);
  }
  public void addBalls(Balls balls) {

    this.drawables.add(balls);
    this.collidables.add(balls);
    //this.collidables.add(weapon);
  }
  private void removeQue(Icollidable c) {
    if (this.currentNumber > 0) {
      this.currentNumber -= 1;
      this.addBallsQue.remove(c);
      this.drawables.remove(c);
      this.collidables.remove(c);
    }
  }
  public void removeObj(Icollidable c) {
    currentNumber++;
    removeQuearray.add(c);
  }

  public void addPlayer(Playergame player) {
    this.player = player;
    this.drawables.add(player);
    this.characters.add(player);
  }

  public void drawCircle(float x, float y, float diameter) {
    ellipse(x, y, diameter, diameter);
  }



  public void draw() {
    //background(10);


    if (isMainScreen == 1){
      img = loadImage("/src/main/java/org/game/data/level1.jpg");

      image(img, 0, 0);

      for (Balls f : addBallsQue) {
        addBalls(f);
      }
      addBallsQue.clear();

      if(drawables.size() == 1){

        levelup();
      }
      for (Idrawable d : drawables) {

        d.draw(this);

      }

      //character and balls
      for (Icollidable a : characters) {
        for (Icollidable b : collidables) {

          if (a.collided(b)) {
            a.collideBehaviour(b);
            isMainScreen = 3;
          }
        }
      }
      //weapon and ball collidabale
      for (Icollidable a : collidables) {
          for (Icollidable b : collidables) {

            if (a.collided(b)) {
              a.collideBehaviour(b);
            }
          }
      }
      for (Icollidable f : removeQuearray) {
          removeQue(f);
      }
      removeQuearray.clear();


      textSize(80);
      fill(255,255,255);
      text("Score:"+ score, 20, 60);
      fill(163, 237, 194);

      text("Level "+ numBalls, width/2-30, 60);

    }else if(isMainScreen == 0){
      image(img, 0, 0);
      fill(204, 204, 204);
      rect(0, 0, 1280, 40);
      image(endBtn, 1230, 7, 30, 30);
      image(start, 100, 300, 300, 70);
      image(end, 100, 400, 300, 70);

    }else{
      reset();
    }
  }

  public void levelup(){

    addBallsQue.clear();
    drawables.clear();
    collidables.clear();


    fill(237, 28, 36);
    textSize(150);
    text("Game clear", width/2, height/3 - 40);

    numBalls++;
    for (int i = 0; i < numBalls; i++) {

      PVector Position = new PVector( random(100, 1000),  random(100, 300));
      Balls balls = new Balls(Position,300,300, 5,Position.x,Position.y, this);
      addBalls(balls);
    }


    // Initialize player
    float playerWidth = 100;
    float playerHeight = 150;
    PVector playerPosition = new PVector(width / 2f, height / 2f);
    // Singleton player
    Playergame player = Playergame.getInstance(playerPosition, playerWidth, playerHeight , this);
    addPlayer(player);


  }
  public void reset(){
    gameOver("score",score);
    noLoop();

    addBallsQue.clear();
    drawables.clear();
    collidables.clear();
    isMainScreen = 0;

    for (int i = 0; i < numBalls; i++) {

      PVector Position = new PVector(300, 300);
      Balls balls = new Balls(Position,300,300, 5,Position.x,Position.y, this);
      addBalls(balls);
    }


    // Initialize player
    float playerWidth = 100;
    float playerHeight = 150;
    PVector playerPosition = new PVector(width / 2f, height / 2f);
    // Singleton player
    Playergame player = Playergame.getInstance(playerPosition, playerWidth, playerHeight , this);
    addPlayer(player);


  }
  public void gameOver(String text, int score){

    fill(237, 28, 36);
    textSize(170);

    text("Game over", width/3, height/3 - 70);
    textSize(100);
    text(text + " "+score,width/3, height/3+20);

    fill(255, 255, 255);
    textSize(50);
    //database connection
    //System.out.println("connection: " + connection.isAdmin("1","50"));
    DbConnection connection = new DbConnection();
    connection.selectAll(this);
    connection.insert(String.valueOf(numBalls),String.valueOf(score));

    strokeWeight(3);
    stroke(255, 255, 0);
    fill(255);

    rect(width/4+400,300,300,100);
    fill(0, 0, 0);
    text("RESTART",width/4+430,380);
    fill(255, 255, 255);
    rect(width/4+400,500,300,100);
    fill(0, 0, 0);
    text("END",width/4+430,580);




  }
  public void mouseClicked(){
    if ((mouseX > 1230 && mouseX < 1280 ) && (mouseY > 7 && mouseY < 37))
    {
      System.exit(0);

    }
    if ((mouseX > 100 && mouseX < 400 ) && (mouseY >300 && mouseY < 370))
    {
      isMainScreen = 1;
    }
    if ((mouseX > 100 && mouseX < 400 ) && (mouseY >400 && mouseY < 470))
    {
      System.exit(0);

    }
    if ((mouseX >= width/4+400 && mouseX <= width/4+700 ) && (mouseY >=300 && mouseY <= 400))
    {
      loop();
      isMainScreen = 1;

    }
    if ((mouseX >= width/4+400 && mouseX <= width/4+700) && (mouseY >=500 && mouseY <= 600))
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
