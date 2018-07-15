import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class formulaList 
{

	static HashMap<formula, ArrayList<Integer>> formulas = new HashMap<formula, ArrayList<Integer>>();
	
	 public static Object getKeyFromValue(Map hm, Object value) {
		    for (Object o : hm.keySet()) {
		      if (hm.get(o).equals(value)) {
		        return o;
		      }
		    }
		    return null;
		  }
}
