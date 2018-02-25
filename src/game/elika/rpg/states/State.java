/**
 * This section outlines the abstract class state which is implemented in generalized game states
 * such as the menu screen or the game process itself.
 * every single state which outputs to the game window contains tick and render methods.
 * there is also a getter method to see which state the game is currently in.
 * this state class differs from the general java State
 */

package game.elika.rpg.states;

import java.awt.Graphics;

public abstract class State {
	public abstract void tick();
	public abstract void render(Graphics g);
	private static State currentState = null;
	public static void setState(State state) {
		currentState = state;
	}
	public static State getState() {
		return currentState;
	}
}
