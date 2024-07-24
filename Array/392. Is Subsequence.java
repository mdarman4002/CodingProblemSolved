// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         HashSet<String> set = new HashSet<>();
//         String output = "";
//         return func(s, t, 0, t.length(),output, set);

//     }
//     public boolean func(String s, String t, int index, int len, String output, HashSet<String>set){
//         if(len == index){
//             set.add(output);
//             if(set.contains(s)){
//                 return true;
//             }else{
//                 return false;
//             }
//         }
//         return func( s, t, index+1,  len,  output + t.charAt(index), set) ||
//         func( s, t,  index+1,  len, output, set);

//     }
// }

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        char ch_s[] = s.toCharArray(); int ch_s_l = s.length();
        char ch_t[] = t.toCharArray(); int ch_t_l = t.length();
        if(ch_t_l == 0 && ch_s_l == 0){
            return true;
        }else if(ch_s_l  != 0 && ch_t_l == 0){
            return false;
        }
        else{
            while(ch_s_l > i && ch_t_l > j){
                if(ch_s[i] == ch_t[j]){
                    i++;
                }
                j++;
            }return i == ch_s_l;
        }// return false;
        // while (i < s.length() && j < t.length()) {
        //     if (s.charAt(i) == t.charAt(j)) {
        //         i++;
        //     }
        //     j++;
        // }
        // return i == s.length();
    }
}
