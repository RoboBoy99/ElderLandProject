package me.RoboBoy99.ElderProject.Mobs;

import org.bukkit.entity.Entity;

public class Mobs {

	Entity Mob;
	
	int level;
	
	int maxHealth;
	
	int minHealth;
	
	int damage;
	
	public Mobs(Entity Mob, int level, int maxHealth, int minHealth, int damage) {
		
		this.Mob = Mob;
		this.level = level;
		this.maxHealth = maxHealth;
		this.minHealth = minHealth;
		this.damage = damage;
	}
	
	public Entity getMob() { return Mob; }
	
	public int getLevel() { return level; }
	
	public int getmaxHealth() { return maxHealth; }
	
	public int getminHealth() { return minHealth; }
	
	public int getDamage() { return damage; }
	
}
