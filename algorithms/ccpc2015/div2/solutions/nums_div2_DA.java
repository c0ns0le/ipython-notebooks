import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class nums_div2_DA {
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
		boolean[] m = new boolean[10010];
		int nc = sc.nextInt();
		assert nc > 0 && nc <= 100;
		while (nc-- > 0) {
			int n = sc.nextInt();
			assert n > 0 && n <= 300;
			solve(q, m, n);
		}
		sc.close();
	}

	private void solve(Queue<Node> q, boolean[] m, int n) {
		q.clear();
		Arrays.fill(m, false);

		q.add(new Node('1', 1 % n, null));
		m[1 % n] = true;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.m == 0) {
				print(node);
				System.out.println();
				break;
			}
			int mm = (node.m * 10) % n;
			if (!m[mm]) {
				m[mm] = true;
				q.add(new Node('0', mm, node));
			}
			mm = (mm + 1) % n;
			if (!m[mm]) {
				m[mm] = true;
				q.add(new Node('1', mm, node));
			}
		}
	}

	private void print(Node node) {
		if (node == null)
			return;
		print(node.prev);
		System.out.write(node.d);
	}

	public static void main(String[] args) {
		new nums_div2_DA().work();
	}

}
