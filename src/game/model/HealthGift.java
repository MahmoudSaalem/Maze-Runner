package game.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.graphics.Animation;
import game.graphics.Assets;
import game.model.entity.creatures.Player;

public class HealthGift extends Gift {
	
	private Player player;
	private Animation animation;
	
	public HealthGift(BufferedImage texture, String name, int id) {
		super(texture, name, id);
		
		// Animations
		animation = new Animation(135, Assets.healthGift);
	}
	
	@Override
	public void tick() {
		animation.tick();
		player = handler.getWorld().getEntityManager().getPlayer();
		if(player.getCollisionBounds(0f, 0f).intersects(bounds) &&
				player.getHealth()<3){
			pickedUp = true;
			player.setHealth(player.getHealth()+1);
		}
	}	
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), null);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		return animation.getCurrentFrame();
	}
}