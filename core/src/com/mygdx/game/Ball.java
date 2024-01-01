package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ball {

    public int rayon = 10;
    public Vector2 position;
    public Circle ball;
    public float xSpeed = 300;
    public float ySpeed = 300;
    public Rectangle rectCollision;

    public Ball()
    {
        position = new Vector2(0, 0);
        ball = new Circle(position.x, position.y, rayon);
        rectCollision = new Rectangle(position.x-rayon, position.y-rayon, 2*rayon, 2*rayon);
    }

    public void Update(float DeltaTime)
    {
        // mouvement TEST
        position.x += xSpeed*DeltaTime;
        position.y += ySpeed*DeltaTime;

        // mise à jour de la position du collide
        rectCollision.x = position.x-rayon;
        rectCollision.y = position.y-rayon;

        // collisions avec les bords
        if (position.x < 0 || position.x > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        if (position.y < 0 || position.y > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }

    }

    public void Draw(ShapeRenderer shapeRenderer)
    {

        // mise à jour de la balle et de son collide
        Update(Gdx.graphics.getDeltaTime());

        // dessin de la balle
        shapeRenderer.setColor(1,1,1,1);
        shapeRenderer.circle(position.x, position.y, ball.radius);

    }
}
