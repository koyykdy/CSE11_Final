package WorldGeneration;

import java.util.ArrayList;

public class MapSimulation extends MapUtil {

	static  int width = 200;
	static  int height = 180;
	
	
	
	 public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		MapSimulation.width = width;
	}

	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		MapSimulation.height = height;
	}

	
	
	
	
	
	
	static float chanceToStartAlive = 0.45f;
	 
	public static ArrayList<ArrayList<Integer>> initializeMap(){
		ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<height;i++)
		{
			map.add(new ArrayList<Integer>());
		}

	    for(int x=0; x<height; x++){
	        for(int y=0; y<width; y++){
	            if(Math.random() < chanceToStartAlive)
	              map.get(x).add( 1);
	            else
	              map.get(x).add(0);
	            
	        }
	    }
	    return map;
	}
	 
    public static ArrayList<ArrayList<Integer>> doSimulationStep(ArrayList<ArrayList<Integer>> worldFile){
    	int deathLimit = 4;
    	int birthLimit = 4;
        ArrayList<ArrayList<Integer>> newMap = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<height;i++)
		{
			newMap.add(new ArrayList<Integer>());
		}
        
        
        //Loop over each row and column of the map
        for(int x=0; x<worldFile.size(); x++){
            for(int y=0; y<worldFile.get(0).size(); y++){
                int nbs = countAliveNeighbors(worldFile, x, y);
                //The new value is based on our simulation rules
                //First, if a cell is alive but has too few neighbours, kill it.
                if(worldFile.get(x).get(y)==0){
                    if(nbs < deathLimit){
                        newMap.get(x).add(1);
                    }
                    else{
                        newMap.get(x).add(0);
                    }
                } //Otherwise, if the cell is dead now, check if it has the right number of neighbours to be 'born'
                else{
                    if(nbs > birthLimit){
                        newMap.get(x).add(0);
                    }
                    else{
                        newMap.get(x).add(1);
                    }
                }
            }
        }
        return newMap;
    }
    
    
    public static ArrayList<ArrayList<Integer>> generateMap(){
	    //Create a new map
		
	    ArrayList<ArrayList<Integer>> cellmap = MapSimulation.initializeMap();
	    //Set up the map with random values
	   // cellmap = initialiseMap(cellmap);
	    //And now run the simulation for a set number of steps
	    for(int i=0; i<2; i++){
	        cellmap = MapSimulation.doSimulationStep(cellmap);
	    }
	    
	    for(int i=0; i<width;i++)
	    {
	    		cellmap.get(0).set(i, 1);
	    		cellmap.get(height-1).set(i,1);
	    }
	    for(int j=0; j<height;j++)
	    {
	    		cellmap.get(j).set(0, 1);
	    		cellmap.get(j).set(width-1, 1);
	    }
	    
	    ArrayList<Integer> dimensions = new ArrayList<Integer>();
	    dimensions.add(width);
	    dimensions.add(height);
	    ArrayList<Integer> spawnLocation = new ArrayList<Integer>();
	    spawnLocation.add(100);
	    spawnLocation.add(100);
	    
	    cellmap.add(dimensions);
	    cellmap.add(spawnLocation);
	    
	    return cellmap;
	}
    
    

	}