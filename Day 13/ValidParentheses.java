/**Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
-Open brackets must be closed by the same type of brackets.
-Open brackets must be closed in the correct order.
 
Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false */
class Solution {
    public boolean isValid(String s) {
        int i=0;
        Stack<Character> st=new Stack<>();
        while(i<s.length()){
            char ch=s.charAt(i++);
            if(ch=='(' || ch=='{' || ch=='[') st.push(ch);
            else{
                switch(ch){
                    case '}':
                        if(!st.isEmpty() && st.peek()=='{') st.pop();
                        else return false;
                        break;
                    case ']':
                        if(!st.isEmpty() && st.peek()=='[') st.pop();
                        else return false;
                        break;
                    case ')':
                        if(!st.isEmpty() && st.peek()=='(') st.pop();
                        else return false;
                        break;
                }
            }
        }
        return st.isEmpty();
    }
}