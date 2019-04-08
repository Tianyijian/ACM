package dailytrain;

/**70. Climbing Stairs
 * DP
 */
public class Day8 {
	public static void main(String[] args) {
		int n = 2;		// 2
		int res = new Day8().climbStairs(n);
		System.out.println(res);
	}
    public int climbStairs(int n) {
        int f1 = 1;
        int f0 = 1;
        for (int i = 2; i <= n;i++) {
            int f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        return f1;
    }
}
