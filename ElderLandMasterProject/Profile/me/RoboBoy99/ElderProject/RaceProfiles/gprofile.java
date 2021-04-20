package me.RoboBoy99.ElderProject.RaceProfiles;

public class gprofile {

	String race;
	String Class;
	
	public gprofile(String r, String c) {
		this.race = r;
		this.Class = c;
	}
	
	public String getRace() {
		return race;
		
	}
	
	public void setRace(String r) {
		race = r;
	}
	
	public String getPClass() {
		return Class;
	}
	
	public void setClass(String c) {
		Class = c;
	}
}
