/**Leetcode 26
*Problem Statement: Given an integer array sorted in non-decreasing order, remove the duplicates in place such that each unique element appears only once. The relative order of the elements should be kept the same.
*If there are k elements after removing the duplicates, then the first k elements of the array should hold the final result. It does not matter what you leave beyond the first k elements.
*Note: Return k after placing the final result in the first k slots of the array.

Example 1: 
Input: arr[1,1,2,2,2,3,3]
Output: arr[1,2,3,_,_,_,_]
Explanation: Total number of unique elements are 3, i.e[1,2,3] and Therefore return 3 after assigning [1,2,3] in the beginning of the array.

Example 2: 
Input: arr[1,1,1,2,2,3,3,3,3,4,4]
Output: arr[1,2,3,4,_,_,_,_,_,_,_]
Explanation: Total number of unique elements are 4, i.e[1,2,3,4] and Therefore return 4 after assigning [1,2,3,4] in the beginning of the array. */

/**Solution 1 : use HashSet 
Approach: 
->Declare a HashSet.
->Run a for loop from starting to the end.
->Put every element of the array in the set.
->Store size of the set in a variable K.
->Now put all elements of the set in the array from the starting of the array.
->Return K.
*/

/**Solution2 : 2 Pointers
->use a pointer to keep track of all the unique elements and another to skip the repeating.*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=0;
        int n=nums.length;
        int k=0;
        while(i<n && j<n){
            nums[i]=nums[j];
            k++;
            while(j<n && nums[i]==nums[j])j++;
            i++;
        }
        return k;
    }
}
