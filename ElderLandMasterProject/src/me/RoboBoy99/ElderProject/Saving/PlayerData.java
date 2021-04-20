package me.RoboBoy99.ElderProject.Saving;

import java.io.File;


import me.RoboBoy99.ElderProject.ElderProject;

public class PlayerData {
	ElderProject plugin = ElderProject.getInstance();
	

	public void CreatingFile() {
	    if (!plugin.getDataFolder().exists()) {
	        plugin.getDataFolder().mkdir();
	    }
	    File ProfileFolder = new File(plugin.getDataFolder(), "Profiles");
	    if(!ProfileFolder.exists()) {
	    	ProfileFolder.mkdirs();
	 
	    }
	}
}
