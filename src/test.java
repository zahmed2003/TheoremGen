
public class test 
{
	public static void main(String[] args) {
		formula fo = new formula("(∀z(z∈x↔z∈y)→x=y)");
		formula fo2 = new formula("(∀w∃y∀z(∀yA→z=y)→∃y∀z(z∈y↔∃w(w∈x∧∀yA)))");
		
		System.out.println(fo.getDerivation());
		
		formula c = conjugationRule.conjugation(fo, fo2);
		
		System.out.println(c.getStringfromFormula());
		
		
		System.out.println(c.getDerivation());
		
		formulaList.addToFormulas(fo);
		formulaList.addToFormulas(fo2);
		formulaList.addToFormulas(c);
		
		System.out.println(formulaList.formulas);
		
	}
}
