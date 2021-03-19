package reach;

public class Splitintvalue {

	public static void main(String[] args) {
		
		String s = "Showing 1 to 10 of 90 entries";
		
		String[] a = s.split(" ");
		int i = 0;
	//	System.out.println("length: " + a.length);
		for (String x : a) {
	//		System.out.println("index of " + i + " = " + x);
		//	i = i + 1;
			
		}
		
		System.out.println(a[(a.length-1) - 1]);
		
	}

}
