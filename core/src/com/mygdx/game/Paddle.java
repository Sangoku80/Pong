package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Paddle {

    protected Vector2 position;
    protected Rectangle paddle;
    protected int width = 15;
    protected int height = 60;
    protected float speed = 600;

    public Paddle(Vector2 position)
    {
        this.position = position;
        this.paddle = new Rectangle(position.x, position.y, width, height);
    }

    public abstract void Moves(float deltaTime);

    public void Update()
    {
        Moves(Gdx.graphics.getDeltaTime());
    }

    public void Draw(ShapeRenderer shapeRenderer)
    {
        Update();
        shapeRenderer.rect(position.x, position.y, paddle.width, paddle.height);
    }
}
