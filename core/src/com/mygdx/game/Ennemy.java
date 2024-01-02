package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class Ennemy extends Paddle{

    public Ennemy(OrthographicCamera camera) {
        super((int) (camera.viewportWidth-20), (int) (camera.viewportHeight/2));
    }

    @Override
    public void Moves(float deltaTime) {

    }
}
