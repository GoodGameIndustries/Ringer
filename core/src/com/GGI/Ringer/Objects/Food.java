package com.GGI.Ringer.Objects;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Food {

	public int theta,ring;
	public ShapeRenderer shape;
	private Vector2 pos = new Vector2();
	private float w = Gdx.graphics.getWidth(),h=Gdx.graphics.getHeight();
	public Circle bounds;
	
	public Food(int theta, int ring){
		this.theta=theta;
		this.ring=ring;
		getPosition();
		bounds = new Circle(pos.x,pos.y,w/100);
		shape = new ShapeRenderer();
	}
	
	public void render(){
		bounds = new Circle(pos.x,pos.y,w/100);
		shape.begin(ShapeType.Filled);
		shape.setColor(Color.GREEN);
		shape.circle(pos.x, pos.y, w/100);
		shape.end();
	}
	
	public void getPosition(){
		pos.x=(float) (ring*(w/10)*Math.cos(theta)+(w/2));
		pos.y=(float) (ring*(w/10)*Math.sin(theta)+(h/2));
	}
}
