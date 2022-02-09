/**Letcode 140
*Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. 
*Return all such possible sentences in any order.
**Note that the same word in the dictionary may be reused multiple times in the segmentation.**

Example 1:
Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]

Example 2:
Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: [] 
*/
/* Solution1: Backtracking
->check if a sunstring is present in the dictionary, if yes call the dfs function from the next index onwards*/
class Solution {
    List<String> ans;
    public List<String> wordBreak(String s, List<String> dictionary) {
        ans=new ArrayList<>();
        helper(s,0,"",dictionary);
        return ans;
    }
    public void helper(String s,int idx,String ssf,List<String> dictionary){
        if(idx>=s.length()){

            ans.add(ssf.trim());
            return;
        }
        
        for(int i=idx;i<s.length();i++){
            String sub=s.substring(idx,i+1);
            if(dictionary.contains(sub)){
                helper(s,i+1,ssf+sub+" ",dictionary);
            }
        }
    }
}