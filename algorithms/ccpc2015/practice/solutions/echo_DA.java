import java.util.Scanner;

public class echo_DA {
	private void work() {
		Scanner sc = new Scanner(System.in);
		int nc = sc.nextInt();
		sc.nextLine();
		while (nc-- > 0) {
			System.out.println(sc.nextLine());
		}
		sc.close();
	}

	public static void main(String[] args) {
		new echo_DA().work();
	}

}
