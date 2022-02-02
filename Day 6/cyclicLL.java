/** 141. Linked List Cycle
Detect a Cycle in a Linked List
-In this article we will solve the most asked interview question: Detect a Cycle in a Linked List
-Problem Statement: Given head, the head of a linked list, determine if the linked list has a cycle in it. There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
-Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:
Input:
 Head = [1,2,3,4]
Output:
 true
Explanation: Here, we can see that we can reach node at position 1 again by following the next pointer. Thus, we return true for this case.

Example 2:
Input:
 Head = [1,2,3,4]
Output:
 false
Explanation: Neither of the nodes present in the given list can be visited again by following the next pointer. Hence, no loop exists. Thus, we return false.
 */


/**Solution 1: HashMap */

/**Solution 2: 2 pointers
->fast and slow */

 public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
}