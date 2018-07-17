
public class test 
{
	
	public static void main(String[] args) 
	{
		new Thread(() -> {
			variables.addElements();
		}).start();
		/*
		new Thread(() -> {
			logic.inputAxiomsFromTextFile("src/axioms");
			logic.beginLoop();
		}).start(); */
		
		formula f = conjugationRule.conjugation(new formula("(∀a1(a1∈a2↔a1∈a3)→a2=a3)"), new formula("(∃a1∀a2(∀a3(a3∈a2→a3∈a4)→a2∈a1))"));
		System.out.println(conjugationERuleA.conjugationEA(f).getStringfromFormula());
		
	}
	
}
