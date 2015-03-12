import java.util.Arrays;
import java.util.Scanner;

public class threes_DA {

	private void work() {
		int MAX = 27; // log(10000)=13, range 0-11 (so 24) + 2 (1,2)
		// add 1 for good measure (should not do this!)
		int[] all = new int[MAX];
		all[0] = 1;
		all[1] = 2;
		all[2] = 3;
		for (int i = 3; i < MAX; i++) {
			all[i] = 2 * all[i - 1];
		}
		Scanner sc = new Scanner(System.in);
		int nc = sc.nextInt();
		while (nc-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int max = 0;
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				if (max < a[i])
					max = a[i];
			}
			int[][] b = new int[MAX][n];
			Arrays.fill(b[2], -1);
			for (int i = 0; i < n; i++) {
				switch (a[i]) {
				case 1:
					if (i < n - 1 && a[i + 1] == 2) {
						b[2][i] = i + 1;
						if (max < 3)
							max = 3;
					}
					break;
				case 2:
					if (i < n - 1 && a[i + 1] == 1) {
						b[2][i] = i + 1;
						if (max < 3)
							max = 3;
					}
					break;
				case 3:
					b[2][i] = i;
					break;
				}
			}

			for (int cur = 3; cur < MAX; cur++) {
				for (int i = 0; i < n; i++) {
					if (b[cur - 1][i] >= 0 && b[cur - 1][i] + 1 < n
							&& b[cur - 1][b[cur - 1][i] + 1] >= 0) {
						b[cur][i] = b[cur - 1][b[cur - 1][i] + 1];
						if (max < all[cur])
							max = all[cur];
					} else if (a[i] == all[cur]) {
						b[cur][i] = i;
					} else {
						b[cur][i] = -1;
					}
				}
			}
			System.out.println(max);
		}
		sc.close();
	}

	public static void main(String[] args) {
		new threes_DA().work();
	}

}
