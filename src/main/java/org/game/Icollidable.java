package org.game;

import processing.core.PVector;

public interface Icollidable {

    boolean collided(Icollidable c);

    PVector getPosition();

    float getWidth();

    float getHeight();

    BoundingBox getBoundingBox();

    void collideBehaviour(Icollidable c);
}
