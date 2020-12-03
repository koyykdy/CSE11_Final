package game.elika.rpg.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import game.elika.rpg.ui.ClickListener;
import game.elika.rpg.ui.UIObject;

public class UIImageButton extends UIObject{

	private BufferedImage[] images;
	private ClickListener clicker;
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if (hovering) {
			if (mouseDown) {
				g.drawImage(images[2],(int)x,(int)y,width,height,null);
			}
			else {
				g.drawImage(images[1],(int) x,(int) y,width,height,null);
			}
		
		}
		else {
			g.drawImage(images[0],(int) x,(int) y,width,height,null);
		}
	}

	@Override
	public void onClick() {
		//clicked = true;
		clicker.onClick();
	}
	
}
