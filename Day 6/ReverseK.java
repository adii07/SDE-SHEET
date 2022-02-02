/**Leetcode 25 Reverse Nodes in k-Group*/

/**Solution 1:ExtraSpace*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode curr=head;
        ListNode dummy=new ListNode();
        ListNode newCurr=dummy;
        while(curr!=null){
            ListNode temp=curr;
            int i=k,av=0;
            while(i-->0 && temp!=null){
                temp=temp.next;av++;
            }
            if(av==k){
                newCurr.next=reverse(curr,k);
                newCurr=curr;
            }else{
                newCurr.next=curr;
            }
            curr=temp;
        }
        return dummy.next;
    }
    
    public ListNode reverse(ListNode head,int k){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null && k-->0){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
