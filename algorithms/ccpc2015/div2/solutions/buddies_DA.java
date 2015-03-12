import java.util.Arrays;
import java.util.Scanner;

public class buddies_DA {
	private void work() {
		int[][] a = { { 1, 2 }, { -1, 1 }, { -2, -1 } };
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] names = new String[n];
		for (int i = 0; i < n; i++) {
			String fname = sc.next();
			String lname = sc.next();
			names[i] = lname + " " + fname;
		}
		Arrays.sort(names);
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			String fname = sc.next();
			String lname = sc.next();
			int k = bs(names, lname + " " + fname);
			int m = k % 3;
			System.out.println(convert(names[k + a[m][0]]));
			System.out.println(convert(names[k + a[m][1]]));
		}
		sc.close();
	}

	private String convert(String s) {
		String[] spl = s.split("\\s++");
		return spl[1] + " " + spl[0];
	}

	private int bs(String[] a, String x) {
		int lo = 0;
		int hi = a.length;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (a[mid].compareTo(x) < 0) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}

	public static void main(String[] args) {
		new buddies_DA().work();
	}

}
