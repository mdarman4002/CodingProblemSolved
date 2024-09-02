class Solution {
    public int chalkReplacer(int[] chalk, int k) {

        long chalksum = 0;
        for(int Chalk: chalk){
            chalksum += Chalk;
        }
        int rem =(int) (k % chalksum);
        if(rem == 0){
            return 0;
        }
        for(int i = 0; i < chalk.length; i++){
            if(rem < chalk[i]){
                return i;
            }
            rem -= chalk[i];
        }return -1;
    }
}
//     public int chalkReplacer(int[] chalk, int k) {
//         // while(k >= 0){
//         //     for(int i = 0; i < chalk.length; i++){
//         //         if(k >= chalk[i]){
//         //             k -= chalk[i];
//         //         }else{
//         //             return i;
//         //         }
                
//         //     }
//         // }
//         // return -1; // this code is running but taking more time
//         return getReplacer(chalk , k);
//     }
//     // public int  getReplacer(int[] chalk, int k){
//     //     int remainchalk = 0;
//     //     for(int i = 0; i < chalk.length; i++){
//     //         if(k >= chalk[i]){
//     //             k -= chalk[i];
//     //             remainchalk = k;
//     //         }else{
//     //             return i;
//     //         }
//     //     }
//     //     return getReplacer(chalk, remainchalk);
//     // } // stackoverflow error
// }
