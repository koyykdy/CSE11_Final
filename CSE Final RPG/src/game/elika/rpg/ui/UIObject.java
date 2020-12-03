package game.elika.rpg.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class UIObject {
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	protected boolean hovering = false;
	public UIObject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int)x, (int)y, width, height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void onClick();
	//helper methods
	public void onMouseMove(MouseEvent e) {
		if (bounds.contains(e.getX(), e.getY())) {
			hovering = true;
		}
		else {
			hovering = false;
		}
	}
	
	public void onMouseRelease(MouseEvent e) {
		if (hovering) {
			if (e.getButton() == MouseEvent.BUTTON1) { //checks for left click
				onClick();
			}
		}
	}
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isHovering() {
		return hovering;
	}
	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}
	//TEST AREA//
	protected volatile boolean mouseDown = false;

	public void mousePressed(MouseEvent e) {
	    if (e.getButton() == MouseEvent.BUTTON1) {
	        mouseDown = true;
	        initThread();
	    }
	}

	public void mouseReleased(MouseEvent e) {
	    if (e.getButton() == MouseEvent.BUTTON1) {
	        mouseDown = false;
	    }
	}

	volatile private boolean isRunning = false;
	private synchronized boolean checkAndMark() {
	    if (isRunning) return false;
	    isRunning = true;
	    return true;
	}
	private void initThread() {
	    if (checkAndMark()) {
	        new Thread() {
	            public void run() {
	                do {
	                    //do something
	                } while (mouseDown);
	                isRunning = false;
	            }
	        }.start();
	    }
	}
	//END TEST//
}
