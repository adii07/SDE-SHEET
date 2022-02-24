/**Next Smaller Element
Problem Statement
You are given an array 'ARR' of integers of length N. Your task is to find the next smaller element for each of the array elements.
Next Smaller Element for an array element is the first element to the right of that element which has a value strictly smaller than that element.
If for any array element the next smaller element does not exist, you should print -1 for that array element.
 
Sample Input 1:
2
4
2 1 4 3
3
1 3 2
Sample Output 1:
1 -1 3 -1
-1 2 -1

Sample Input 2:
2
4
1 2 3 4
2
5 0
Sample Output 2:
-1 -1 -1 -1
0 -1 */
/**Solution :Stack
->Start traversal from the end
->pop the top of the stack till the value is greater than or equal to the current array value
->if the stack is empty add -1 to ans else add the peek of the stack as ans */
import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack();
        st.push(-1);
        for(int i=arr.size()-1;i>=0;i--){
            int val=arr.get(i);
            while(st.peek()>=val) st.pop();
            ans.add(0,st.peek());
            st.push(val);
        }
        return ans;
    }
}