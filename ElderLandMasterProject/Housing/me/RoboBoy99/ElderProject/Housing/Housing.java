package me.RoboBoy99.ElderProject.Housing;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Chunk;
import org.bukkit.Location;

public class Housing {

	UUID Owner;
	Chunk chunk;
	List<UUID> Members = new ArrayList<>();
	Location housePoint;
	Boolean Open;
	Double amount;
	String desc;
	
	public Housing(UUID owner, List<UUID> Members,Location housePoint, Boolean Open, Double Amount, Chunk chunk, String desc) {
		this.Owner = owner;
		this.Members = Members;
		this.housePoint = housePoint;
		this.Open = Open;
		this.amount = Amount;
		this.chunk = chunk;
		this.desc = desc;
	}
	
	public UUID getOwner() { return Owner; }
	
	public List<UUID> getMembers() { return Members; }
	
	public Location gethousePoint() { return housePoint; }
	
	public Boolean getOpen() { return Open; }
	
	public Double getAmount() { return amount; }
	
	public Chunk getChunk() { return chunk; }
	
	public String getDesc() { return desc; }
}
