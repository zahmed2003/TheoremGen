
public class runner 
{
	
	public static void main(String[] args) 
	{
		 new Thread(() -> {
			variables.addElements();
		}).start();
		
		/*  new Thread(() -> {
			logic.inputAxiomsFromTextFile("src/axioms");
			logic.beginLoop();
		}).start(); */
		
		formula f = new formula("(a1=a1)");
		formula g = new formula("((a1=a1)→(a1))");
		
		System.out.println(g.formulaContains(f));
		
}
}
