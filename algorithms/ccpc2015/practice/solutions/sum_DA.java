import java.util.Scanner;

public class sum_DA {
	private void work() {
		Scanner sc = new Scanner(System.in);
		int nc = sc.nextInt();
		while (nc-- > 0) {
			long n = sc.nextInt();
			long ans;
			if (n == 0) {
				ans = 1;
			} else if (n > 0) {
				if ((n & 1) == 0) {
					ans = (n / 2) * (n + 1);
				} else {
					ans = n * ((n + 1) / 2);
				}
			} else {
				n = -n;
				if ((n & 1) == 0) {
					ans = (n / 2) * (n + 1) - 1;
				} else {
					ans = n * ((n + 1) / 2) - 1;
				}
				ans = -ans;
			}
			System.out.println(ans);
		}
		sc.close();
	}

	public static void main(String[] args) {
		new sum_DA().work();
	}

}
