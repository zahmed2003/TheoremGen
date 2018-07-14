import java.util.ArrayList;

public class test 
{
	public static void main(String[] args) {
		formula fo = new formula("(∀z(z∈x↔z∈y)→x=y)");
		System.out.println(fo.encode());
		ArrayList<Integer> n = new ArrayList<Integer>();
		n.add(3);
		n.add(6);
		n.add(13);
		n.add(3);
		n.add(13);
		n.add(11);
		n.add(19);
		n.add(10);
		n.add(13);
		n.add(11);
		n.add(23);
		n.add(4);
		n.add(2);
		n.add(19);
		n.add(1);
		n.add(23);
		n.add(4);
		System.out.println(formula.arrayToString(n));
		
	}
}
