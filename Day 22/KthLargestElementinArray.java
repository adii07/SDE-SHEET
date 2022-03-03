/**Kth Largest Element in an Array
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4*/

/**Solution 1*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums)pq.add(i);
        while(k-->1)pq.remove();
        return pq.peek();
    }
}


/**Solution 2 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            q.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]>q.peek()){
                q.remove();
                q.add(nums[i]);
            }
        }
        return q.remove();
    }
}