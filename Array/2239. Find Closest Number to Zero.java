class Solution {
    public int findClosestNumber(int[] nums) {
        int result = Integer.MAX_VALUE;
        for(int ele: nums){
            if(Math.abs(ele) < Math.abs(result) || ele == Math.abs(result) && ele > 0)
                result = ele;
            
        }
        return result;
        // PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        // int len = nums.length;
        // boolean hasPositive = false;
        // for(int i = 0; i < len; i++){
        //    if(nums[i] >= 0){
        //      pq.add(nums[i]);
        //      hasPositive = true;
        //    }
        // }
        // if(hasPositive){
        //     return pq.peek();
        // } else {
        //     // If there are no positive numbers, return the closest number to 0
        //     int closest = nums[0];
        //     for(int i = 1; i < len; i++){
        //         if(Math.abs(nums[i]) < Math.abs(closest)){
        //             closest = nums[i];
        //         }
        //     }
        //     return closest;
        // }
    }
}
