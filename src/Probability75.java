

public class Probability75 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<4;i++) {
			System.out.println(rand75());
		}

	}

	private static int rand75() {
		// TODO Auto-generated method stub
		int a = rand50();
		a= a<< 1;
		
		a = a ^ rand50();
		
		return (a>0)?1:0;
		
	}

	private static int rand50() {
		// TODO Auto-generated method stub
		return (int)(10 *Math.random()) & 1;
	}

}
