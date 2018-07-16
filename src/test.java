import java.util.ArrayList;

public class test 
{
	public static void main(String[] args) 
	{
		new Thread(() -> {variables.addElements();}).start();
		logic.inputAxiomsFromTextFile("src/axioms"); 
		
		
	}
	
}
