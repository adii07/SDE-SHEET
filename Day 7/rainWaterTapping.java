/**42. Trapping Rain Water
->Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9 */

/**Solution1 :MAX array
->the amonut of water stored over an building is the height of the tallest building around it - it's own height.
->therefore find the max heiht by which te building i is enclosed ,ie, the height of the tallest build to it's right and on it's left.
->to calculate the ans store the maxHeight to the right and calculate maxLeft on the go
->add water stored over each building to get the max water stored. */
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] maxRight=new int[n];
        int maxValue=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            maxValue=Math.max(maxValue,height[i]);
            maxRight[i]=maxValue;
        }
        maxValue=Integer.MIN_VALUE;
        int ans=0;
        for(int i=0;i<n;i++){
            maxValue=Math.max(maxValue,height[i]);
            int val=Math.min(maxValue,maxRight[i])-height[i];
            ans+=val;
        }
        return ans;
    }
}

/**Solution 3:Optimal Solution(Two pointer approach)

Approach: 
->Take 2 pointer l(left pointer) and r(right pointer) pointing to 0th and (n-1)th index respectively.
->Take two variables leftMax and rightMax and initialise it to 0.
->If height[l] is less than or equal to height[r] then if leftMax is less then height[l] update leftMax to height[l] else add leftMax-height[l] to your final answer and move the l pointer to the right i.e l++.
->If height[r] is less then height[l] then now we are dealing with the right block.
->If height[r] is greater then rightMax,then update rightMax to height[r] else add rightMax-height[r] to the final answer.Now move r to the left. 
->Repeat theses steps till l and r crosses each other.

Intuition: 
We need a minimum of leftMax and rightMax.
So if we take the case when height[l]<=height[r] we increase l++, so we can surely say that there is a block with height more than height[l] to the right of l. 
And for the same reason when height[r]<=height[l] we can surely say that there is a block to the left of r which is at least of height height[r]. 
So by traversing with these cases and using two pointers approach the time complexity can be decreased without using extra space.
 */

 static int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }
