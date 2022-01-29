/**Leetcode287
Find the duplicate in an array of N+1 integers
Problem Statement: Given an array of N + 1 size, where each element is between 1 and N. Assuming there is only one duplicate number, your task is to find the duplicate number.

Example 1: 
Input: arr=[1,3,4,2,2]
Output: 2
Explanation: Since 2 is the duplicate number the answer will be 2.

Example 2:
Input: [3,1,3,4,2]
Output:3
Explanation: Since 3 is the duplicate number the answer will be 3.
 */
 class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length ==0 )
                return 0;
            int slow=0, fast=0;
            slow = nums[slow];
            fast = nums[nums[fast]];
            while(slow != fast){
                if(slow == nums[slow])
                    return slow;
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while(slow != fast){
                if(slow == nums[slow])
                    return slow;
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
    }
}

/**
->Initially, we have 2, then we got to the second index, we have 9, then we go to the 9th index, we have 1, then we go to the 1st index, we again have 5, then we go to the 5th index, we have 3, then we go to the 3rd index, we get 6, then we go to the 6th index, we get 8, then we go to the 8th index, we get 7, 
then we go to the 7th index and we get 9 and here cycle is formed. */