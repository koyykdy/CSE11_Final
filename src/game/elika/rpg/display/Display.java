/**
 * This class draws the display window and initializes the window's properties
 * using JFrame. 
 * it also imports the Canvas and puts in a getter method for other classes to
 * utilize the canvas within the game window.
 */
package game.elika.rpg.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private JFrame frame; // creates JFrame object
	private Canvas canvas; // creates a Canvas object
	private String title; // stores the title in a string
	private int width, height; // stores the width and height
	public Display(String title, int width, int height) {
		// brings in the title, width, and height and passes them to the createDisplay method
		this.title = title;
		this.width = width;
		this.height = height;
		createDisplay();
	}
	private void createDisplay() {
		// takes in the stored parameters from the constructor and makes a window
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		// creates a canvas space that spans the same dimensions as the window
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		//  adds the canvas to the frame
		frame.add(canvas);
		frame.pack();
	}
	public Canvas getCanvas() {
		// allows canvas to be accessed by other classes (a getter method)
		return canvas;
	}
}
