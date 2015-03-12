import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class server_DA {
	private void work() {
		Scanner sc = new Scanner(System.in);
		int nc = sc.nextInt();
		while (nc-- > 0) {
			int n = sc.nextInt();
			int t = sc.nextInt();
			sc.nextLine();
			Map<String, Integer> current = new HashMap<String, Integer>();
			Set<String> remove = new HashSet<String>();
			Set<String> users = new HashSet<String>();
			int max = 0;
			while (n-- > 0) {
				String[] spl = sc.nextLine().trim().split("\\s+");
				int time = getTime(spl[0]);
				if ("USER".equals(spl[1])) {
					users.add(spl[2]);
					remove.clear();
					for (Map.Entry<String, Integer> e : current.entrySet()) {
						if (e.getValue() <= time) {
							remove.add(e.getKey());
						}
					}
					for (String r : remove) {
						current.remove(r);
					}
					if ("LOG_IN".equals(spl[3])) {
						current.put(spl[2], time + t);
					} else {
						current.remove(spl[2]);
					}
				} else {
					current.clear();
				}
				if (current.size() > max)
					max = current.size();
			}
			System.out.println(users.size() + " " + max);
		}
		sc.close();
	}

	private int getTime(String s) {
		String[] spl = s.split("[:]");
		return 60 * Integer.valueOf(spl[0]) + Integer.valueOf(spl[1]);
	}

	public static void main(String[] args) {
		new server_DA().work();
	}

}
