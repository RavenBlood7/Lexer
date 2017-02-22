public class Context
{
	private int[][] transitionTable;
	private boolean[] accepting;
	private String[] description;
	
	Context()
	{
		transitionTable = new int[85][59];
		stateTable = new boolean[85];
		description = new String[85];
	}
	
	public int getNextState(int state, char x)
	{
		return transitionTable[state][getCharIndex(x)];
	}
	
	public String getDescription(int state)
	{
		return description[state];
	}
	
	public boolean isAccepting(int state)
	{
		return accepting[state];
	}
	
	public int isKeyword(String word)
	{
		//returns -1 if it is not keword
		//else returns the state
	}
	
	//helper functions
	private int getCharIndex(char x)
	{
		
	}
}