package game.elika.rpg.entities.creatures;

import game.elika.rpg.Handler;
import game.elika.rpg.entities.Entity;
import game.elika.rpg.tiles.Tile;

public abstract class Creature extends Entity{
	
	
	protected float speed, xMove, yMove;
	
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void moveX() {
		if (xMove > 0) {  //moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width)/Tile.TILEWIDTH; //temporary x
			if (!collisionWithTile(tx, (int) (y+bounds.y)/Tile.TILEHEIGHT) && 
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height)/Tile.TILEHEIGHT)) {
				x += xMove;
			}
			else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		}
		else if (xMove < 0) {  //moving left
			int tx = (int) (x + xMove + bounds.x)/Tile.TILEWIDTH; //temporary x
			if (!collisionWithTile(tx, (int) (y+bounds.y)/Tile.TILEHEIGHT) && 
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height)/Tile.TILEHEIGHT)) {
				x += xMove;
			}
			else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x ;
			}
		}
	}
	
	
	public void moveY() {
		if (yMove < 0) { //up
			int ty = (int) (y + yMove + bounds.y)/Tile.TILEHEIGHT;
			if (!collisionWithTile((int) (x + bounds.x)/Tile.TILEWIDTH , ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width)/Tile.TILEWIDTH, ty)) {
				y += yMove;
			}
			else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		}
		else if (yMove > 0) { //down
			int ty = (int) (y + yMove + bounds.y + bounds.height)/Tile.TILEHEIGHT;
			if (!collisionWithTile((int) (x + bounds.x)/Tile.TILEWIDTH , ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width)/Tile.TILEWIDTH, ty)) {
				y += yMove;
			}
			else {
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}
	
	public void move() {
		if (!checkEntityCollisions(xMove,0f))
			moveX();
		if (!checkEntityCollisions(0f,yMove))
			moveY();
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	
	public float getxMove() {
		return xMove;
	}
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}
	public float getyMove() {
		return yMove;
	}
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
}