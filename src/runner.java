import java.util.ArrayList;

public class runner 
{
	
	public static void main(String[] args) 
	{
		new Thread(() -> {
			variables.addElements();
		}).start();
		
		 new Thread(() -> {
			logic.inputAxiomsFromTextFile("src/axioms");
			logic.beginLoop();
		}).start(); 
		
}
}
