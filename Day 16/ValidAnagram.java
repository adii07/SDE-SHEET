/**Valid Anagram

*Given two strings s and t, return true if t is an anagram of s, and false otherwise.
*An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
*/

/**Solution 1: Array as hashmap 
->Initialize a array of size 26 to map each alphabet
->Traverse the 1st string and increment the count  of each character
->Traverse the 2st string and decrement the count  of each character
->Traverse the array if any value is not equal to zero return false
->Return true
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] map=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map[ch-'a']++;
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map[ch-'a']--;
        }
        for(int i:map){
            if(i!=0) return false;
        }
        return true;
    }
}

/**Solution 2: Use HashMap */

/**Solution 3: Sort the string and compare 
->convert the string to char arrays
->sort the arrays
->compare char by char if at any instance the value are not equal return false
->return true
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        Arrays.sort(s1);Arrays.sort(t1);
        for(int i=0;i<s1.length;i++) if(s1[i]!=t1[i]) return false;
        return true;
    }
}

/**Solution 4: Sort the strings and compare using String.equals()
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        Arrays.sort(s1);Arrays.sort(t1);
        s=Arrays.toString(s1);
        t=Arrays.toString(t1);
        return s.equals(t);
    }
}