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
		int[] dp = new int[sum + 1]; // dp[i]=j ��ʾ�ܺʹﵽi��j�����
		dp[0] = 1;
		for (int n : nums) {
			for (int i = sum; i >= n; i--) {
				dp[i] = dp[i - n] | dp[i]; // ��+=�ɼ���������������ǿ����������numsΪ100��100
			}
		}
		return dp[sum] != 0;
	}

}
