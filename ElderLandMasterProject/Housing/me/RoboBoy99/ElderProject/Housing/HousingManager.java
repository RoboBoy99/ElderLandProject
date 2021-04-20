package me.RoboBoy99.ElderProject.Housing;

import java.util.ArrayList;
import java.util.List;


import me.RoboBoy99.Claims.ClaimsManager;
import me.RoboBoy99.ElderProject.ElderProject;


public class HousingManager {

	public List<Housing> Housing;
	ClaimsManager cm = ElderProject.getInstance().ClaimsMa;
	
	public HousingManager() {
	   Housing = new ArrayList<>();
	}
	
	
	public void CreateHouse(Housing house) {
		Housing.add(house);
		
		
	}
}
