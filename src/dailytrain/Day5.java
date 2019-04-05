package dailytrain;

/**
 * LeetCode 416. Partition Equal Subset Sum
 * DP.
 */
public class Day5 {
	public static void main(String[] args) {
		int[] nums = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
				100, 100, 100, 100, 100 };	//true
		boolean res = new Day5().canPartition(nums);
		System.out.println(res);
	}

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		if ((sum & 1) == 1) { // odd num
			return false;
		}
		return find(nums, sum / 2);
	}

	public boolean find(int[] nums, int sum) {
		int[] dp = new int[sum + 1]; // dp[i]=j 表示总和达到i有j种情况
		dp[0] = 1;
		for (int n : nums) {
			for (int i = sum; i >= n; i--) {
				dp[i] = dp[i - n] | dp[i]; // 用+=可计算所有情况，但是可能溢出，如nums为100个100
			}
		}
		return dp[sum] != 0;
	}

}
