/**
 * This is the State for the game process itself
 */
package game.elika.rpg.states;

import java.awt.Graphics;

import game.elika.rpg.gfx.Assets;

public class GameState extends State{
	
	public GameState() {
		
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.dirt,0,0,null);
	}
	
}
