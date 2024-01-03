package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {

	private ShapeRenderer shapeRenderer;
	private BitmapFont font;
	private SpriteBatch batch;
	public static Player player;
	private OrthographicCamera camera;
	public static Ennemy ennemy;
	public static int score = 0;
    public Ball ball;
	
	@Override
	public void create () {

		// création de la caméra
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		// création du shapeRenderer
		shapeRenderer = new ShapeRenderer();

		// création du spriteBatch
		batch = new SpriteBatch();

		// création du bitmapFont
		font = new BitmapFont();

		// création du joueur
		player = new Player(camera);

		// création de l'ennemi
		ennemy = new Ennemy(camera);

        // création de la balle
        ball = new Ball(camera);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);

		// mise à jour de la caméra
		camera.update();

		// affichage du shapeRenderer dans le système de coordonnées de la caméra
		shapeRenderer.setProjectionMatrix(camera.combined);

		// affichage du spriteBatch dans le système de coordonnées de la caméra
		batch.setProjectionMatrix(camera.combined);

		// shapeRenderer
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

		// dessin du décor
		Decor(shapeRenderer);

		// changement de la couleur
		shapeRenderer.setColor(1, 1, 1, 1);

        // dessin du joueur
        player.Draw(shapeRenderer);

        // dessin de l'ennemi
        ennemy.Draw(shapeRenderer);

        // dessin de la balle
        ball.Draw(shapeRenderer, camera);

		// fin shapeRenderer
		shapeRenderer.end();

		// spriteBatch
		batch.begin();

		// dessin du score
		font.draw(batch, "Score: " + score, 100, 100);

		// fin spriteBatch
		batch.end();

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
