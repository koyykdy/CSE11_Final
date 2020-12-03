/**
 * This is the State for the game process itself
 */
package game.elika.rpg.states;

import java.awt.Graphics;

import game.elika.rpg.Handler;
import game.elika.rpg.worlds.World;

public class GameState extends State{
	
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "resources/world/world1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		world.render(g);
	}
	
}
