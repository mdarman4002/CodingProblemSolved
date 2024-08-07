class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }else{
                return s.charAt(i);
            }
        }
        return '@'; // for returning any special keyword cab be used like '%', '$','#'
    }
}
