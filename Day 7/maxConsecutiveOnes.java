/**485. Max Consecutive Ones
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2
*/

/**Solution:
->when encounter a 1 increment the count
->else reset count to 0
->At each step update the ans to the max possible value of count*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0;
        int count=0;
        for(int i:nums){
            if(i==1) count++;
            else{
                count=0;
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}