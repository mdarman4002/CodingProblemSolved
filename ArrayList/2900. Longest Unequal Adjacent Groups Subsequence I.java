class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 1; i < groups.length; i++){
            if(groups[i] != groups[i-1]){
                if(list.size() == 0){
                    list.add(words[i-1]);
                    list.add(words[i]);
                }
                else{
                    list.add(words[i]);
                }
            }
        }
        return list;
    }
}


class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> list = new ArrayList<>();
        int prev  = -1;
        for(int i = 0; i < groups.length; i++){
            if(groups[i] != prev){
                list.add(words[i]);
                prev = groups[i];
            }
        }
        
        return list;
    }
}
