class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for(String str1: words1){
            map1.put(str1, map1.getOrDefault(str1, 0) + 1);
        }

        for(String str2: words2){
            map2.put(str2, map2.getOrDefault(str2, 0)+ 1);
        }
        int count = 0;
        // Set<String> set1 = map1.keySet();
        // Set<String> set2 = map2.keySet();
       
        for(Map.Entry<String, Integer> entry1: map1.entrySet()){
            String key = entry1.getKey();
            int value = entry1.getValue();
            if(value == 1 && map2.get(key) != null && map2.get(key) == 1 ){
                count++;
            }
        }
        return count;
    }
}
