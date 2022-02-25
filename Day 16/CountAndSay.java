/**38.Count and Say
*The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
    countAndSay(1) = "1"
    countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
    To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. 
    Then for each group, say the number of characters, then say the character. 
    To convert the saying into a digit string, replace the counts with a number and concatenate every saying.

Example 1:
Input: n = 1
Output: "1"
Explanation: This is the base case.

Example 2:
Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
*/

/**Solution 1: loop traversal */
class Solution {
    public String countAndSay(int n) {
        int i=1;
        StringBuilder sb=new StringBuilder();
        sb.append(1);
        while(i<n){
            int j=0;
            StringBuilder tmp=new StringBuilder();
            while(j<sb.length()){
                int count=1;
                char ch=sb.charAt(j++);
                while(j<sb.length() && sb.charAt(j)==ch){
                    count++;
                    j++;
                }
                tmp.append(count);
                tmp.append(ch);
            }
            sb=tmp;i++;
        }
        return sb.toString();
    }
}

/**Solution 2:recursion */
class Solution {
    public String countAndSay(int n) {
        if(n==1) return 1+"";
       return helper(1+"",n);
    }
    
    public String helper(String val,int n){
        if(n==1){
            return val;
        }
        int count=0;
        StringBuilder sb=new StringBuilder();
        char prev='a';
        for(int i=0;i<val.length();i++){
            char ch=val.charAt(i);
            if(prev=='a'){
                count=1;
                prev=ch;
            }
            else if(ch==prev){
                count++;
            }else if(ch!=prev){
                    sb.append(count);
                    sb.append(prev);
                    prev=ch;
                count=1;
            }
        }
        sb.append(count);
        sb.append(prev);    
        return helper(sb.toString(),n-1);
    }
}