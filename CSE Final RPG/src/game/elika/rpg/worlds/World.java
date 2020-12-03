package game.elika.rpg.worlds;

import java.awt.Graphics;

import WorldGeneration.GenerateMap;
//import game.elika.rpg.Game;
import game.elika.rpg.Handler;
import game.elika.rpg.entities.EntityManager;
import game.elika.rpg.entities.creatures.Player;
import game.elika.rpg.entities.statics.Round;
import game.elika.rpg.entities.statics.Tree;
import game.elika.rpg.tiles.Tile;
import game.elika.rpg.utils.Utils;

public class World{
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	//entities
	private EntityManager entityManager;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		entityManager.addEntity(new Tree(handler, 100, 250));
		entityManager.addEntity(new Round(handler, 300, 300));
		
		GenerateMap.writeMap();

		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[tokens.length-4]);
		height = Utils.parseInt(tokens[tokens.length-3]);
		spawnX = Utils.parseInt(tokens[tokens.length-2]);
		spawnY = Utils.parseInt(tokens[tokens.length-1]);

		
		tiles = new int[width][height];
		for (int y=0;y<height;y++) {
			for (int x=0;x<width;x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x+y*width)]);
			}
		}
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void tick() {
		entityManager.tick();
	}
	public Tile getTile(int x, int y) {
		if(x<0||y<0||x>=width||y>=height)
			return Tile.grassTile; // prevents game from crashing if character bugs out of bounds
		
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.dirtTile;
		return t;
	}
	public void render(Graphics g) {
		
		int xStart = (int) Math.max(0, (handler.getGameCamera().getxOffset() / Tile.TILEWIDTH - 1));
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset()+handler.getWidth())/Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, (handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT - 1));
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset()+handler.getHeight())/Tile.TILEHEIGHT + 1);
		
		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g,(int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//entities
		entityManager.render(g);
	}
	public int getSpawnX() {
		return spawnX;
	}
	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}
	public int getSpawnY() {
		return spawnY;
	}
	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}
}