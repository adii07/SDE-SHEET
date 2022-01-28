/**  Leetcode 31
Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

Example 1 :

Input format: Arr[] = {1,3,2}

Output: Arr[] = {2,1,3}

Explanation: All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}. So, the next permutation just after {1,3,2} is {2,1,3}.
Example 2:

Input format: Arr[] = {3,2,1}

Output: Arr[] = {1,2,3}

Explanation: As we see all permutations of {1,2,3}, we find {3,2,1} at the last position. So, we have to return the topmost permutation.

 */
 public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


/**
Solution 1 Brute Force: Finding all possible permutations. 
Approach :
Step 1: Find all possible permutations of elements present and store them.
Step 2: Search input from all possible permutations.
Step 3: Print the next permutation present right after it.

Solution 2: Look for the peak and the valley in the input pattern
Approach :
Step 1: Linearly traverse array from backward such that ith index value of the array is less than (i+1)th index value. Store that index in a variable.
Step 2: If the index value received from step 1 is less than 0. 
        This means the given input array is the largest lexicographical permutation. 
        Hence, we will reverse the input array to get the minimum or starting permutation. 
        Linearly traverse array from backward. 
        Find an index that has a value greater than the previously found index. 
Store index another variable.
Step 3: Swap values present in indices found in the above two steps.
Step 4: Reverse array from index+1 where the index is found at step 1 till the end of the array.

 */
 //https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/