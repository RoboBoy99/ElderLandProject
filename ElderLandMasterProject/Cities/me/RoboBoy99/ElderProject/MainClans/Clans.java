package me.RoboBoy99.ElderProject.MainClans;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Chunk;

public class Clans {
	
	UUID King;
	int Balance;
	boolean Conqured;
	double rent;
	Chunk chunk;
	Map<UUID, String> Role = new HashMap<>();
	
	public Clans(UUID King, int Balance, double rent, Chunk chunk) {
		this.King = King;
		this.Balance = Balance;
		this.rent = rent;
		this.chunk = chunk;
	}
	
	public UUID getKing() { return King; }
	
	public int getBalance() {return Balance; }	
	
	public Map<UUID, String> Role() {return Role; } 
	
	public double getRent() {return rent; }
	
	public Chunk getChunk() { return chunk; }
}
