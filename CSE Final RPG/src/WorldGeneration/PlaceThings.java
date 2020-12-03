package WorldGeneration;

import java.util.ArrayList;

public  class PlaceThings extends MapUtil{
	
	public static void treasureSpawns( ArrayList<ArrayList<Integer>> world){
	    //How hidden does a spot need to be for treasure?
	    //I find 5 or 6 is good. 6 for very rare treasure.
	    int treasureHiddenLimit = 5;
	    for (int x=0; x < GenerateMap.getWidth(); x++){
	        for (int y=0; y < GenerateMap.getHeight(); y++){
	            if(world.get(x).get(y)!=1){
	                int nbs = countAliveNeighbors(world, x, y);
	                if(nbs >= treasureHiddenLimit){
	                    placeTreasure(x, y);
	                }
	            }
	        }
	    }
	}
	
	public static void mobSpawns( ArrayList<ArrayList<Integer>> world){
	    //How hidden does a spot need to be for treasure?
	    //I find 5 or 6 is good. 6 for very rare treasure.
	    int treasureHiddenLimit = 5;
	    for (int x=0; x < GenerateMap.getWidth(); x++){
	        for (int y=0; y < GenerateMap.getHeight(); y++){
	            if(world.get(x).get(y)!=1){
	                int nbs = countAliveNeighbors(world, x, y);
	                if(nbs >= treasureHiddenLimit){
	                    placeMob(x, y);
	                }
	            }
	        }
	    }
	}
	
	public static void placeTreasure(int x, int y)
	{
		
	}
	
	public static void placeMob(int x, int y)
	{
		
	}
}