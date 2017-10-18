import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.openrdf.model.Statement;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFParseException;
import org.openrdf.rio.Rio;
import org.openrdf.rio.helpers.RDFHandlerBase;

public class RawParser extends RDFHandlerBase {
	
	org.openrdf.rio.RDFParser rdfParser;
	Reader reader;
	Graph graph;
	
	RawParser(Graph graph){
		rdfParser = Rio.createParser(RDFFormat.RDFXML);
		rdfParser.setRDFHandler(new RDFListener());
		this.graph = graph;
	}
	
	public void parse(String fileName) throws RDFParseException, RDFHandlerException, IOException{
		reader = new FileReader(fileName);
		rdfParser.parse(reader, "");
		reader.close();
	}
	
	private class RDFListener extends RDFHandlerBase {
		
		@Override
		public void handleStatement(Statement st) {
			
			graph.handleStatement(st);
			
		}

		
	}

}
