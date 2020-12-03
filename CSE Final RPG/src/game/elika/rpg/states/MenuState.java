/** 
 * this is the state for the menu screen.
 */
package game.elika.rpg.states;

import java.awt.Graphics;

import game.elika.rpg.Handler;
import game.elika.rpg.gfx.Assets;
import game.elika.rpg.ui.UIImageButton;
import game.elika.rpg.ui.UIManager;
import game.elika.rpg.ui.ClickListener;

public class MenuState extends State{

	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(336,268,128,64,Assets.startButton, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null); //set and un-set UI manager
				State.setState(handler.getGame().gameState);
			}
		}));
	}
	
	
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		uiManager.tick();
		//below code is to cancel out menu screen for development purposes, comment out when done
		//handler.getMouseManager().setUIManager(null);
		//State.setState(handler.getGame().gameState);
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		uiManager.render(g);
	}

}
