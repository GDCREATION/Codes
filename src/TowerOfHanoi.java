import java.util.Scanner;

public class TowerOfHanoi {
	
	public static void main(String s[]) {
		Scanner sc = new Scanner(System.in);
		int nm = sc.nextInt();
		towerOfHonai(nm,"A","C","B");
		sc.close()
	}

	private static void towerOfHonai(int nm, String s1, String s2, String s3) {
		if(nm == 1) {
			System.out.println("Move disk 1 From "+s1+" to "+s2);
			return;
		}
		
		towerOfHonai(nm-1, s1, s3, s2);
		System.out.println("Move disk "+nm+" From "+s1+" to "+s2);
		towerOfHonai(nm-1, s3, s2, s1);
	}
}
