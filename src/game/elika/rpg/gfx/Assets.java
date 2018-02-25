/**
 * this is where all the assets (tiles, sprite sheets, backgrounds, images, etc.) will be defined
 * having asset calls makes the game run smoother as pre-determined areas of a single imported image
 * can be called much more efficiently than having to import an entire image at every rendering of the
 * game scree.
 */
package game.elika.rpg.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage grass, dirt, empty;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		grass = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width, 0, width, height);
		empty = sheet.crop(width  *2, 0, width, height);
	}
}
