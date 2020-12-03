package game.elika.rpg.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

//import game.elika.rpg.Game;
import game.elika.rpg.Handler;

public abstract class Entity {
	public static final int DEFAULT_HEALTH = 10;
	
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected int health;
	protected Rectangle bounds;
	protected boolean active = true;
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		health = DEFAULT_HEALTH;
		
		bounds = new Rectangle(0,0,width,height); //sets default bounds of tile of entity for collision det.
	}
	
	public int getHealth() {
		return health;
	}

	public abstract void die();
	
	public void hurt(int amt) {
		health -= amt;
		if (health <=0) {
			active = false;
			die();
		}
	}
	
	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public static int getDefaultHealth() {
		return DEFAULT_HEALTH;
	}


	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this)) {
				continue;
			}
			if (e.getCollisionBounds(0, 0).intersects(getCollisionBounds(xOffset,yOffset))) {
				return true;
			}
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int)(x + bounds.x + xOffset), (int)(y + bounds.y + yOffset), 
				bounds.width, bounds.height);
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
}
