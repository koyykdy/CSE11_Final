/**
 * this class implements a cropping feature for tile-based graphics from sprite sheets.
 */
package game.elika.rpg.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sheet;
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}
