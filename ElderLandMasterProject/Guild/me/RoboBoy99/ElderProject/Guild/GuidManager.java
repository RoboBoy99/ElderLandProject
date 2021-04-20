package me.RoboBoy99.ElderProject.Guild;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GuidManager {

	UUID Leader;
	Map<UUID, String> Members = new HashMap<>();
	
	int Kills;
	int d;
	
	boolean Confirmation;
	boolean open;
	
	public GuidManager() {
		
	}
}
