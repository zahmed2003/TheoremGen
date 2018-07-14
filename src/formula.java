
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class formula 
{
PrimeNumberGenerator png = new PrimeNumberGenerator();
static PrimeNumberGenerator png2 = new PrimeNumberGenerator();
String f;
ArrayList<Integer> set;
ArrayList<HashMap<ArrayList<formula>, inferenceRule>> derivation;

public formula(String f)
{
	this.f = f;
}
	
	/** Returns the set of exponents for the encoding process */
public ArrayList<Integer> encode()
{
	char[] input = f.toCharArray();
	int[] output = new int[f.codePointCount(0, f.length())];
	int[] primes = png.primeGenerator(100 + f.length());
	
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
			int c = input[i];
			
			if(Character.isLowerCase(input[i]))
			{	
				for(int j = 0; j < input.length; j++) {if(input[j] == c) 
				{
					output[j] = primes[loc + 2];
					}
				}
				loc++;
			}
			
			else if(Character.isUpperCase(input[i]))
			{	
				for(int k = 0; k < input.length; k++) {if(input[k] == c) 
				{
					output[k] = primes[loc + 2] + 1;
					
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
	
	return set;
}

	/** transforms an ArrayList to a String Object which can then be used as a formula*/
public static String arrayToString(ArrayList<Integer> x)
{
	int[] input = new int[x.size()];
	char[] output = new char[x.size()];
	String o = "";
	
	int[] primes1 = png2.primeGenerator(100 + x.size());
	ArrayList<Integer> primes = new ArrayList<Integer>();;
	
	for(int n = 0; n < primes1.length; n++)
	{
		primes.add(primes1[n]);
	}
	
	for(int i = 0; i < x.size(); i++)
	{
		input[i] = x.get(i);
	}
	
	variables v = new variables();
	ArrayList<Character> upper = new ArrayList<Character>();
	ArrayList<Character> lower = new ArrayList<Character>();
	
	for(int k = 0; k < v.lowerCase.length; k++) {lower.add(v.lowerCase[k]);}
	for(int l = 0; l < v.UpperCase.length; l++) {upper.add(v.UpperCase[l]);}
	
	
	for(int j = 0; j < input.length; j++)
	{
		if (input[j] == 1) 	{output[j] = '=';} 
		else if (input[j] == 2) {output[j] = '→';} 
		else if (input[j] == 3) {output[j] = '(';} 
		else if (input[j] == 4) {output[j] = ')';} 
		else if (input[j] == 5) {output[j] = '¬';} 
		else if (input[j] == 6) {output[j] = '∀';} 
		else if (input[j] == 7) {output[j] = '∃';} 
		else if (input[j] == 8) {output[j] = '∧';} 
		else if (input[j] == 9) {output[j] = '∨';} 
		else if (input[j] == 10) {output[j] = '↔';} 
		else if (input[j] == 11) {output[j] = '∈';} 
		else if (input[j] == 12) {output[j] = '⊥';}
		else
		{
		int p = input[j];
		if(primes.contains(p))
			{
			for(int m = 0; m < input.length; m++)
			{
				if(input[m] == p)
				{
					output[m] = lower.get(0);
				}
			}
			lower.remove(0);
			}
		else
		{
			for(int n = 0; n < input.length; n++)
			{
				if(input[n] == p)
				{
					output[n] = lower.get(0);
				}
			}
			lower.remove(0);
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
			subFormula.add(set.get(i));
		}
		return subFormula;
	}
	
	/** gets the number of "(" characters within the given index */
	public int getNumOuterParen(int beginIndex, int endIndex)
	{
		int num = 0;
		for(int i = beginIndex; i < endIndex; i++)
		{
			if(set.get(i) == 3) {num +=1;}
		}
		return num;
	}
	
	/** gets the number of ")" characters within the given index */
	public int getNumInnerParen(int beginIndex, int endIndex)
	{
		int num2 = 0;
		for(int i = beginIndex; i < endIndex; i++)
		{
			if(set.get(i) == 4) {num2 +=1;}
		}
		return num2;
	}
	
	/** adds derivation steps */
	public void addDerivation(HashMap<ArrayList<formula>, inferenceRule> step)
	{
		derivation.add(step);
	}
	
	/** gets derivation of this formula */
	public ArrayList<HashMap<ArrayList<formula>, inferenceRule>> getDerivation()
	{
		return derivation;
	}
}
