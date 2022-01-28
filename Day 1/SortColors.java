/**Leetcode 75--This problem is a variation of the popular Dutch National flag algorithm 
Problem Statement: Given an array consisting of only 0s, 1s and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Input: nums = [2,0,1]
Output: [0,1,2]

Input: nums = [0]
Input: nums = [0]
 */
class Solution {
    public void sortColors(int[] nums) {
        int k=nums.length-1;int j=0,i=0;
        while(i<=k){
            if(nums[i]==2){
                swap(i,k,nums);
                k--;
            }
            else if(nums[i]==0){
                swap(i,j,nums);
                j++;i++;
            }else{i++;}
        }
    }
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}