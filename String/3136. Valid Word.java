class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if(n < 3) return false;
        boolean vowel = false;
        boolean cons = false;
        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                    vowel = true;
                }
                else if(ch == '@' || ch == '#' || ch == '$'){
                    return false;
                }
                else if(
                ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch ==  '5' ||
                ch == '6' || ch == '7' || ch == '8' || ch == '9' || ch == '0'){
                    continue;
                }else{
                    cons = true;
                }
               
        }
        if(vowel == true && cons == true){
                    return true;
        }
        return false;
    }
}
