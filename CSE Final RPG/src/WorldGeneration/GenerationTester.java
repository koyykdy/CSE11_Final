package WorldGeneration;

import java.util.ArrayList;

public class GenerationTester {
	static ArrayList<ArrayList<Integer>> successMap = generateMap();

	public static void main(String[] args)
	{
		//tester
		
		
		for(int i=0;i<MapSimulation.getHeight();i++)
		{
			for(int j=0;j<MapSimulation.getWidth();j++) {
			System.out.print(successMap.get(i).get(j).toString()+" ");
		}
			System.out.print("\n");
		}
		
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
	    
	    for(int i=0; i<MapSimulation.getWidth();i++)
	    {
	    		cellmap.get(0).set(i, 1);
	    		cellmap.get(MapSimulation.getHeight()-1).set(i,1);
	    }
	    for(int j=0; j<MapSimulation.getHeight();j++)
	    {
	    		cellmap.get(j).set(0, 1);
	    		cellmap.get(j).set(MapSimulation.getWidth()-1, 1);
	    }
	    
	    ArrayList<Integer> dimensions = new ArrayList<Integer>();
	    dimensions.add(MapSimulation.getWidth());
	    dimensions.add(MapSimulation.getHeight());
	    ArrayList<Integer> spawnLocation = new ArrayList<Integer>();
	    spawnLocation.add(100);
	    spawnLocation.add(100);
	    
	    cellmap.add(dimensions);
	    cellmap.add(spawnLocation);
	    
	    return cellmap;
	}
}
