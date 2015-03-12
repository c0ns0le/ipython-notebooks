import java.util.Scanner;

public class rps_da {

	private void work() {
		String rps = "RPS";
		int[][] score = new int[3][3];
		for (int i = 0; i < 3; i++) {
			score[i][(i + 1) % 3] = -1;
			score[(i + 1) % 3][i] = 1;
		}

		Scanner sc = new Scanner(System.in);
		char[] brett = sc.next().toCharArray();
		char[] sonny = sc.next().toCharArray();
		sc.close();

		int res = 0;
		for (int i = 0; i < 10; i++) {
			int b = rps.indexOf(brett[i]);
			int s = rps.indexOf(sonny[i]);
			res += score[b][s];
		}

		String ans;
		if (res > 0) {
			ans = "Brett";
		} else if (res < 0) {
			ans = "Sonny";
		} else {
			ans = "Draw";
		}

		System.out.println(ans);
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new rps_da().work();
		System.err.printf("running time: %.2f seconds\n",
				(System.currentTimeMillis() - start) / 1000.0);
	}

}
