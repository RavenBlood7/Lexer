import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lexer
{
	private Context context;
	private TokenList lst = new TokenList();
	//So this baby has to take in input
	public Lexer (String splFile) {
		context = new Context();
		
		File file = new File(splFile);

	    try {
	        Scanner sc = new Scanner(file);
	        sc.useDelimiter("");

	        int state = 0; 
	        String snippet = "";
	        boolean consume = true;
	        char c = '-';  

	        //this is for debugging purposes 
	        String numbas = "0 ";

			// TODO: something to do with isAccepting (even though the DFA gets to a done state?)

			//This loop goes through each character and adds tokens to the list or errors out 
	        while (sc.hasNext()) {
	        	//The variable consume is used to protect against multiple spaces and consuming more than you should
	        	//It kind of acts as a peek() method, but there is no peek() for Scanner objects. 
	        	if (consume) 
	            	 c = sc.next().charAt(0);
	            else 
	            	consume = true; 
	            
	            String type = context.getDescription(state);
	            state = context.getNextState(state, c);

	            if (state < 41) {
	            	snippet += c; 
	            } else {
	            	consume = false; 
	            }

	        	numbas += state + " ";

	        	if (state > 40) {
		            if (state == 41) {
		            	if (type.equals("space") || type.equals("newline")) {}
		            	else if (context.isKeyword(snippet) > 0 ) {
		            		type = "keyword";
		            		lst.addToken(type, snippet);
		            	} else {
		            		lst.addToken(type, snippet);
		            	}
		            	
		            } else if (state > 41) {
		            	System.out.println("Lexical Error: |" + snippet + "| = " + context.getDescription(state) + ". Scanning aborted.");
		            	System.exit(1);
		            	//System.out.println("ERROR " + context.getDescription(state) +  ": " + snippet);
		            	//TODO: error out and say why 
		            } 
	            
	            	snippet = "";
	            	state = 0; 
	            	numbas = state + " ";
	            }
	        }	

	        //This code is to handle when there is no space or linebreak (showing the end)
	         //This code is questionable to say the least. Although it solves the problem of no 
	        //spaces/linebreaks for some tokens, for others it doesn't work. 
	        
	        //There is still a problem with incomplete tokens  // problem if last token is symbol or an incomplete str
	        	//TODO: need a way to check if a token is done or not at the end of the file
	        // check if final state is nice

	        String type = context.getDescription(state);
	        state = context.getNextState(state, ' ');

	        if (state == 41) {
            	if (type.equals("space") || type.equals("newline")) {}
            	else if (context.isKeyword(snippet) > 0 ) 
            		type = "keyword";
            	lst.addToken(type, snippet);
            	
	        } else if (state > 41) {
	        	System.out.println("Lexical Error: |" + snippet + "| = " + context.getDescription(state) + ". Scanning aborted.");
		        System.exit(1);
	        }

	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	};

	public String toString() {
		return lst.toString();
	}
}