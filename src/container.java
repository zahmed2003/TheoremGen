import java.util.ArrayList;
import java.util.HashMap;

public class container 
{
//This class represents a data structure to store a single layer of derivations
	
ArrayList<String> formulae;
inferenceRule i;
/** adds an element to the container */

public container(ArrayList<String> formulae, inferenceRule i)
{
	this.formulae = formulae;
	this.i = i;
}


/** Gets the String at the specific index */
public String getString(int j)
{
	return formulae.get(j);
}

/** creates a HashMap of derivation (for readability) */
public HashMap<ArrayList<String>, inferenceRule> getReadable()
{
	HashMap<ArrayList<String>, inferenceRule> h = new HashMap<ArrayList<String>, inferenceRule>();
	h.put(formulae, i);
	return h;
}

/** checks if formulae list is empty */

public boolean isEmpty()
{
	if(formulae.size() == 0)
	{
		return true;
	}
	return false;
}

/** returns the number of elements in the formulas */
public int getNumFormulae()
{
	int total = 0;
	for(int j = 0; j < formulae.size(); j++)
	{
		total++;
	}
	return total;
}

/** checks if a specific String is located within the array */
public boolean checkStringIsInContainer(String s)
{
	for(int j = 0; j < formulae.size(); j++)
	{
		if(formulae.get(j).equals(s)) {return true;}
	}
	return false;
}

/**gets formulae */

public ArrayList<String> getFormulae()
{
	return formulae;
}

/**gets inference rules */

public inferenceRule getinferenceRule()
{
	return i;
}

}

