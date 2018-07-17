
import java.util.ArrayList;
import java.util.Arrays;

public class formula 
{
String f;
ArrayList<Integer> set;
ArrayList<Integer> primes;

container derivation;

public formula(String f)
{
	this.f = f;
	formulaList.formulas.put(this, encode());
	
}
	
	/** Returns the set of exponents for the encoding process */
public ArrayList<Integer> encode()
{
	char[] input = f.toCharArray();
	int[] output = new int[f.codePointCount(0, f.length())];
	if(f.length()*f.length() > formulaList.getLargestFormulaLength()) 
	{
	primes = PrimeNumberGenerator.primeGenerator(f.length()*f.length());
	}
	
	ArrayList<Integer> set = new ArrayList<Integer>();
	
	int loc = 0;
	
	for(int i = 0; i < f.codePointCount(0, f.length()); i++)
	{
		if (input[i] == '=') 	{output[i] = 1;} 
		else if (input[i] == '→') {output[i] = 2;} 
		else if (input[i] == '(') {output[i] = 3;} 
		else if (input[i] == ')') {output[i] = 4;} 
		else if (input[i] == '¬') {output[i] = 5;} 
		else if (input[i] == '∀') {output[i] = 6;} 
		else if (input[i] == '∃') {output[i] = 7;} 
		else if (input[i] == '∧') {output[i] = 8;} 
		else if (input[i] == '∨') {output[i] = 9;} 
		else if (input[i] == '↔') {output[i] = 10;} 
		else if (input[i] == '∈') {output[i] = 11;} 
		else if (input[i] == '⊥') {output[i] = 12;}
		else
		{
			
			if(Character.isLowerCase(input[i]) && Character.isDigit(input[i + 1]))
			{	
				char c = input[i];
				int n = 1;
				String s1 = "";
				
				while(Character.isDigit(input[i + n]))
				{
					s1 += input[i + n];
					n++;
					
				}
		
				for(int j = 0; j < input.length; j++) 
				{
					if(input[j] == c)
					{
						int n1 = 1;
						String s2 = "";
						while(Character.isDigit(input[j + n1]))
						{
							s2 += input[j + n1];
							n1++;
							
						}
						if(n == n1 && s1.equals(s2))
						{
							output[j] = primes.get(loc);
						}
					}
				{
					
				}
				}
				loc++;
			}
			
			else if(Character.isUpperCase(input[i]) && Character.isDigit(input[i + 1]))
			{	
				char c = input[i];
				int n = 1;
				String s1 = "";
				
				while(Character.isDigit(input[i + n]))
				{
					s1 += input[i + n];
					n++;
					
				}
		
				for(int j = 0; j < input.length; j++) 
				{
					if(input[j] == c)
					{
						int n1 = 1;
						String s2 = "";
						while(Character.isDigit(input[j + n1]))
						{
							s2 += input[j + n1];
							n1++;
							
						}
						if(n == n1 && s1.equals(s2))
						{
							output[j] = primes.get(loc) + 1;
						}
					}
				{
					
				}
				}
				loc++;
			}
		}
	}
	
	for(int l = 0; l < f.codePointCount(0, f.length()); l++)
	{
		set.add(output[l]);
	}
	
	set.removeAll(Arrays.asList(0));
	
	return set;
}

	/** transforms an ArrayList to a String Object which can then be used as a formula*/
public static String arrayToString(ArrayList<Integer> x)
{
	int[] input = new int[x.size()];
	String[] output = new String[x.size()];
	String o = "";
	
	for(int i = 0; i < x.size(); i++)
	{
		input[i] = x.get(i);
	}
	
	ArrayList<String> upper = variables.UpperCase;
	ArrayList<String> lower = variables.lowerCase;
	int c = 0;
	
	for(int j = 0; j < input.length; j++)
	{
		if(input[j] == 0) {}
		else if (input[j] == 1) 	{output[j] = "=";} 
		else if (input[j] == 2) {output[j] = "→";} 
		else if (input[j] == 3) {output[j] = "(";} 
		else if (input[j] == 4) {output[j] = ")";} 
		else if (input[j] == 5) {output[j] = "¬";} 
		else if (input[j] == 6) {output[j] = "∀";} 
		else if (input[j] == 7) {output[j] = "∃";} 
		else if (input[j] == 8) {output[j] = "∧";} 
		else if (input[j] == 9) {output[j] = "∨";} 
		else if (input[j] == 10) {output[j] = "↔";} 
		else if (input[j] == 11) {output[j] = "∈";} 
		else if (input[j] == 12) {output[j] = "⊥";}
		else
		{
		int p = input[j];
		if(PrimeNumberGenerator.primes.contains(p))
			{
			for(int m = 0; m < input.length; m++)
			{
				if(input[m] == p)
				{
					output[m] = lower.get(c);
					input[m] = 0;
				}
			}
			c++;
			}
		else
		{
			for(int n = 0; n < input.length; n++)
			{
				if(input[n] == p)
				{
					output[n] = upper.get(c);
					input[n] = 0;
				}
			}
			c++;
			}
		}
	}
	for(int q = 0; q < output.length; q++)
	{
		o += output[q];
	}
	
	return o;
}
	
	/** returns an array list of a specific number of elements contained within the encoded number*/
	public ArrayList<Integer> getSubFormula(int beginIndex, int endIndex)
	{
		ArrayList<Integer> subFormula = new ArrayList<Integer>();
		for(int i = beginIndex; i < endIndex; i++)
		{
			subFormula.add(encode().get(i));
		}
		return subFormula;
	}
	
	/** gets the number of "(" characters within the given index (where last is endIndex - 1) */
	public int getNumOuterParen(int beginIndex, int endIndex)
	{
		int num = 0;
		for(int i = beginIndex; i < endIndex; i++)
		{
			if(encode().get(i) == 3) {num +=1;}
		}
		return num;
	}
	
	/** gets the number of ")" characters within the given index (where last is endIndex - 1)*/
	public int getNumInnerParen(int beginIndex, int endIndex)
	{
		int num2 = 0;
		for(int i = beginIndex; i < endIndex; i++)
		{
			if(encode().get(i) == 4) {num2 +=1;}
		}
		return num2;
	}
	
	/** adds derivation step given string of the formula (done automatically by the inference rules)*/
	public void addDerivation(ArrayList<String> s, inferenceRule i)
	{
		derivation = new container(s, i);
		derivationList.formulas.put(this.getStringfromFormula(), derivation);
	}
	
	/** gets derivation of this formula */
	public container getDerivation()
	{
		return derivation;
	}
	
	/**gets the string */
	
	public String getStringfromFormula()
	{
		return f;
	}
	
	/** Returns true if the formula contained within derives this formula (incomplete)*/
	public static boolean isDerived(formula result, formula derive)
	{
		if(result.getDerivation() == null)
		{
			return false;
		}
		else if(result.getDerivation().checkStringIsInContainer(derive.getStringfromFormula()))
		{
			return true;
		}
		else
		{
				formula wff = new formula(result.getDerivation().getString(0));
				if(derivationList.formulas.keySet().contains(wff.getStringfromFormula()))
				{
				wff.addDerivation(derivationList.formulas.get(wff.getStringfromFormula()).getFormulae(), derivationList.formulas.get(wff.getStringfromFormula()).getinferenceRule());
				}
				return isDerived(wff, derive);
		}
		
	}
	
	
	
	/** adds the formula to the 2 databases */
	public void addToDatabases()
	{
		derivationList.formulas.put(this.getStringfromFormula(), getDerivation());
		formulaList.formulas.put(this, encode());
	}
}
