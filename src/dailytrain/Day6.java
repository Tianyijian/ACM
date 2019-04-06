package dailytrain;

import java.util.Arrays;

/**LeetCode 698. Partition to K Equal Sum Subsets
 *	recursively searching.
 *	1ms.
 */
public class Day6 {
	public static void main(String[] args) {
//		int[] nums = {2,2,2,2,3,4,5};
		int[] nums = {4, 3, 2, 3, 5, 2, 1};
		int k = 4;
		boolean res = new Day6().canPartitionKSubsets(nums, k);
		System.out.println(res);
	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		if (sum % k > 0) { 
			return false;
		}
        int target = sum / k;
        Arrays.sort(nums);
        int row = nums.length -1 ;
        if (nums[row] > target) return false;
        while(row >= 0 && nums[row] == target) {
        	row--;
        	k--;
        }
        return search(new int[k], row, nums, target);
	}

	public boolean search(int[] groups, int row, int[] nums, int target) {
		if (row < 0) return true;
		int v = nums[row--];
		for (int i =0 ; i < groups.length; i++) {
			if (groups[i] + v <= target) {
				groups[i] += v;
				if (search(groups, row, nums, target)) {
					return true;
				}
				groups[i] -= v;
			}
			if (groups[i]==0) break; 
		}
		return false;
	}
  }
