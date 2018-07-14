import java.util.ArrayList;
import java.util.HashMap;

public class formulaList 
{

	static HashMap<String, ArrayList<Integer>> formulas = new HashMap<String, ArrayList<Integer>>();
	
	public static void addToFormulas(formula f1)
	{
		formulas.put(f1.f, f1.encode());
	}
	
}
