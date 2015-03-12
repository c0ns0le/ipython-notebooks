import java.util.Scanner;

public class count_DA {
	private void work() {
		String good = " ";
		for (int i = 0; i < 26; i++) {
			good += (char) (i + 'A');
			good += (char) (i + 'a');
		}
		Scanner sc = new Scanner(System.in);
		int nc = sc.nextInt();
		sc.nextLine();
		while (nc-- > 0) {
			char[] line = sc.nextLine().toCharArray();
			int c = 0;
			int v = 0;
			for (int i = 0; i < line.length; i++) {
				assert (good.indexOf(line[i]) >= 0) : line[i];
				if (line[i] <= ' ')
					continue;
				if ("AEIOUaeiou".indexOf(line[i]) >= 0)
					v++;
				else
					c++;
			}
			System.out.println(c + " " + v);
		}
		sc.close();
	}

	public static void main(String[] args) {
		new count_DA().work();
	}

}
