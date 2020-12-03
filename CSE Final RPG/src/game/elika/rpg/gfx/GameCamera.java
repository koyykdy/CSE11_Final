package game.elika.rpg.gfx;

import game.elika.rpg.Handler;
import game.elika.rpg.entities.Entity;
import game.elika.rpg.tiles.Tile;

public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.handler = handler;
	}

	public void centerOnEntity(Entity e) {
		xOffset = e.getX()-handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY()-handler.getHeight() / 2 + e.getHeight() / 2;
		if (handler.getWidth() < handler.getWorld().getWidth() * Tile.TILEWIDTH ) {
			checkBlankSpaceX();
		}
		if (handler.getHeight() < handler.getWorld().getHeight() * Tile.TILEHEIGHT) {
			checkBlankSpaceY();
		}
	}
	
	public void move(float xAmount, float yAmount) {
		xOffset += xAmount;
		yOffset += yAmount;
		if (handler.getWidth() < handler.getWorld().getWidth() * Tile.TILEWIDTH 
				) {
			checkBlankSpaceX();
		}
		if (handler.getHeight() < handler.getWorld().getHeight() * Tile.TILEHEIGHT 
				) {
			checkBlankSpaceY();
		}
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpaceX() {
		if (xOffset < 0) {
			xOffset = 0;
		}
		else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
	}
	
	public void checkBlankSpaceY() {
		if (yOffset < 0) {
			yOffset = 0;
		}
		else if (yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
		}
	}
	
}
