/**
Two Sum : Check if a pair with given sum exists in Array
Problem Statement: Given an array of integers nums[] and an integer target, return indices of the two numbers such that their sum is equal to the target.

Note: Assume that there is exactly one solution, and you are not allowed to use the same element twice. 
Example: If target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, which is the required target, we return indexes [0,1]. (0-based indexing)

Example 2:
Input Format: nums = [3,2,4,6], target = 6
Output: [1,2]
Explanation: Because nums[1] + nums[2] == 6, which is the required target, we return indexes [1,2]. */


/**Solution 1: brute force
-> For every integer check all the other values for the potential ans 
*/

/**Solution 2: Sorting and 2 Pointer
-> store the values in an temp array and sort that array now find the using 2pointer problem and find the pair.
-> now traverse the original array and map the ans values with their original index
*/

/**Solution 3: HashMap
-> As we travserse the array check if the desired value(target-nums[i]) is present in the map.
-> if present add to the ans array and return the value.
-> else add the current value to the map along with its index and continue step 1 till ans is not found. */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                ans[0]=map.get(target-nums[i]);
                ans[1]=i;
                break;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}