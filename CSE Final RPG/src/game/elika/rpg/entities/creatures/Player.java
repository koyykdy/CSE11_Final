package game.elika.rpg.entities.creatures;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.elika.rpg.Handler;
import game.elika.rpg.entities.Entity;
import game.elika.rpg.gfx.Animation;
import game.elika.rpg.gfx.Assets;

public class Player extends Creature {
	
	//animations
	private Animation animDown, animUp, animLeft, animRight, animStill;
	private Animation animAttDown, animAttUp, animAttLeft, animAttRight;
	
	//Attack Timer
	private long lastAttackTimer, attackCoolDown = 900, attackTimer = attackCoolDown;

	public static final float SPRINT_SPEED = 26.0f;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x = 25;
		bounds.y = 52;
		bounds.width = 13;
		bounds.height = 11;
		// the above creates the bounding box used for collision detection
		
		//animations below
		animDown = new Animation(100, Assets.playerDown);
		animUp = new Animation(100, Assets.playerUp);
		animLeft = new Animation(50, Assets.playerLeft);
		animRight = new Animation(50, Assets.playerRight);
		animStill = new Animation(900, Assets.playerStill);
		
		animAttDown = new Animation(100, Assets.playerAttDown);
		animAttUp = new Animation(100, Assets.playerAttUp);
		animAttLeft = new Animation(50, Assets.playerAttLeft);
		animAttRight = new Animation(50, Assets.playerAttRight);
	}

	@Override
	public void die() {
		System.out.println("you died");
	}
	
	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		animStill.tick();
		
		animAttDown.tick();
		animAttUp.tick();
		animAttLeft.tick();
		animAttRight.tick();
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		//attack
		checkAttacks();
	}

	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer; //time elapsed btwn 2 method calls
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCoolDown) {
			return;
		}
		if (attackTimer >= attackCoolDown) {
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().attack) {
			if(handler.getKeyManager().up ) {
				ar.x = cb.x + cb.width / 2 - arSize/2;
				ar.y = cb.y - arSize;
			}
			else if (handler.getKeyManager().down) {
				ar.x = cb.x + cb.width / 2 - arSize/2;
				ar.y = cb.y + cb.height;
			}
			else if (handler.getKeyManager().left) {
				ar.x = cb.x - arSize;
				ar.y = cb.y + cb.height / 2 - arSize/2;
			}
			else if (handler.getKeyManager().right) {
				ar.x = cb.x + cb.width;
				ar.y = cb.y + cb.height / 2 - arSize/2;
			}
			else {
				return;
			}
		}
		
		attackTimer = 0; //resets attack Timer
		
		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this)) {
				continue;
			}
			if (e.getCollisionBounds(0,0).intersects(ar)) {
				e.hurt(4); //damage
				return;
			}
		}
		}
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		if (handler.getKeyManager().shift) 
			speed = SPRINT_SPEED;
		if (!handler.getKeyManager().shift)
			speed = DEFAULT_SPEED;
		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down) 
			yMove = speed;
		if (handler.getKeyManager().left) 
			xMove = -speed;
		if (handler.getKeyManager().right) 
			xMove = speed;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int)(x-handler.getGameCamera().getxOffset()),
				(int)(y-handler.getGameCamera().getyOffset()),width, height, null);
		//g.drawImage(Assets.player, (int)(x-handler.getGameCamera().getxOffset()),
		//		(int)(y-handler.getGameCamera().getyOffset()),width, height, null);
		//casts float x and y from entity to int here
		
		//g.setColor(Color.RED);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
				//(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0) {
			if (handler.getKeyManager().attack) {
				return animAttLeft.getCurrentFrame();
			}
			return animLeft.getCurrentFrame();
		}
		else if (xMove > 0) {
			if (handler.getKeyManager().attack) {
				return animAttRight.getCurrentFrame();
			}
			return animRight.getCurrentFrame();
		}
		else if (yMove < 0) {
			if (handler.getKeyManager().attack) {
				return animAttUp.getCurrentFrame();
			}
			return animUp.getCurrentFrame();
		}
		else if (yMove > 0){
			if (handler.getKeyManager().attack) {
				return animAttDown.getCurrentFrame();
			}
			return animDown.getCurrentFrame();
		}
		else {
			return animStill.getCurrentFrame();
		}
	}

}
