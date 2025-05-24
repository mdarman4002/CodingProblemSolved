class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                if(x == words[i].charAt(j)){
                    res.add(i);
                    break;
                }

            }
        }
        return res;
    }
}


// best 
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(words[i].indexOf(x) != -1){
                res.add(i);
            }
        }
        return res;
    }
}
