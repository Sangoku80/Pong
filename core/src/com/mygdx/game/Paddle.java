package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Paddle {
    public int width = 20;
    public int height = 100;
    public float speed = 300;
    public int y, x;

    public Paddle(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public abstract void Moves(float deltaTime);

    public void Update()
    {
        Moves(Gdx.graphics.getDeltaTime());
    }

    public void Draw(ShapeRenderer shapeRenderer)
    {
        Update();
        shapeRenderer.rect(this.x, this.y, width, height);
    }
}
