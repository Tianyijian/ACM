package dailytrain;

import java.util.Arrays;

/** LeetCode 698. Partition to K Equal Sum Subsets
 * 483ms
 *
 */
public class Day6_1 {
	public static void main(String[] args) {
//		int[] nums = {2,2,2,2,3,4,5};
		int[] nums = {4, 3, 2, 3, 5, 2, 1};
		int k = 4;
		boolean res = new Day6_1().canPartitionKSubsets(nums, k);
		System.out.println(res);
	}

	
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		if (sum % k > 0) { //
			return false;
		}
        int target = sum / k;
        Arrays.sort(nums);
        int row = nums.length -1 ;
        if (nums[row] > target) return false;
        return part(nums, 0, k, 0, new int[nums.length], target);
	}

	public boolean part(int[] nums, int start, int k, int curSum, int[] vis, int target) {
		if (k == 1) return true;
		if (curSum > target) return false;
		if (curSum == target) return part(nums, 0, k - 1, 0, vis, target);	
		for (int i = start; i<nums.length;i++) {
			if (vis[i] == 1) continue;
			vis[i] = 1;
			if (part(nums, i+1, k, curSum + nums[i], vis, target)) return true;
			vis[i] = 0;
		}
		return false;
	}
  }