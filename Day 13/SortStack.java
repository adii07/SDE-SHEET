/**Sort a Stack
Problem Statement
You’re given a stack consisting of 'N' integers. Your task is to sort this stack in descending order using recursion.
We can only use the following functions on this stack S.
is_empty(S) : Tests whether stack is empty or not.
push(S) : Adds a new element to the stack.
pop(S) : Removes top element from the stack.
top(S) : Returns value of the top element. Note that this function does not remove elements from the stack.
Note :
1) Use of any loop constructs like while, for..etc is not allowed. 
2) The stack may contain duplicate integers.
3) The stack may contain any integer i.e it may either be negative, positive or zero.
Sample Input 1:
1
5
5 -2 9 -7 3
Sample Output 1:
9 5 3 -2 -7
Sample Input 2:
1
5
-3 14 18 -5 30
Sample Output 2:
30 18 14 -3 -5 */
import java.util.Stack;
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
        Stack<Integer> st=new Stack<>();
        while(!stack.isEmpty()){
            int val=stack.pop();
            int k=0;
            while(!st.isEmpty() && st.peek()<val){
                stack.push(st.pop());
                k++;
            }
            st.push(val);
            while(k-->0) st.push(stack.pop());
        }
        while(!st.isEmpty()){
            stack.push(st.pop());
        }
	}

}