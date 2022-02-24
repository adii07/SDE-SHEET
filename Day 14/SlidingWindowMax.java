/**Sliding window maximum 
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]*/

/**Solution 1: Priority Queue && val-index Pair */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans=new int[nums.length-k+1];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{return b.val-a.val;});
        int start=0;
        int end=0;
        while(k-->1){ pq.add(new Pair(nums[end],end));end++;}
        while(end<nums.length){
            while(!pq.isEmpty() && pq.peek().idx<start)pq.remove();
            pq.add(new Pair(nums[end],end));end++;
            ans[start++]=pq.peek().val;
        }
        return ans;
    }
}
class Pair{
    int val;
    int idx;
    Pair(int val,int idx){
        this.val=val;
        this.idx=idx;
    }
}