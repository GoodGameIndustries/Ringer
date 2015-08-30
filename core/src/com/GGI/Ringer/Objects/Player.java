package com.GGI.Ringer.Objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Player {

	public Vector2 pos = new Vector2();
	public ArrayList<Vector2> trail = new ArrayList<Vector2>();
	private ShapeRenderer shape;
	private float w = Gdx.graphics.getWidth(),h=Gdx.graphics.getHeight();
	public int ring = 1;
	public float theta = 0;
	public int food =20;
	public Circle bounds;
	
	public Player(){
		shape = new ShapeRenderer();
		getPosition();
		bounds = new Circle(pos.x,pos.y,w/75);
	}
	
	public void render(){
				
		bounds = new Circle(pos.x,pos.y,w/75);
		
		shape.begin(ShapeType.Line);
		shape.setColor(Color.RED);
		
		for(int i = 0; i < trail.size()-1;i++){
			shape.line(trail.get(i), trail.get(i+1));
		}
		
		shape.end();
		
		shape.begin(ShapeType.Filled);
		shape.setColor(Color.RED);
		shape.circle(pos.x, pos.y, w/75);
		shape.end();
		
		trail.add(pos.cpy());
		if(trail.size()>food){trail.remove(0);}
		
		
	}
	
	public void getPosition(){
		pos.x=(float) (ring*(w/10)*Math.cos(theta)+(w/2));
		pos.y=(float) (ring*(w/10)*Math.sin(theta)+(h/2));
	}
	
}
