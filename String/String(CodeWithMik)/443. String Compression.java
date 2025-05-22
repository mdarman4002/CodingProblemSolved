//most efficeint way
class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[index++] = chars[i - 1];
                if (count > 1) {

                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[index++] = c;
                    }
                }
                count = 1;
            }

        }
        chars[index++] = chars[chars.length - 1];
        if (count > 1) {
            for (char c : String.valueOf(count).toCharArray()) {
                chars[index++] = c;
            }
        }
        return index;
    }

}


// class Solution {
//     public int compress(char[] chars) {
//         int count = 1 ;
//         StringBuilder sb = new StringBuilder("");

//         sb.append(chars[0]);

//         for(int i = 1 ;i<chars.length;i++){

//             if(chars[i-1]!=chars[i]){
//                 if(count>1){
//                     sb.append(count+"");
//                 }
//                 sb.append(chars[i]);
//                 count = 1;

//             }else{
//                 count++;
//             }
//         }

//         if(count>1){
//             sb.append(count+"");
//         }

//         for(int i=0;i<sb.length();i++){
//             char ch = sb.charAt(i);
//             chars[i]=ch;
//         }

//         return sb.length();

//     }
// }



//using space  26 not passing all cases because charcter is not in sorted way
// class Solution {
//     public int compress(char[] chars) {
//         int[] count = new int[26];
//         for (char ch : chars) {
//             int index = ch - 'a';
//             count[index]++;
//         }
//         StringBuilder sb = new StringBuilder("");
//         for (int i = 0; i < 26; i++) {
//             if (count[i] != 0) {
//                 int c = count[i];
//                 char character = (char) (i + 'a');
//                 sb.append(character);

//                 if (c > 1) {

//                     for (char digit: String.valueOf(c).toCharArray()) {
//                         sb.append(digit);
//                     }
//                 } 
//             }

//         }
//         for(int i = 0; i  < sb.length(); i++){
//             char ch = sb.charAt(i);
//             chars[i] = ch;
//         }
//         return sb.length();

//     }
// }
