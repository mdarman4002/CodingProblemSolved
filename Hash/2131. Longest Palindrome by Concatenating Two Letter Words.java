class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;
        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();

            if(map.getOrDefault(reversed, 0 ) > 0){
                map.put(reversed, map.get(reversed)-1);
                result += 4;
            }else{
                map.put(word, map.getOrDefault(word,0)+1);
            }
            
        }
        // find single word which is can be used in middle as palindrome
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();

            String key = entry.getKey();
            if (value > 0 & key.charAt(0) == key.charAt(1)) {
                result += 2;
                break;
            }

        }
        return result;

    }
}
