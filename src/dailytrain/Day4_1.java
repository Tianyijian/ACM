package dailytrain;


/**LeetCode 494 Target Sum
 * DP
 */
public class Day4_1 {
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1};
		int S = 3;
		int res = new Day4().findTargetSumWays(nums, S);
		System.out.println(res);
	}
	

    public int findTargetSumWays(int[] nums, int S) {
    	int sum = 0;
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        }
        if ((sum < S) || ((sum + S) & 1)==1){
        	return 0;
        }
        return subSetSum(nums, (sum + S) / 2);
    } 
    
    public int subSetSum(int[] nums,int s) {
    	int[] dp = new int[s+1];
    	dp[0] = 1;
    	for (int n : nums) {
    		for (int i = s; i >=n; --i){
    			dp[i] += dp[i-n];
    		}
    	}
    	return dp[s];
    }
}
