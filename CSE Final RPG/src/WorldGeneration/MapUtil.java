package WorldGeneration;

import java.util.ArrayList;

public class MapUtil {
	  //Returns the number of cells in a ring around (x,y) that are alive.

	public static int countAliveNeighbors(ArrayList<ArrayList<Integer>> worldFile, int x, int y){
        int count = 0;
        for(int i=-1; i<2; i++){
            for(int j=-1; j<2; j++){
                int neighbour_x = x+i;
                int neighbour_y = y+j;
                //If we're looking at the middle point
                if(i == 0 && j == 0){
                    //Do nothing, we don't want to add ourselves in!
                }
                //In case the index we're looking at it off the edge of the map
                else if(neighbour_x < 0 || neighbour_y < 0 || neighbour_x >= worldFile.size() || neighbour_y >= worldFile.get(0).size()){
                    count = count + 1;
                }
                //Otherwise, a normal check of the neighbour
                else if(worldFile.get(neighbour_x).get(neighbour_y)==0){
                    count = count + 1;
                }
            }
        }
        return count;
    }
}