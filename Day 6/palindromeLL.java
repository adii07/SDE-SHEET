/**234. Palindrome Linked List
Find of a linkedlist is palindrome or not */


/**
->Find the mid of the linkedlist
->Reverse the list mid node onwards
->Check if list is palindrome or not
->Again Reverse the list to get the original list back
 
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode midNode=mid(head);
        midNode.next=reverse(midNode.next);
        midNode=midNode.next;
        while(midNode!=null){
            if(head.val!=midNode.val) return false;
            head=head.next;
            midNode=midNode.next;
        }
        return true;
    }
    //reverse the list
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode nextNode=head.next;
            head.next=prev;
            prev=head;
            head=nextNode;
        }
        return prev;
    }
    //Find the mid
    public ListNode mid(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}