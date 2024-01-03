package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    public float x, y;
    public float xDir, yDir;
    public float speed = 200;
    public float rayon = 10;

    public Ball(OrthographicCamera camera)
    {
        this.x = camera.viewportWidth / 2;
        this.y = camera.viewportHeight / 2;
        this.xDir = 1;
        this.yDir = 1;
    }

    public void Update(float DeltaTime, OrthographicCamera camera)
    {
        // mouvement
        x += speed*xDir*DeltaTime;
        y += speed*yDir*DeltaTime;

        // collision avec le joueur et l'ennemi
        if (x < Main.player.width && y > Main.player.y && y < Main.player.y + Main.player.height) {
            xDir = 1;
            Main.score += 1;
        }

        if(x > camera.viewportWidth - Main.ennemy.width && y > Main.ennemy.y && y < Main.ennemy.y + Main.ennemy.height)
        {
            xDir = -1;
            Main.score += 1;
        }

        // collisions avec les bords
        if (y > camera.viewportHeight - rayon || y <= 0) {
            yDir *= -1;
        }

        if (x > camera.viewportWidth - rayon || x <= 0) {
            xDir *= -1;
        }

    }

    public void Draw(ShapeRenderer shapeRenderer, OrthographicCamera camera)
    {

        // mise à jour de la balle
        Update(Gdx.graphics.getDeltaTime(), camera);

        // dessin de la balle
        shapeRenderer.setColor(1,1,1,1);
        shapeRenderer.circle(x, y, rayon);
        System.out.println(x);
    }
}
