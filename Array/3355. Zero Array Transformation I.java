// TLE
// class Solution {
//     public boolean isZeroArray(int[] nums, int[][] queries) {
//         int queryRow = queries.length;
//         for(int row[]: queries){
//             int start = row[0];
//             int end = row[1];
//             for(int i = start; i <= end; i++){
//                 if(nums[i] > 0){
//                     nums[i]--;
//                 }
//             }
//         }
//         for(int ele: nums){
//             if(ele != 0)return false;
//         }
//         return true;
        
//     }
// }


// class Solution {
//     public boolean isZeroArray(int[] nums, int[][] queries) {
//         int n = nums.length;
//         // finding differnece
//         int[] diff = new int[n];
//         for(int query[]: queries){
//             int start = query[0];
//             int end = query[1];
//             int x = 1;
//             diff[start] += x;
//             if(end + 1 < n){
//                 diff[end+1] -= x;
//             }
//         }
//         // comulitive sum;
//         int[] res = new int[n];
//         int cumSum = 0;
//         for(int i = 0; i < n; i++){
//             cumSum += diff[i];
//             res[i] = cumSum;
//             if(res[i] < nums[i])return false;
//         }
//         // check res[i] < nums
//         // for(int i = 0; i < n; i++){
//         //     if(res[i] < nums[i]){
//         //         return false;
//         //     }
//         // }
//         return true;
//     }
// }




class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n+1];
        for(int query[]: queries){
            int left = query[0];
            int right = query[1];
            diff[left]--;
            diff[right+1]++;
        }
        int sum = 0;
        int diffSum = 0;
        for(int i = 0; i < n; i++){
            diffSum += diff[i];
            sum  = diffSum + nums[i];
            if(sum > 0)return false;
        }
        return true;
    }
}
