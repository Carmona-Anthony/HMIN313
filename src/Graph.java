import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.openrdf.model.Statement;

public class Graph {
	
	HashMap<String, Integer> values;
	HashMap<Integer,String> ids;
	int compteur;
	
	HashMap<Integer,Node> nodes;
	HashMap<Integer,Edge> edges;
	
	
	Graph(){
		values = new HashMap<>();
		ids = new HashMap<>();
		nodes = new HashMap<>();
		edges = new HashMap<>();
		compteur = 0;
	}
	
	void handleStatement(Statement statement){
		
		String subject = statement.getSubject().toString();
		String predicate = statement.getPredicate().toString();
		String object = statement.getObject().toString();
		
		Node nSubject;
		Edge ePredicate;
		Node nObject;
		
		if(!values.containsKey(subject)){
			values.put(subject, compteur);
			ids.put(compteur, subject);
			
			subject = new Node(compteur);
			nodes.put(compteur,subject);
			compteur++;
			
		}else {
			nSubject = nodes.get(values.get(subject));
		}
		
		if(!values.containsKey(object)){
			values.put(object, compteur);
			ids.put(compteur, object);
			
			Node node = new Node(compteur);
			nodes.put(compteur,node);
			compteur++;
			
		}else nObject = nodes.get(values.get(object));
		
		if(!values.containsKey(predicate)){
			values.put(predicate, compteur);
			ids.put(compteur, predicate);
			
			Edge edge = new Edge(compteur);
			edges.put(compteur,edge);
			compteur++;
			
		}else ePredicate = edges.get(values.get(subject));
		
		
	}
	
	/*ArrayList<Node> backtrackV2SAMERE(int objet, int predicat, ArrayList<Node> nodes){
		
		Node node = nodes.get(objet);
		
		
		for(Node node : nodes){
			node.getNeighbors()
		}
		
	}
	
		ArrayList<Node> backtrackV3SAMERE(Stack<Integer> objets, Stack<Integer> predicats, ArrayList<Integer> nodes){
		if (objets.isEmpty()){
			return nodes;
		}else{
			int obectActual = objets.pop();
			int predicatActual = predicats.pop();
			
			for (int subject : nodes){
				
			}
		}
	
	}
	
	ArrayList<Integer> backtrack(int objet, int predicat){
		ArrayList<Integer> subjects = new ArrayList<>();
		for (Edge edge : nodes.get(objet).getNeighbors()){
			if (edge.getId() == predicat){
				subjects.add(edge.getNode().getId());
			}
		}
		return subjects;		
	}
	*/
	public int getId(String value){
		return values.get(value);
	}
	
	public String getValue(int id){
		return ids.get(id);
	}
}
