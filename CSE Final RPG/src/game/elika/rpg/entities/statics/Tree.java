package game.elika.rpg.entities.statics;

import java.awt.Graphics;

import game.elika.rpg.Handler;
import game.elika.rpg.gfx.Assets;
import game.elika.rpg.tiles.Tile;

public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
		bounds.x = 28;
		bounds.y = 108;
		bounds.width = 8;
		bounds.height = 10;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void die() {
		System.out.println("tree died");
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree,(int) (x-handler.getGameCamera().getxOffset()),
				(int) (y-handler.getGameCamera().getyOffset()),
				width, height, null);
	}
	
}
