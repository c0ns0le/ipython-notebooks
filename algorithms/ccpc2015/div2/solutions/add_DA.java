import java.util.Scanner;

public class add_DA {
	private void work() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String s = sc.next();
			if ("0".equals(s))
				break;
			String[] spl = s.split("[+]");
			int n = spl.length;
			assert n > 0 && n < 1000;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(spl[i]);
				assert a[i] >= 0 && a[i] <= 100000;
			}
			int[] out = new int[n];
			int k = 0;
			boolean[] b = new boolean[n];
			for (int i = 0; i < n; i++) {
				if (!b[i]) {
					for (int j = i + 1; j < n; j++) {
						if (!b[j] && (a[i] + a[j]) % 10 == 0) {
							b[i] = true;
							b[j] = true;
							out[k++] = a[i];
							out[k++] = a[j];
							break;
						}
					}
				}
			}
			for (int i = 0; i < n; i++) {
				if (!b[i])
					out[k++] = a[i];
			}
			for (int i = 0; i < n; i++) {
				if (i > 0)
					System.out.print("+");
				System.out.print(out[i]);
			}
			System.out.println();
		}
		sc.close();
	}

	public static void main(String[] args) {
		new add_DA().work();
	}

}
