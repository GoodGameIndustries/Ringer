/**
 * 
 */
package com.GGI.Ringer.Screens;



import java.util.ArrayList;

import com.GGI.Ringer.Ringer;
import com.GGI.Ringer.Objects.Food;
import com.GGI.Ringer.Objects.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Intersector;

/**
 * @author Emmett
 *
 */
public class GameScreen implements Screen,InputProcessor{

	private Ringer r;
	private ShapeRenderer shape;
	private float w=Gdx.graphics.getWidth(),h = Gdx.graphics.getHeight();
	private Player player = new Player();
	private float speed=.01f;
	private ArrayList<Food> food = new ArrayList<Food>();
	
	public GameScreen(Ringer r){
		this.r=r;
		populate();
	}
	
	private void populate() {
		for(int i = 0; i < 3;i++){
			food.add(new Food((int)(Math.random()*100),(int)(Math.random()*4)+1));
		}
		
	}

	@Override
	public void show() {
		shape = new ShapeRenderer();
		Gdx.input.setInputProcessor(this);
		
	}

	@Override
	public void render(float delta) {
		speed*=1.001f;
		player.theta+=(speed)*Math.pow(-1, player.ring);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glLineWidth(w/100);
		shape.begin(ShapeType.Line);
		
		shape.setColor(Color.BLACK);
		shape.circle(w/2, h/2, 1*w/10,(int) (w/10));
		shape.circle(w/2, h/2, 2*w/10,(int) (w/10));
		shape.circle(w/2, h/2, 3*w/10,(int) (w/10));
		shape.circle(w/2, h/2, 4*w/10,(int) (w/10));
		shape.end();
		
		player.getPosition();
		
		for(int i = 0; i < food.size();i++){
			food.get(i).render();
			if(Intersector.overlaps(food.get(i).bounds, player.bounds)){
				food.remove(i);
				player.food+=20;
				food.add(new Food((int)(Math.random()*100),(int)(Math.random()*4)+1));
			}
		}
		player.render();
		
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenY = (int) (h-screenY);
		if(dist(screenX,screenY)>dist((int)player.pos.x,(int)player.pos.y)&&player.ring<4){
			player.ring++;
		}
		else if(player.ring>1&&dist(screenX,screenY)<dist((int)player.pos.x,(int)player.pos.y)){
			player.ring--;
		}
		
		return true;
	}

	

	private float dist(int x, int y) {
		float distance;
		distance = (float) Math.sqrt((x-(w/2))*(x-(w/2)) + (y-(h/2))*(y-(h/2)));
		return distance;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
