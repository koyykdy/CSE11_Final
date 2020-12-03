package game.elika.rpg.entities.statics;

import java.awt.Graphics;

import game.elika.rpg.Handler;
import game.elika.rpg.gfx.Assets;
import game.elika.rpg.tiles.Tile;

public class Round extends StaticEntity{

	public Round(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Tile.TILEWIDTH;
		bounds.height = Tile.TILEHEIGHT;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void die() {
		System.out.println("round died");
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.round,(int) (x-handler.getGameCamera().getxOffset()),
				(int) (y-handler.getGameCamera().getyOffset()),
				width, height, null);
	}
	
}
