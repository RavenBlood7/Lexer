

public class Main
{
	public static void main(String[] args)
	{
		TokenList tl1= new TokenList();
		
		tl1.addToken("variable", "hello1");
		System.out.println("The list: \n" + tl1 + "\n");
		
		tl1.addToken("variable", "hello2");
		System.out.println("The list: \n" + tl1 + "\n");
		
		tl1.addToken("condition", "if");
		System.out.println("The list: \n" + tl1 + "\n");
		
		tl1.addToken("number", "12");
		System.out.println("The list: \n" + tl1 + "\n");
	}
}