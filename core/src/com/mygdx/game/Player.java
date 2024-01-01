package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class Player extends Paddle{
    public Player() {
        super(new Vector2(20, (float) Gdx.graphics.getHeight() /2));
    }

    @Override
    public void Moves(float deltaTime) {

        // inputs
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            if((position.y + this.height) < Gdx.graphics.getHeight())
            {
                position.y += deltaTime*speed;

            }
        }

        if(position.y > 0)
        {
            if(Gdx.input.isKeyPressed((Input.Keys.DOWN)))
            {
                position.y -= deltaTime*speed;
            }
        }
    }
}
