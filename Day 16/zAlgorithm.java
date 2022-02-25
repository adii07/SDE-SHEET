/**Z Algorithm

Problem Statement
You’re given a string S of length N and a string P of length M. Your task is to find the number of occurrences of P in S in linear time.
For Example:
If S = "ababa", and P = "ab", then "ab" occurs twice in "ababa". 

Sample Input 1:
2
5 2
ababa
ab
4 10
codercodes
code
Sample Output 1:
2
2

Sample Input 2:
2
7 3
aababba
aba
6 2
zzzzyz
zz   
Sample Output 2:
1
3
*/

public class Solution {

	public static int zAlgorithm(String s, String p, int n, int m) {
        int count=0;
        for(int i=0;i<=n-m;i++){
            if(s.charAt(i)==p.charAt(0)){
                if(s.substring(i,i+m).equals(p)){
                    count++;
                }
            }
        }
        return count;
	}

}