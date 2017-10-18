
public class Edge {
	
	public int id;
    public int nodeEnd;
    
    Edge(int id){
    	this.id = id;
    }
    
    int getId(){
    	return id;
    }
    
    int getNode(){
    	return nodeEnd;
    }
    
}