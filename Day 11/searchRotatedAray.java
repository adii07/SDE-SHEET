/**Search in Rotated Sorted Array 
Problem Statement: 
There is an integer array nums sorted in ascending order (with distinct values). 
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums. 
We need to search a given element in a rotated sorted array.

Example 1:
Input: nums = [4,5,6,7,0,1,2,3], target = 0
Output: 7 
Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1 
Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get output as -1.*/

class Solution {
    public int search(int[] nums, int target) {
        int low=0; int high=nums.length-1;
        while(low<high){
            int mid=low+((high-low)/2);
            if(nums[mid]==target) return mid;
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && nums[mid]>target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(nums[high]>=target && nums[mid]<target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return nums[low]==target?low:-1;
    }
}
/**
It is mentioned that the array given is sorted but in a rotated manner. So, we can divide a given array into two parts that are sorted. 

->We divide the array into parts. 
->It is done using two pointers, low and high, and dividing the range between them by 2. 
->This gives the midpoint of the range. 
->Check if the target is present in the midpoint, calculated before, of the array. 
->If not present, check if the left half of the array is sorted. 
->This implies that binary search can be applied in the left half of the array provided the target lies between the value range. 
->Else check into the right half of the array. Repeat the above steps until low <= high. If low > high, indicates we have searched array and target is not present hence return -1. 
->Thus, it makes search operations less as we check range first then perform searching in possible ranges which may have target value. */