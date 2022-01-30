/**Leetcode 169
Find the Majority Element that occurs more than N/2 times
Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.

Example 1:
Input Format: N = 3, nums[] = {3,2,3}
Result: 3
Explanation: When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution. 

Example 2:
Input Format:  N = 7, nums[] = {2,2,1,1,1,2,2}
Result: 2
Explanation: After counting the number of times each element appears and comparing it with half of array size, we get 2 as result.

Example 3:
Input Format:  N = 10, nums[] = {4,4,2,4,3,4,4,3,2,4}
Result: 4 
*/

/**Solution 1 -use loops to count for each element */

/**Solution 2 -use HashMap */

/**Solution 3: Moore’s Voting Algorithm */
class Solution {
    public int majorityElement(int[] nums) {
        int ans=nums[0];
        int count=1;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]==ans) count++;
            else count--;
            
            if(count==0){
                ans=nums[i];
                count=1;
            }
        }
        return ans;
    }
}
/**
Approach: 

->Initialize 2 variables: 
    -Count –  for tracking the count of element
    -Element – for which element we are counting
->Traverse through nums array.
    -If Count is 0 then initialize the current traversing integer of array as Element 
    -If the traversing integer of array and Element are same increase Count by 1
    -If they are different decrease Count by 1
->The integer present in Element is the result we are expecting
*/
/**
Moore’s Voting Algorithm

Intuition: The question clearly states that the nums array has a majority element. Since it has a majority element we can say definitely the count is more than N/2.
Majority element count = N/2 + x;
Minority/Other elements = N/2 – x;
Where x is the number of times it occurs after reaching the minimum value N/2.
Now, we can say that count of minority elements and majority element are equal upto certain point of time in the array. 
So when we traverse through the array we try to keep track of the count of elements and which element we are tracking. 
Since the majority element appears more than N/2 times, we can say that at some point in array traversal we find the majority element. 
 */