package WorldGeneration;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GenerateMap   {
	//grass 0, rock 1, dirt 2
	/*
	 * OR
	 * 
	 * 1 non-walkable, 0 walkable::
	 */
	
	private final static int width = 200;
    private final static int height = 180;
    private static ArrayList<ArrayList<Integer>> map;
    
    public static ArrayList<ArrayList<Integer>> getMap()
    {
    	return map;
    }
    
    public static int getWidth()
    {
    	return width;
    }
    public static int getHeight()
    {
    	return height;
    }
   
    
    
    
    
        public static void writeMap() 
        {
            map = MapSimulation.generateMap();

       		 	String text = "";
       		 	
        	for(int i=0;i<height;i++)
        	{
        		for(int j=0;j<width;j++)
        		{
        			text+=map.get(i).get(j).toString()+" ";
        			if(j==width-1)
        			{
        				text+="\n";
        			}
        		}
        		
        		
        	}
        	text+=width+" ";
        	text+=height+" ";
        	text+=map.get(height+1).get(0)+" ";
        	text+=map.get(height+1).get(1)+" ";


        	try (PrintWriter out = new PrintWriter("resources/world/world1.txt")) {
        	    out.println(text);
        	} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
       
        
        
    }