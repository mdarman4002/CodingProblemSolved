class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            
            freq[s.charAt(i)-'a']++;
        }
        int max =0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            if(freq[i] != 0&& freq[i] % 2 != 0){
                max = Math.max(max,freq[i]);
               
            }
            if(freq[i] != 0 && freq[i] % 2 == 0){
                 min = Math.min(min, freq[i]);
            }
        }
        
        return max - min;
    }
}
