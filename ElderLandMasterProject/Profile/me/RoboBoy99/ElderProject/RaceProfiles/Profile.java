package me.RoboBoy99.ElderProject.RaceProfiles;

import java.util.UUID;


public class Profile {

	UUID player;
	String Race;
	String Classs;
	//Date JoinDate;
	//Date LostSeenDate;
	
	boolean ShowLvl;
	boolean ShowClanInfo;
	boolean ShowGuildInfo;
	
	int CurrentLevel;
	int minLevel;	
	int MaxLevel;	
	
	
	int Kills;
	int SkillPoints;
	
	int Health;
	int Power;	
	double sprint;
	//int mining;

	//Skills
	
	//Stats
	
	
	
	//Class Add Soon!
	
	public Profile(UUID player, String Race, String Class, int Kills, int CurrentLevel, int minLevel, int maxLevel, int SkillPoints, int Health, int Power, double Sprint, boolean showlvl, boolean showClaninfo, boolean showGuildinfo) {
		this.player = player;
		this.Race = Race;
		this.Classs = Class;
		this.CurrentLevel = CurrentLevel;
		this.minLevel = minLevel;
		this.MaxLevel = maxLevel;
		this.SkillPoints = SkillPoints;
		this.Health = Health;
		this.Power = Power;
		this.sprint = Sprint;
		this.Kills = Kills;
		this.ShowLvl = showlvl;
		this.ShowClanInfo = showClaninfo;
		this.ShowGuildInfo = showGuildinfo;
	}
	
	public UUID getPlayer() {return player;}
	
	public String getRace() {return Race;}
	
	public void setRace(String race) {Race = race;}
	
	public String getPlayerClass() {return Classs;}
	
	public void setClass(String C) {C = Classs;}
	
	//public Date getJoinDate() {return JoinDate;}
	
//	public Date getLostSeenDate() {return LostSeenDate;} 
	
	public int getCurrentLevel() {return CurrentLevel;}
	
	public int getMinLevel() {return minLevel;}
	
	public int getMaxLevel() {return MaxLevel;}
	
	public int getSkillPoints() {return SkillPoints;}
	
	public int getHealth() { return Health; }
	
	public double getStamina() { return sprint; }
	
	public int getPower() { return Power; }
	
	public int getKills() {return  Kills; }
	
	public Boolean ShowLvl() { return ShowLvl; }
	
	public Boolean ShowClanInfo() { return ShowClanInfo; }
	
	public Boolean ShowGuildInfo() { return ShowGuildInfo; }
	
}
