import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class game_div2_DA {
	private void work() {
		Scanner sc = new Scanner(System.in);
		int nc = sc.nextInt();
		int[] t = new int[6];
		Set<Integer> s = new HashSet<Integer>();
		assert nc > 0 && nc <= 100;
		while (nc-- > 0) {
			int n = sc.nextInt();
			assert n > 0 && n <= 1000;
			s.clear();
			for (int i = 0; i < 6; i++) {
				t[i] = sc.nextInt();
				assert t[i] >= 1 && t[i] <= 6;
				s.add(t[i]);
			}
			assert s.size() == 6;
			int sum = 0;
			int cur = 0;
			int m = 0;
			while (cur < n) {
				int next = cur + t[m % 6];
				if (next <= n) {
					cur = next;
					sum += cur;
				}
				m++;
			}
			System.out.println(sum);
		}
		sc.close();
	}

	public static void main(String[] args) {
		new game_div2_DA().work();
	}

}
