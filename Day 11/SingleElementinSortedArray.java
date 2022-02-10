/**
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
Return the single element that appears only once.
NOTE: Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10 */


/**Sloution 1; xor TC:O(n) */


/**Sloution 2; Binary Search TC:O(log n) 

->As the elements are sorted, twice occurring elements will be placed together in the input array.
->Now in this left array, the first instance of every element is occurring on the even index and the second instance on the odd index. 
    Similarly in the right array, the first instance of every element is occurring on the odd index and the second index is occurring on the even index. 
->So the algorithmic approach will be to use binary search. 
    The intuition is that when we see an element, 
    if we know its index and whether it is the first instance or the second instance, 
    we can decide whether we are presently in the left array or right array. 
->Moreover, we can decide which direction we need to move to find the breakpoint. We need to find this breakpoint between our left array and the right array.
->We will check our mid element, 
    if it is in the left array, 
    we will shrink our left array to the right of this mid element, 
    if it is in the right array, we will shrink the right array to the left of this mid element. 
->This binary search process will continue till the right array surpasses our left one and the low is pointing towards the breakpoint.    */

class Solution {
    public int singleNonDuplicate(int[] nums) {
         int low = 0;
        int high = nums.length - 2;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            iif (mid % 2 == 0) {
                // Checking whether we are in right half
                if (nums[mid] != nums[mid + 1]) 
                    
                    //Shrinking the right half
                    high = mid - 1; 
                else
                    // Shrinking the left half
                    low = mid + 1; 
            } else {
                // Checking whether we are in right half
                if (nums[mid] == nums[mid + 1])
                    //Shrinking the right half
                    high = mid - 1; 
                else
                    // Shrinking the left half
                    low = mid + 1; 
            }
        }
        return nums[low];
    }
}