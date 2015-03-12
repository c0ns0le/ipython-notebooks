import java.util.Scanner;

public class nums_div2_bf_DA {

	private void work() {
		Scanner sc = new Scanner(System.in);
		int nc = sc.nextInt();
		assert nc > 0 && nc <= 100;
		while (nc-- > 0) {
			int n = sc.nextInt();
			assert n > 0 && n <= 300;
			long res = Long.MAX_VALUE;
			for (int i = 1; i < 1 << 19; i++) {
				long x = 0;
				for (int j = 0; j < 19; j++) {
					x *= 10;
					x += ((i & (1 << j)) != 0) ? 1L : 0L;
				}
				if (x % n == 0 && x < res) {
					res = x;
				}
			}
			System.out.println(res);
		}
		sc.close();
	}

	public static void main(String[] args) {
		new nums_div2_bf_DA().work();
	}

}
