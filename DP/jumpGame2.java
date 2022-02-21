/**Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2 */


/**DP */
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,n-1);
        dp[0] = 0;
        for(int i=0; i<n; i++){
            int max = Math.min(n-1, i+ nums[i]);
            for(int j = i+1; j<=max; j++){
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[n-1];
    }
}

/**Greedy  */

public int jump(int[] A) {
int step_count = 0;
int last_jump_max = 0;
int current_jump_max = 0;
for(int i=0; i<A.length-1; i++) {
    current_jump_max = Math.max(current_jump_max, i+A[i]);
    if( i == last_jump_max ) {
        step_count++;
        last_jump_max = current_jump_max;
    } 
    if (current_jump_max == n-1) 
    return step_count+1;
}
return step_count;