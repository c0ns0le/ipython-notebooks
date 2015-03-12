import java.util.Scanner;

public class dice_DA {

	class Die {
		int r, c, rem = 6;
		int[] cur, paint;

		Die() {
			cur = new int[6];
			paint = new int[6];
			cur[B] = 5;
			cur[U] = 0;
			cur[N] = 2;
			cur[S] = 3;
			cur[E] = 1;
			cur[W] = 4;
		}
	}

	private static final int B = 0;
	private static final int U = 1;
	private static final int N = 2;
	private static final int S = 3;
	private static final int E = 4;
	private static final int W = 5;

	int[][] moves = { { N, S, U, B, E, W }, { E, W, N, S, U, B },
			{ S, N, B, U, E, W }, { W, E, N, S, B, U } };

	private static final int[] DR = { 1, 0, -1, 0 };
	private static final int[] DC = { 0, 1, 0, -1 };
	private static final String DIRS = "NESW";

	private int n, grid[][];

	private boolean move(int dir, Die die) {
		die.r += DR[dir];
		die.c += DC[dir];
		if (die.r < 0 || die.r == n || die.c < 0 || die.c == n)
			return false;
		int[] next = new int[6];
		for (int i = 0; i < 6; i++) {
			next[i] = die.cur[moves[dir][i]];
		}
		if (grid[die.r][die.c] > 0) {
			if (die.paint[next[B]] > 0
					&& die.paint[next[B]] != grid[die.r][die.c]) {
				return false;
			}
			if (die.paint[next[B]] == 0) {
				die.paint[next[B]] = grid[die.r][die.c];
				die.rem--;
			}
		}
		die.cur = next;
		return true;
	}

	private void work() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		int p = sc.nextInt();
		grid = new int[n][n];
		while (m-- > 0) {
			int c = sc.nextInt() - 1;
			int r = sc.nextInt() - 1;
			grid[r][c] = sc.nextInt();
		}

		char[] path = sc.next().toCharArray();
		sc.close();

		Die die = new Die();
		boolean ok = true;
		for (int i = 0; i < p && ok && die.rem > 0; i++) {
			ok &= move(DIRS.indexOf(path[i]), die);
		}
		if (ok && die.rem == 0) {
			for (int i = 0; i < 6; i++) {
				if (i > 0)
					System.out.print(" ");
				System.out.print(die.paint[i]);
			}
			System.out.println();
		} else {
			System.out.println("0 0 0 0 0 0");
		}
	}

	public static void main(String[] args) {
		new dice_DA().work();
	}

}
