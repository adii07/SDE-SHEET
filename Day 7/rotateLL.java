/**Leetcode 61: Rotate a list
-Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
*/
/**Solution : 2pointer

Steps to the algorithm:-
->Calculate length of the list
->Connect the last node to the first node, converting it to a circular linked list.
->Iterate to cut the link of the last node and start a node of k%length of list rotated list.
*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        int listLength=length(head);
        k=k%listLength;
        ListNode fast=head;
        while(k-->0){
            fast=fast.next;
        }
        ListNode slow=head;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        
        fast.next=head;
        head=slow.next;
        slow.next=null;
        return head;
    }
    
    public int length(ListNode head){
        int i=0;
        while(head!=null){
            head=head.next;
            i++;
        }
        return i;
    }
}