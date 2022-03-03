/**Arithmetic Slices
An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
Example 2:

Input: nums = [1]
Output: 0 */

/**Solution 1:dynamic programming
->if the current element forms a slice, the number of slices it creates is the sum of the slices created by the prev element +1(the current element adds to the length of all the prev continuous slices)
->else if it fails to form a slice its value at dp is 0 as it doesnot form any slice
*/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int[] dp=new int[nums.length];
        for(int i=2;i<nums.length;i++){
            dp[i]=(nums[i]-nums[i-1]==nums[i-1]-nums[i-2])?dp[i-1]+1:0;
        }
        int ans=0;
        for(int i:dp)ans+=i;
        return ans;
    }
}

/**Solution 2:Pointer
->Similar approach but insted of dp array juat use a single variable to store the count of the prev element
*/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int ans=0;
        int prev=0;
        for(int i=2;i<nums.length;i++){
            prev=(nums[i]-nums[i-1]==nums[i-1]-nums[i-2])?prev+1:0;
            ans+=prev;
        }
        return ans;
    }
}