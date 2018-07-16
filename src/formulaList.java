import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class formulaList 
{

	static HashMap<formula, ArrayList<Integer>> formulas = new HashMap<formula, ArrayList<Integer>>();
	
	/** gets the key from an iteration value */
	 public static Object getKeyFromValue(Map hm, Object value) {
		    for (Object o : hm.keySet()) {
		      if (hm.get(o).equals(value)) {
		        return o;
		      }
		    }
		    return null;
		  }
	 
	 /** gets the longest formula of the list */
	 public static int getLargestFormulaLength()
	 {
		 int longest = 0;

		    for (formula key : formulas.keySet()) {
		      if(key.getStringfromFormula().length() > longest)
		      {
		      longest = key.getStringfromFormula().length();

		      }

		    }
		    
		    return longest;
		}
}
