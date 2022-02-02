/**142. Linked List Cycle II
-Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
-There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
-Do not modify the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list. */

/**solution 1: HashSet
->use set to mark to mark travelled nodes
->return the first node that is visited again */

/**Solution 2: 2 pointer
->Initially take two pointers, fast and slow. Fast pointer takes two steps ahead while slow pointer will take single step ahead for each iteration.
->We know that if a cycle exists, fast and slow pointers will collide.
->If cycle does not exists, fast pointer will move to NULL
->Else, when both slow and fast pointer collides, it detects a cycle exists.
->Take another pointer, say entry. Point to the very first of the linked list.
->Move the slow and the entry pointer ahead by single steps until they collide. 
->Once they collide we get the starting node of the linked list
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) break;
        }
        if(fast==null || fast.next==null) return null;
        while(head!=fast){
            head=head.next;
            fast=fast.next;
        }
        return head;
    }
}