import java.util.ArrayList;

public class variables 
{
	static int counter = 1;
//static String[] lowerCase = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'w', 'x', 'y', 'z'};
//static String[] UpperCase = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'W', 'X', 'Y', 'Z'};

	static ArrayList<String> lowerCase = new ArrayList<String>();
	static ArrayList<String> UpperCase = new ArrayList<String>();

	
	public static void addElements()
	{
		while(true)
		{
			lowerCase.add("a" + counter);
			UpperCase.add("A" + counter);
			counter++;
		}
	}
}