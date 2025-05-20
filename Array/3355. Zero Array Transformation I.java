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


class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;

        // Step 1: Make difference array using queries
        int[] diff = new int[n];
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int x = 1;

            diff[start] += x;
            if (end + 1 < n) {
                diff[end + 1] -= x;
            }
        }

        // Step 2: Compute cumulative effect on each index
        int[] result = new int[n];
        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += diff[i];
            result[i] = cumSum;
        }

        // Step 3: Check if each value can reach 0
        for (int i = 0; i < n; i++) {
            if (result[i] < nums[i]) {
                return false; // nums[i] won't become 0
            }
        }

        return true;
    }
}
