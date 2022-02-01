/**Leetcode 2
Add two numbers represented as Linked Lists
Problem Statement: Given the heads of two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

Examples:

Input Format: 
num1  = 342, num2 = 564
l1 = [2,4,3]
l2 = [5,6,4]
Result: sum = 807; L = [7,0,8]
Explanation: Since the digits are stored in reverse order, 
reverse the numbers first to get the or original number and then add them as → 342 + 465 = 807.

Input Format: 
l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Result: [8,9,9,9,0,0,0,1]
Explanation: Since the digits are stored in reverse order, reverse the numbers first to get the     
original number and then add them as → 9999999 + 9999 = 8999001. */

/**Solution 1:
->Make a new Node to act like the head of the ans
->the sum of the current numbers will be their sum + the carry from the prev
->so while either of the node has a value and carry is not zero traverse and perform addition */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode p=head;
        int carry=0;
        while(l1!=null || l2!=null || carry>0){
            int sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            carry=sum>9?1:0;
            sum=sum%10;
            p.next=new ListNode(sum);
            p=p.next;
        }
        return head.next;
    }
}