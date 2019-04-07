package dailytrain;

/**
 * 746. Min Cost Climbing Stairs
 * DP
 */
public class Day7 {
	public static void main(String[] args) {
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};	//6
		int res = new Day7().minCostClimbingStairs(cost);
		System.out.println(res);
	}
	
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length;i++) {
            dp[i] = cost[i] + (dp[i-1] < dp[i-2] ? dp[i-1] : dp[i-2]);
        }
        return dp[n-1] > dp[n-2] ? dp[n-2] : dp[n-1];
    }
}
