/**Leetcode 493
->Given an integer array nums, return the number of reverse pairs in the array.
->A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

Example 1:
Input: nums = [1,3,2,3,1]
Output: 2

Example 2:
Input: nums = [2,4,3,5,1]
Output: 3
*/

/**Solution1: Brute Force
->use 2 for loops to get the count and return the count.
->First loops runs over the n elements in the array.
->Second loop runs over all the smaller index than the current index.
*/
class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[i]*2)count++;
            }
        }
        return count;
    }
}

/**Solution 2:Use Map to store the count of the variable and check for condition for each variable
 */

 /**Solution 3: Merge Sort 
 
 Intuition:
-> We will be using the Merge Sort Algorithm to solve this problem. 
    We split the whole array into 2  parts creating a Merge Sort Tree-like structure. 
    During the conquer step we do the following task : 
-> We take the left half of the Array and Right half of the Array, both are sorted in themselves. 
-> We will be checking the following condition arr[i] <= 2*arr[j]  where i is the pointer in the Left Array and j is the pointer in the Right Array. 
-> If at any point arr[i] <= 2*arr[j] , we add 1  to the answer as this pair has a contribution to the answer. 
-> If Left Array gets exhausted before Right Array we keep on adding the distance j pointer traveled as both the arrays are Sorted so the next ith element from Left Subarray will equally contribute to the answer.
-> The moment when both Arrays get exhausted we perform a merge operation. This goes on until we get the original array as a Sorted array.
 */
class Solution {
    
    int merge(int[] nums, int low, int mid, int high) {
        int cnt = 0;
        int j = mid + 1; 
        for(int i = low;i<=mid;i++) {
            while(j<=high && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            cnt += (j - (mid+1));
        }
        
        ArrayList<Integer> temp = new ArrayList(); 
        int left = low, right = mid+1; 
        while(left <= mid && right<=high) {
            if(nums[left]<=nums[right]) {
                temp.add(nums[left++]); 
            }
            else {
                temp.add(nums[right++]); 
            }
        }
        
        while(left<=mid) {
            temp.add(nums[left++]); 
        }
        while(right<=high) {
            temp.add(nums[right++]); 
        }
        
        for(int i = low; i<=high;i++) {
            nums[i] = temp.get(i - low); 
        }
        return cnt; 
    }
    int mergeSort(int[] nums, int low, int high) {
        if(low>=high) return 0; 
        int mid = (low + high) / 2;
        int inv = mergeSort(nums, low, mid); 
        inv += mergeSort(nums, mid+1, high); 
        inv += merge(nums, low, mid, high); 
        return inv; 
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1); 
    }
}
 /**
 Approach :  

-> We first of all call a Merge Sort function, in that we recursively call Left Recursion and Right Recursion,
     after that we call Merge function in order to merge both Left and Right Calls we initially made and compute the final answer.
-> In the Merge function, we will be using low, mid, high values to count the total number of inversion pairs for the Left half and Right half of the Array.
->  Now, after the above task, we need to Merge the both Left and Right sub-arrays using a temporary vector.
-> After this, we need to copy back the temporary vector to the Original Array. Then finally we return the number of pairs we counted. */