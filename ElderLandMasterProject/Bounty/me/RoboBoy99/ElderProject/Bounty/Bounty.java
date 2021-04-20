package me.RoboBoy99.ElderProject.Bounty;

import java.util.UUID;

public class Bounty {

	
	double BountyAmount;
	UUID Player;
	UUID Target;
	UUID Killer;
	
	public Bounty(double Cost, UUID Player, UUID Target) {
		this.BountyAmount = Cost;
		this.Player = Player;
		this.Target = Target;
	}
	
	public double getCostAmount() {
		return BountyAmount;
		
	}
	
	public UUID getBider() {
		return Player;
		
	}
	
	public UUID getTarget() {
		return Target;
		
	}
	
	public UUID getKiller() {
		return Killer;
		
	}

	
}
