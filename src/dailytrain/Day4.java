package dailytrain;

/**LeetCode 494 Target Sum
 * @author 26241
 *
 */
public class Day4 {	//DFS 
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1};
		int S = 3;
		int res = new Day4().findTargetSumWays(nums, S);
		System.out.println(res);
	}
	int M = 0;
	int Sum;
    public int findTargetSumWays(int[] nums, int S) {
        Sum = S;
        dfs(nums, 0, 0);
        return M;
    }
    public void dfs(int[] nums, int t, int S) {
    	if (t == nums.length) {
    		if (Sum == S) {
    			M++;
    		}
    		return;
    	}
		dfs(nums, t+1, S+nums[t]);
		dfs(nums, t+1, S-nums[t]);
    }
}
