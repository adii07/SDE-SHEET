/**Find Median from Data Stream
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.

Implement the MedianFinder class:
MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted. 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
*/

/**Solution 1: use 2 priority queue
->one of the q stores increasing heap and the other stores the decreasing heap
    *This is done so the max heap stores the largest value at the top amongst the smaller half of values and the min heap stores the min/smallest of the larger half of values
    *Therefore to find the median we just need the top elements from both the q.
->left is the max heap(greatest at the top->it contains the greatest if the smaller values) and right is the min heap(smallest at the top->it contains the smallest the greater values)
->by default add to the left q, only add to the right q if it is not empty and the head of the right q(min heap) is smaller than the value(value is greater than the peek of the min heap)
->If the differnce of the size at any point between both the q is greater than 1 move data from 1 queue to the other
->To get the median :
                    ->If the size is even, return the head of the q,which is greater in size than the other
                    ->return the average of the head of the 2 queue.
*/
class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
      left = new PriorityQueue<>(Collections.reverseOrder());
      right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(!right.isEmpty() && right.peek()<=num)
            right.add(num);
        else left.add(num);
        
        if(Math.abs(left.size()-right.size())>1){
            if(left.size()>right.size()) right.add(left.remove());
            else left.add(right.remove());
        }
    }
    
    public double findMedian() {
        if((left.size()+right.size())%2!=0) return left.size()>right.size()?(double)left.peek():(double)right.peek();
        else{
            int val=left.peek()+(right.isEmpty()?0:right.peek());
            return (double) ((double)val)/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


 /**Solution 2: self-balanced binary search tree  */