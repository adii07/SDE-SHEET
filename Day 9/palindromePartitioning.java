class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> subList=new ArrayList<>();
        helper(ans,subList,0,s);
        return ans;
    }
    
    public void helper(List<List<String>> ans,List<String> subList,int idx,String s){
        if(idx==s.length()){
            ans.add(new ArrayList<>(subList));
            return;
        }
        for(int i=idx;i<s.length();i++){
            String palin=s.substring(idx,i+1);
            if(isPalindrome(palin)){
                subList.add(palin);
                helper(ans,subList,i+1,s);
                subList.remove(subList.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s){
        int left=0,right=s.length()-1;
        while(left<=right){
            if(s.charAt(left++)!=s.charAt(right--)) return false;
        }
        return true;
    }
}