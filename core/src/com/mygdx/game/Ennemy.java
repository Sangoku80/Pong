package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Ennemy extends Paddle{

    public Ennemy() {
        super(new Vector2(Gdx.graphics.getWidth()- (20+15), (float) Gdx.graphics.getHeight() /2));
    }

    @Override
    public void Moves(float deltaTime) {

    }
}
