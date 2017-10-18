import java.io.IOException;

import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFParseException;

public class Main {
	
	public static void main(String [] args){
		
		Graph graph = new Graph();
		RawParser rawParser = new RawParser(graph);
		try {
			rawParser.parse("University0_0.owl");
		} catch (RDFParseException | RDFHandlerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
