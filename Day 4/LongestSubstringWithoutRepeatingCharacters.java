/**Leetcode 9
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring. 
*/

/*Solution 1: Sliding window and Hashmap
->Initialize a hashmap to keep track of the latest occurence of the ith character
->if the ith char repeats itself, update its index in the map and update the start index
->start index will either be the next occurence of the ith char+1(to make string unique) or the cuurent start which ever is bigger in value
->put the char and index in the map
-> calculate the length if the substring(i-start+1)
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int start=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                start=Math.max(start,map.get(ch)+1);
            }
            map.put(ch,i);
            ans=Math.max(ans,(i-start+1));
        }
        return ans;
    }
}