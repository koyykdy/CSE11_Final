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
	
	public static BufferedImage grass, dirt, stone,tree, player, bgi, round;
	public static BufferedImage[] playerDown, playerUp, playerLeft, playerRight, playerStill;
	public static BufferedImage[] enemyDown, enemyUp, enemyLeft, enemyRight, enemyStill;
	public static BufferedImage[] startButton;
	
	public static BufferedImage[] playerAttDown, playerAttUp, playerAttLeft, playerAttRight;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet1.png"));
		playerDown = new BufferedImage[2];
		playerDown[0] = sheet.crop(0, height*2, width, height);
		playerDown[1] = sheet.crop(width, height*2, width, height);
		
		playerUp = new BufferedImage[2];
		playerUp[0] = sheet.crop(0, height*3, width, height);
		playerUp[1] = sheet.crop(width, height*3, width, height);
		
		playerLeft = new BufferedImage[4];
		playerLeft[0] = sheet.crop(0, height*4, width, height);
		playerLeft[1] = sheet.crop(width, height*4, width, height);
		playerLeft[2] = sheet.crop(width*2, height*4, width, height);
		playerLeft[3] = sheet.crop(width*3, height*4, width, height);
		
		playerRight = new BufferedImage[4];
		playerRight[0] = sheet.crop(0, height*5, width, height);
		playerRight[1] = sheet.crop(width, height*5, width, height);
		playerRight[2] = sheet.crop(width*2, height*5, width, height);
		playerRight[3] = sheet.crop(width*3, height*5, width, height);
		//-------------------------------------------------------------
		playerStill = new BufferedImage[2];
		playerStill[0] = sheet.crop(width, height, width, height);
		playerStill[1] = sheet.crop(width*2, height, width, height);
		//-------------------------------------------------------------
		playerAttUp = new BufferedImage[2];
		playerAttUp[0] = sheet.crop(width*2, height*3, width, height);
		playerAttUp[1] = sheet.crop(width*3, height*3, width, height);
		
		playerAttDown = new BufferedImage[2];
		playerAttDown[0] = sheet.crop(width*2, height*2, width, height);
		playerAttDown[1] = sheet.crop(width*3, height*2, width, height);
		
		playerAttLeft = new BufferedImage[4];
		playerAttLeft[0] = sheet.crop(width*4, height*6, width, height);
		playerAttLeft[1] = sheet.crop(width*5, height*6, width, height);
		playerAttLeft[2] = sheet.crop(width*6, height*6, width, height);
		playerAttLeft[3] = sheet.crop(width*7, height*6, width, height);
		
		playerAttRight = new BufferedImage[4];
		playerAttRight[3] = sheet.crop(width*4, height*7, width, height);
		playerAttRight[2] = sheet.crop(width*5, height*7, width, height);
		playerAttRight[1] = sheet.crop(width*6, height*7, width, height);
		playerAttRight[0] = sheet.crop(width*7, height*7, width, height);
		//-------------------------------------------------------------
		enemyDown = new BufferedImage[2];
		enemyDown[0] = sheet.crop(width*4, height*2, width, height);
		enemyDown[1] = sheet.crop(width*5, height*2, width, height);
		
		enemyUp = new BufferedImage[2];
		enemyUp[0] = sheet.crop(width*4, height*3, width, height);
		enemyUp[1] = sheet.crop(width*5, height*3, width, height);
		
		enemyLeft = new BufferedImage[4];
		enemyLeft[0] = sheet.crop(width*4, height*4, width, height);
		enemyLeft[1] = sheet.crop(width*5, height*4, width, height);
		enemyLeft[2] = sheet.crop(width*6, height*4, width, height);
		enemyLeft[3] = sheet.crop(width*7, height*4, width, height);
		
		enemyRight = new BufferedImage[4];
		enemyRight[0] = sheet.crop(width*4, height*5, width, height);
		enemyRight[1] = sheet.crop(width*5, height*5, width, height);
		enemyRight[2] = sheet.crop(width*6, height*5, width, height);
		enemyRight[3] = sheet.crop(width*7, height*5, width, height);
		
		enemyStill = new BufferedImage[2];
		enemyStill[0] = sheet.crop(width*3, height, width, height);
		enemyStill[1] = sheet.crop(width*4, height, width, height);
		//-------------------------------------------------------------
		startButton = new BufferedImage[3];
		startButton[0] = sheet.crop(0, height*6, width*2, height);
		startButton[1] = sheet.crop(0, height*7, width*2, height);
		startButton[2] = sheet.crop(width*2, height*7, width*2, height);
		//----------------------------------------------------------------
		grass = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width, 0, width, height);
		stone = sheet.crop(width  *2, 0, width, height);
		tree = sheet.crop(width*3, 0, width, height);
		player = sheet.crop(0, height, width, height);
		bgi = ImageLoader.loadImage("/textures/test.png");
		round = sheet.crop(width*4, 0, width, height);
	}
}
