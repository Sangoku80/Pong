package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Ennemy extends Paddle{

    public Ennemy(OrthographicCamera camera) {
        super((int) (camera.viewportWidth-20), (int) (camera.viewportHeight/2));
    }

    @Override
    public void Moves(float deltaTime) {

        // inputs
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            if((this.y + this.height) < Gdx.graphics.getHeight())
            {
                this.y += (int) (deltaTime*speed);

            }
        }

        if(y > 0)
        {
            if(Gdx.input.isKeyPressed((Input.Keys.DOWN)))
            {
                this.y -= (int) (deltaTime*speed);
            }
        }
    }
}
