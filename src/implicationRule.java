import java.util.ArrayList;

public class implicationRule extends inferenceRule
{

	public static formula isImplied(formula f, formula g)
	{
		if(formula.isDerived(g, f))
		{
			formula wff = new formula("(" + f.getStringfromFormula() + "→" + g.getStringfromFormula() + ")");
			
			ArrayList<String> x = new ArrayList<String>();
			x.add(f.getStringfromFormula());
			x.add(g.getStringfromFormula());
			
			wff.addDerivation(x, new implicationRule());
			
			return wff;
		}
		
		else if(formula.isDerived(f, g))
		{
			formula wff = new formula("(" + g.getStringfromFormula() + "→" + f.getStringfromFormula() + ")");
			
			ArrayList<String> x = new ArrayList<String>();
			x.add(g.getStringfromFormula());
			x.add(f.getStringfromFormula());
			
			wff.addDerivation(x, new implicationRule());
			
			return wff;
		}
		
		return null;
	}
	
}
