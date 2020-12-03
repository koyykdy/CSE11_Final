/**
 * The launcher class exists solely to launch the game class
 */
package game.elika.rpg;

import game.elika.rpg.Game;

public class Launcher {
	public static void main(String[] args) {
		Game game = new Game("Test",800, 600); // initializes the window settings
		game.start(); // starts the game
	}
}
