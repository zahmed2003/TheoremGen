
import java.util.ArrayList;
import java.util.Random;

public class conjugationERuleA extends inferenceRule
{
	
	public static formula conjugationEA(formula f)
	{
			for(int i = 0; i < f.encode().size(); i++)
			{
				if(f.encode().get(i).equals(Integer.valueOf(8)))
				{
					
					if((f.getNumOuterParen(1, i) == f.getNumInnerParen(1, i)) && (f.getNumOuterParen(i + 1, f.encode().size()) == f.getNumInnerParen(i + 1, f.encode().size() - 1)))
					{
						ArrayList<Integer> s2 = f.getSubFormula(0, i);
						s2.add(4);

						
						
						formula A = new formula(formula.arrayToString(s2));
						
						ArrayList<String> x = new ArrayList<String>();
						x.add(f.getStringfromFormula());
						
						A.addDerivation(x, new conjugationERuleA());
						
						return A;
					}
				}
			}
			
		return null;
	}
}
