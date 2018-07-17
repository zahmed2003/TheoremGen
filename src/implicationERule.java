
public class implicationERule extends inferenceRule
{
	//incomplete
	public static formula modusPonens(formula f, formula g)
	{
		//check if f is in form g -> s
		if(f.toString().contains(g.toString() + "→"))
		{
			
		}
		
		//check if g is in form f -> s
		else if(g.toString().contains(f.toString() + "→"))
		{
			
		}
		
		return null;
	}
}
