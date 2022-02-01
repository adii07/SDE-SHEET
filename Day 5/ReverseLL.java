/**206. Reverse Linked List
Problem Statement: Given the head of a singly linked list, write a program to reverse the linked list, and return the head pointer to the reversed list.

Examples:

Input Format: 
head = [3,6,8,10]
This means the given linked list is 3->6->8->10 with head pointer at node 3.
Result:
Output = [10,6,8,3]
This means, after reversal, the list should be 10->6->8->3 with the head pointer at node 10. */


/**Solution 1: Recursion
->Return the new head once the last node is encounterd
->for the rest of the nodes, update the pointers and return the newHead
->to update the pointers, 
    first mark the next pointer of the next node to point to the current node and 
    then update the next pointer of the current node as null 

NOTE: PREV NODE AT ALL TIMES CONTAINS THE NEW HEAD OF THE LIST
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode prev=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return prev;
    }
}
/**Solution 2: Iteration
->While iterating keep track of the previous node.
->mark the prev node as the next of the current node to reverse the order.
->after each iteration move to the next node and update the prev with the current node.
->mark the last node as the head node and return.
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        head=prev;
        return head;
    }
}

/**Solution 3: Add first
->Make an addFirst() function which add the given node to the front of the node.*/