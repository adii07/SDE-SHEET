/**876. Middle of the Linked List
Problem Statement: Given the head of a singly linked list, return the middle node of the linked list. If there are two middle nodes, return the second middle node.

Examples:

Input Format: 
( Pointer / Access to the head of a Linked list )
head = [1,2,3,4,5]
Result: [3,4,5]
( As we will return the middle of Linked list the further linked list will be still available )
Explanation: The middle node of the list is node 3 as in the below image.

Input Format: 
Input: head = [1,2,3,4,5,6]
Result: [4,5,6]
Explanation: 
Since the list has two middle nodes with values 3 and 4, we return the second one.
*/

/**Solution 1: 2 pointer
-> Initiate a slow pointer and fast pointer
->the slow pointer moves 1 node at a time ,whereas the fast pointer moves 2 nodes at a time.
->therefore till the fast node reaches the last or the 2nd last node(for odd number of list) the slow pointer will be pointing to the middle node*/
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}

/**Solution 2: Brute force
->first iterate over the list to find the total number of nodes
->then iterate again and travel till the length/2 node */