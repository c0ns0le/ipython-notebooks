import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class nums_div1_DA {

	class Node {
		char d;
		int m;
		Node prev;

		public Node(char d, int m, Node prev) {
			this.d = d;
			this.m = m;
			this.prev = prev;
		}
	}

	private void work() {
		Scanner sc = new Scanner(System.in);
		Queue<Node> q = new LinkedList<Node>();
		boolean[] m = new boolean[200020];
		int nc = sc.nextInt();
		assert nc > 0 && nc <= 100;
		while (nc-- > 0) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			assert n > 0 && n <= 200000 && d > 0 && d <= 16;
			char[] digits = new char[d];
			for (int i = 0; i < d; i++) {
				digits[i] = sc.next().charAt(0);
				assert digs.indexOf(digits[i]) >= 0;
			}
			Arrays.sort(digits); // just give them a sorted list?
			solve(q, m, n, digits);
		}
		sc.close();
	}

	private String digs = "0123456789abcdef";

	private void solve(Queue<Node> q, boolean[] m, int n, char[] digits) {

		int[] val = new int[digits.length];
		for (int i = 0; i < digits.length; i++) {
			val[i] = digs.indexOf(digits[i]);
		}

		q.clear();
		Arrays.fill(m, false);

		for (int i = 0; i < digits.length; i++) {
			if (val[i] > 0 && !m[val[i] % n]) {
				q.add(new Node(digits[i], val[i] % n, null));
				m[val[i] % n] = true;
			}
		}
		boolean found = false;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.m == 0) {
				count = 0;
				print(node);
				System.out.println();
				found = true;
				System.err.println("count = " + count);
				break;
			}
			for (int i = 0; i < digits.length; i++) {
				int mm = (node.m * 16 + val[i]) % n;
				if (!m[mm]) {
					m[mm] = true;
					q.add(new Node(digits[i], mm, node));
				}
			}
		}
		if (!found) {
			System.out.println("no solution");
		}
	}

	int count;

	private void print(Node node) {
		if (node == null)
			return;
		print(node.prev);
		System.out.write(node.d);
		count++;
	}

	public static void main(String[] args) {
		new nums_div1_DA().work();
	}

}
