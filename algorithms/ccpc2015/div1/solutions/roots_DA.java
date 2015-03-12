import java.math.BigInteger;
import java.util.Scanner;

public class roots_DA {
	private BigInteger two = BigInteger.valueOf(2L);
	private BigInteger four = BigInteger.valueOf(4L);

	private void work() {
		Scanner sc = new Scanner(System.in);
		int nc = sc.nextInt();
		while (nc-- > 0) {
			BigInteger a = BigInteger.valueOf(sc.nextLong());
			BigInteger b = BigInteger.valueOf(sc.nextLong());
			BigInteger c = BigInteger.valueOf(sc.nextLong());
			BigInteger s = BigInteger.valueOf(sc.nextLong());
			BigInteger t = BigInteger.valueOf(sc.nextLong());
			int signS = eval(a, b, c, s);
			int signT = eval(a, b, c, t);
			String res = "No";
			if (signS == 0 || signT == 0 || signS != signT) {
				res = "Yes";
			} else {
				BigInteger B = b.negate();
				BigInteger A = a.multiply(two);
				if (A.signum() < 0) {
					B = B.negate();
					A = A.negate();
				}
				if (A.multiply(s).compareTo(B) <= 0
						&& B.compareTo(A.multiply(t)) <= 0) {
					int signM = four.multiply(a).multiply(c)
							.subtract(b.multiply(b)).signum();
					if (a.signum() < 0)
						signM = -signM;
					if (signM != signS) {
						res = "Yes";
					}
				}
			}
			System.out.println(res);
		}
		sc.close();
	}

	private int eval(BigInteger a, BigInteger b, BigInteger c, BigInteger x) {
		BigInteger res = a.multiply(x).multiply(x).add(b.multiply(x)).add(c);
		return res.signum();
	}

	public static void main(String[] args) {
		new roots_DA().work();
	}

}
