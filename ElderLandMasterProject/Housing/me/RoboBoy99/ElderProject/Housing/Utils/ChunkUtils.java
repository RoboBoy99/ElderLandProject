package me.RoboBoy99.ElderProject.Housing.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Chunk;
import org.bukkit.Location;

public class ChunkUtils {
	 
	 public static List<Location> getChunkCorners(Chunk chunk, int x,int z) {
	        //int x = chunk.getX() << 4;
	       // int z = chunk.getZ() << 4;

	        Location loc1 = new Location(chunk.getWorld(), x, chunk.getWorld().getHighestBlockAt(x, z).getY(), z);
	        Location loc2 = new Location(chunk.getWorld(), x + z, chunk.getWorld().getHighestBlockAt(x + z, z + x).getY(), z + x);
	        Location loc3 = new Location(chunk.getWorld(), x + z, chunk.getWorld().getHighestBlockAt(x + z, z).getY(), z);
	        Location loc4 = new Location(chunk.getWorld(), x, chunk.getWorld().getHighestBlockAt(x, z + x).getY(), z + x);

	        List<Location> corners = new ArrayList<>();

	        corners.add(loc1);
	        corners.add(loc2);
	        corners.add(loc3);
	        corners.add(loc4);
	        return corners;
	    }

	    public static int getExactCoordinate(int coordinate) {
	        return coordinate << 4;
	    }
}
