/**Kth Largest Element in a Stream 
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 

Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
*/

/**Solution 1: Use Priority Queue 
->Form a min heap(default pq)
->If ever the size of the pq excedes k pop the head of the pq.
*/
class KthLargest {
    PriorityQueue<Integer> pq;
    int Klarge;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
        Klarge=k;
        for(int i:nums){
            pq.add(i);
            if(pq.size()>k) pq.remove(); 
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>Klarge)pq.remove();
        return pq.peek();
    }
}