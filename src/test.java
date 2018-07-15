
public class test 
{
	public static void main(String[] args) {
		formula fo = new formula("(∀a(a∈b↔a∈c)→b=c)");
		
		formula fo2 = new axiom("(∀a∃b∀c(∀bA→c=b)→∃b∀c(c∈b↔∃a(a∈d∧∀bA)))");
		formula fo3 = new axiom("(∃a∀b(∀c(c ∈ b → c ∈ x) → b ∈ a))");
		
		
		
		formula c = conjugationRule.conjugation(fo, fo2);
		formula c2 = conjugationRule.conjugation(c, fo3);
		
		System.out.println(derivationList.formulas);
		
		System.out.println(c.getStringfromFormula());
		System.out.println(formula.isDerived(c2, fo));
		
		
	}
}
