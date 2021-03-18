package reach;

public class Branchdetails extends Javadetails {
	
	int a = 100;
	
	String s;
	
	public  void add() {
		int a = 10;
		System.out.println(a);
		System.out.println(b);
		System.out.println(s);
		System.out.println("Within class global : " + this.a);
		System.out.println("parent class global : " + super.a);
	}
	
	public static void main(String[] args) {
		Branchdetails b = new Branchdetails();
		b.add();
	}
}
