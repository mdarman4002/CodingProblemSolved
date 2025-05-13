class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int lengthAfterTransformations(String s, int t) {
        long[] freq = new long[26];
        for (int i = 0; i < s.length(); i++) {

            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            long[] newFreq = new long[26];
            for (int j = 0; j < 26; j++) {
                if (j == 25) { // For 'z'
                    newFreq[0] = (newFreq[0] + freq[j]) % MOD;
                    newFreq[1] = (newFreq[1] + freq[j]) % MOD;
                } else {
                    newFreq[j + 1] = (newFreq[j + 1] + freq[j]) % MOD;
                }
            }
            freq = newFreq;
        }

        long result = 0;
        for (long count : freq) {
            result = (result + count) % MOD;
        }

        return (int) result;
    }
}



// TLE
// class Solution {
//   public static final int MOD = 1_000_000_007;
//     public int lengthAfterTransformations(String s, int t) {
//         HashMap<Integer,Long> freqMap = new HashMap<>();
//         for(int i = 0; i < s.length(); i++){
//             int index = s.charAt(i)-'a';
//             freqMap.put(index,freqMap.getOrDefault(index, 0L)+1);
//         }
//         for(int i = 0; i < t; i++){
//             HashMap<Integer,Long> curFreq = new HashMap<>();
//            for (int index = 0; index < 26; index++) {
//                 long count = freqMap.getOrDefault(index, 0L);
              
//                 if(index == 25){
//                     curFreq.put(0,curFreq.getOrDefault(0,0L)+ count % MOD);
//                     curFreq.put(1,curFreq.getOrDefault(1,0L)+ count % MOD);
//                 }else{
//                     curFreq.put(index+1, curFreq.getOrDefault(index+1, 0L)+ count % MOD);
                    
//                 }
//             }
//             freqMap = curFreq;
//         }
//         long res = 0;
//         for(long val: freqMap.values()){
//             res = (res + val) % MOD;
//         }
//         return (int) res;
//     }
// }
