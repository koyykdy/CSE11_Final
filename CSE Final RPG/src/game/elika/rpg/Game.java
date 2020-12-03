/**
 * 
 * The main game code is stored here.
 * Runnable is implemented so that ticks and render methods can be implemented while boolean running is true
 * the buffer strategy determines how many buffer windows the canvas is drawn on before being projected to
 * the user's screen (window)
 * in order to streamline the loading of sprites, a sprite sheet system with a crop method is used
 * to reduce load by not having to import singular pictures of sprites at every rendering
 * the game constructor is used to read in the title, width, and height from the launcher.
 * it then passes these parameters in to the display class in the init method, and globalized states
 * are used to implement screen phase transitons between menu, options, settings, and the main game itself.
 *
 */

package game.elika.rpg;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.elika.rpg.display.Display;
import game.elika.rpg.gfx.Assets;
import game.elika.rpg.gfx.GameCamera;
import game.elika.rpg.input.KeyManager;
import game.elika.rpg.input.MouseManager;
import game.elika.rpg.states.GameState;
import game.elika.rpg.states.MenuState;
//import game.elika.rpg.states.MenuState;
//import game.elika.rpg.states.SettingState;
import game.elika.rpg.states.State;

public class Game implements Runnable {
	private Display display;
	public String title;
	private int width, height;
	private boolean running = false;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	//states
	public State gameState;
	public State menuState;
	//private State settingState;
	//input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	//camera
	private GameCamera gameCamera;
	//handler
	private Handler handler;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager); // done in canvas to make it work when the program is focused on canvas instead of jframe
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		handler = new Handler(this);
		gameCamera = new GameCamera(handler,0, 0);
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		//menuState = new MenuState(handler);
		//settingState = new SettingState(handler);
		State.setState(menuState);
	}
	// the tick method only runs when the state isn't null, i.e. there is a state being projected on screen
	private void tick() {
		keyManager.tick();
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3); // sets three buffer states
			return;
		}
		g = bs.getDrawGraphics();
		//clear the screen
		g.clearRect(0, 0, width, height);
		//begin drawing to the screen
		if(State.getState() != null) { // same as tick, only runs when state != null
			State.getState().render(g);
		}
		//end drawing process
		bs.show();
		g.dispose();
	}
	
	public void run() {
		init();
		// this section of the code makes sure that every computer runs the game at 60fps instead of 
		// the program's execution speed being determined by the computer's processing power
		int fps = 60;
		double timePerTick = 1000000000 / fps; //nanosecond divided by fps, max time allowed to run tick/render methods
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			timer += now - lastTime;
			lastTime = now;
			// if the time elapsed since the last rendering has exceeded the delta value for achieving 60 fps
			// then the tick and render methods are called as soon as the system is able.
			// the tick counter is incremented and the delta value is reset.
			if(delta>=1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000) {
				System.out.println("Frames per second: "+ ticks);
				ticks = 0;
				timer = 0;
			}
			// this outputs to the console the ticks (number of game loop executions) per second.
		}
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager; // other classes can access keymanager
	}
	
	public MouseManager getMouseManager() {
		return mouseManager; //other classes can access mousemanager
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	// synchronized is used here to separate the game threading from general java processes.
	public synchronized void start() {
		if (running)
			return; // if the game is already running and for some reason the start method is called
					// the if conditional here prevents an erroneous re-initialization of the game.
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running)
			return; // same as with the start method, this prevents erroneous stopping of the game.
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
