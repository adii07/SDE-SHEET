/**19. Remove Nth Node From End of List
-Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1] 
*/

/**Solution 1: Naive Approach [Traverse 2 times]

Intuition: 
->We can traverse through the Linked List while maintaining a count of nodes, 
->then traversing for the 2nd time for (n – count) nodes to get to the nth node of the list 
*/

/**Solution 2: 2 pointer 
->We have the flexibility of using two-pointers now.
->We know, the n-th node from the end is the same as (total nodes – n)th node from start.
->But, we are not allowed to calculate total nodes, as we can do only one traversal.

->What if, one out of the two-pointers is at the nth node from start instead of end? Will it make anything easier for us?
Yes, with two pointers in hand out of which one at n-th node from start, 
    we can just advance both of them till end simultaneously, 
    once the faster reaches the end, 
    the slower will stand at the n-th node from the end.

Approach : 
->Take two dummy nodes, who’s next will be pointing to the head.
->Take another node to store the head, initially it,s a dummy node(start), and the next of the node will be pointing to the head.
->Start traversing until the fast pointer reaches the nth node.
->Now start traversing by one step both of the pointers until the fast pointers reach the end. 

NOTE: USE DUMMY NODE AS HEAD TO AVOID ANY NULL POINTER EXCEPTIONS(in case when n==length of list)
The reason why we are using this extra dummy node, is because there is an edge case. 
If the node is equal to the length of the linkedlist, then this slow’s next will point to slow’s next→ next. 
And we can say our dummy start node will be broken, and will be connected to the slow’s next→ next.
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode Root, int n) {
        if(Root==null || Root.next==null) return null;
        ListNode head=new ListNode(); 
        head.next=Root;
        ListNode fast=head;
        ListNode slow=head;
        while(n-->0){
            fast=fast.next;
        }
        while(fast!=null && fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head.next;
    }
}