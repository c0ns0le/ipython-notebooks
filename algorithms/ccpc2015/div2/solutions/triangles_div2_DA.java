import java.util.Scanner;

public class triangles_div2_DA {

	private void work() {
		Scanner sc = new Scanner(System.in);
		int nc = sc.nextInt();
		assert nc > 0 && nc <= 100;
		while (nc-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			assert b > 0 && a >= b && a <= 1000;
			int x = a / b;
			System.out.println(x * x);
		}
		sc.close();
	}

	public static void main(String[] args) {
		new triangles_div2_DA().work();
	}

}
