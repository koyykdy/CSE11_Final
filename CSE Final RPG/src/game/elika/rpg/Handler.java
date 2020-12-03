package game.elika.rpg;

import game.elika.rpg.gfx.GameCamera;
import game.elika.rpg.input.KeyManager;
import game.elika.rpg.input.MouseManager;
import game.elika.rpg.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game) {
		this.game = game;
	}

	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
}
