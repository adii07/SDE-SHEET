/**Leetcode 53
Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and return its sum and print the subarray.

Example 1:
Input: arr = [-2,1,-3,4,-1,2,1,-5,4] 
Output: 6 
Explanation: [4,-1,2,1] has the largest sum = 6. 

Examples 2: 
Input: arr = [1] 
Output: 1 
Explanation: Array has only one element and which is giving positive sum of 1.
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.max(sum+nums[i],nums[i]);
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}

 /**
Solution 1: Naive Approach 
Approach: Using three for loops, we will get all possible subarrays in two loops and their sum in another loop, and then return the maximum of them. 

Solution 2: A better approach
Approach : 
We can also do this problem using only two for loop, starting the function with ( max_sum ) variable which will have the final answer. 
We can get the sum of all possible subarrays in this way and then return the maximum so far.

Solution : 3 Optimal Solution: Kadane’s Algorithm 

Intuition: Basically this problem can be done in linear time complexity with Kadane’s algorithm along with that will also get the subarray which is giving the largest positive-sum. 

Approach: 
->Maintain a variable to store the maxsum and the currentsum
->add the number at index i to the current sum
->if current sum becomes less than zero,update the current sum to zero
->maxSum is the max of currentSum and maxSum at each level
-> return maxSum
*/


/**If subarray is also asked
public static int maxSubArray(int[] nums,ArrayList<Integer> subarray) { 
int msf=nums[0] , meh=0 ; 
int s=0;
for(int i=0;i<nums.length;i++){ 
meh+=nums[i]; 
if(meh>msf)
{ 
    subarray.clear();
    msf=meh; 
    subarray.add(s); 
    subarray.add(i); 
    
} 
if(meh<0)
{
    meh=0; 
    s=i+1;
    
} 
} 
 
return msf; 
} 
 */