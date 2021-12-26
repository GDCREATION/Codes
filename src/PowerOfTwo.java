import java.util.Scanner;

public class PowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n > 0 && (n&(n-1)) == 0) {
			System.out.println("Power oof two");
		}else
			System.out.println("Not a Power oof two");

            sc.close();
	}

}
