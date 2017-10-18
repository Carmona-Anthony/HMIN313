import java.util.ArrayList;

public class Node {
	
	public int id;
    public ArrayList<Integer> neighbors;
    
    
    Node(int id){
    	this.id = id;
    	neighbors = new ArrayList<>();
    }
    
    public void addNeighbor(int edge){
    	neighbors.add(edge);
    }
    
    ArrayList<Integer> getNeighbors(){
    	return neighbors;
    }
    
    public int getId(){
    	return id;
    }
}