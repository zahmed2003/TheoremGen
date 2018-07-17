import java.util.ArrayList;

public class conjugationERuleB extends inferenceRule
{

	public static formula conjugationEB(formula f)
	{
			for(int i = 0; i < f.encode().size(); i++)
			{
				if(f.encode().get(i).equals(Integer.valueOf(8)))
				{
					
					if((f.getNumOuterParen(1, i) == f.getNumInnerParen(1, i)) && (f.getNumOuterParen(i + 1, f.encode().size()) == f.getNumInnerParen(i + 1, f.encode().size() - 1)))
					{
						ArrayList<Integer> s2 = f.getSubFormula(i + 1, f.encode().size());
						s2.add(0, 3);
						
						
						formula B = new formula(formula.arrayToString(s2));
						
						ArrayList<String> x = new ArrayList<String>();
						x.add(f.getStringfromFormula());
						
						B.addDerivation(x, new conjugationERuleA());
						
						return B;
					}
				}
			}
		return null;
	}
}
