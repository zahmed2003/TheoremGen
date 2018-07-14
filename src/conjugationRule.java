import java.util.ArrayList;

public class conjugationRule extends inferenceRule
{
	public static formula conjugation(formula f, formula g)
	{
		ArrayList<Integer> c = new ArrayList<Integer>();
		
		for(int i = 0; i < f.encode().size(); i++)
		{
			c.add(f.encode().get(i));
		}
		
		c.add(8);
		
		for(int j = 0; j < g.encode().size(); j++)
		{
			c.add(g.encode().get(j));
		}
		
		formula cr = new formula(formula.arrayToString(c));
		
		return cr;
	}
}
