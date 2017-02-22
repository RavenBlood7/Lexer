public class Lexer
{
	private Context context;
	
	/*	note: states are represented as integers
	
		context has the following functions:
		
		public int getNextState(int state, char x)
		//based on a current state and an input character, 
			this function returns the next state
				
		public String getDescription(int state)
		//if the state is accepting, then it gives the name of the
			token class
		//it also gives the specific errors which could occur;
			errors are states 41 and up
			
		
		public boolean isAccepting(int state)
		//checks whether a state is accepting, so
			at the end of a word if it is accepting, then 
			it is a valid word in the regular expression
		
		public int isKeyword(String word)
		//checks whether an word is part of the
			keywords or special words that we have
	*/
	
}