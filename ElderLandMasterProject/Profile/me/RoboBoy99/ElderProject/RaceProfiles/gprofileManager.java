package me.RoboBoy99.ElderProject.RaceProfiles;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class gprofileManager {

	public Map<UUID,gprofile> Profile;
	
	public gprofileManager() {
		Profile = new HashMap<>();
	}	
	
	public void create(UUID pl, String r, String c) {
		if(Profile.containsKey(pl)) {
			return;
		} else {
			Profile.put(pl, new gprofile(r, c));		
		}
	}
}
