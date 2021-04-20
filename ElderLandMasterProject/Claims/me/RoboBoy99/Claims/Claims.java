package me.RoboBoy99.Claims;

import java.util.List;
import java.util.UUID;

import org.bukkit.Chunk;

public class Claims {

	UUID owner;
	List<UUID> members;
	String Type;
	Chunk chunk;
	int z;
	int x;

	public Claims(UUID owner, List<UUID> Members, int z, int x, String type) {
		this.owner = owner;
		this.members = Members;
		this.z = z;
		this.x = x;
		this.Type = type;
	}
	
	public UUID getOwner() { return owner; }
	
	public List<UUID> getMembers() { return members; }
	
	public Chunk getChunk() { return chunk; }
	
	public String getType() { return Type; }
	
	public int getX() { return x; }
	
	public int getZ() { return z; }
	
}
