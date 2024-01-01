package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class Main extends ApplicationAdapter {

	private ShapeRenderer shapeRenderer;
	public static Player player;
	private OrthographicCamera camera;
	public Ennemy ennemy;
    public Ball ball;
	
	@Override
	public void create () {

		// création de la caméra
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		// création du shapeRenderer
		shapeRenderer = new ShapeRenderer();

		// création du joueur
		player = new Player();

		// création de l'ennemi
		ennemy = new Ennemy();

        // création de la balle
        ball = new Ball();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);

		// mise à jour de la caméra
		camera.update();

		// affichage du shapeRenderer dans le système de coordonnées de la caméra
		shapeRenderer.setProjectionMatrix(camera.combined);

		// shapeRenderer
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

		// dessin du joueur
		shapeRenderer.setColor(1, 1, 1, 1);
		player.Draw(shapeRenderer);

		// dessin de l'ennemi
		ennemy.Draw(shapeRenderer);

		// dessin du décor
		Decor(shapeRenderer);

        // dessin de la balle
        ball.Draw(shapeRenderer);

		// fin shapeRenderer
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		shapeRenderer.dispose();
	}

	public void Decor(ShapeRenderer shapeRenderer)
	{

		int width_height = 10;
		for(int i = 0; i<Gdx.graphics.getHeight()/width_height; i++)
		{
			shapeRenderer.rect((float) Gdx.graphics.getWidth() /2, (float) (i*1.5*width_height), width_height, width_height);
		}
	}
}
