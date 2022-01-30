/**Leetcode 229
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]
 */

 
/**Solution 1 -use loops to count for each element */

/**Solution 2 -use HashMap */

/**Solution 3: use 2 pointers */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int n=nums.length/3;
        int a1=-1,c1=0;
        int a2=-1,c2=0;
        
        for(int a:nums){
            if(a==a1) c1++;
            else if(a==a2) c2++;
            else if(c1<=0){
                a1=a;
                c1=1;
            }else if(c2<=0){
                a2=a;
                c2=1;
            }else{
                c2--;
                c1--;
            }
            
        }
        int z1=0,z2=0;
        for(int a:nums){
            if(a==a1)z1++;
            if(a==a2)z2++;
        }
        if(z1>n) ans.add(a1);
        if(z2>n && a1!=a2) ans.add(a2);
        return ans;
    }
}

/**
Approach + Intuition: In our code, we start with declaring a few variables:

->num1 and num2 will store our currently most frequent and second most frequent element.
->c1 and c2 will store their frequency relatively to other numbers.
->We are sure that there will be a max of 2 elements which occurs > N/3 times because there cannot be if you do a simple math addition.
->Let, ele be the element present in the array at any index. 
    -if ele == num1, so we increment c1.
    -if ele == num2, so we increment c2.
    -if c1 is 0, so we assign num1 = ele.
    -if c2 is 0, so we assign num2 = ele.
    -In all the other cases we decrease both c1 and c2.
->In the last step, we will run a loop to check if num1 or nums2 are the majority elements or not by running a for loop check. 
*/