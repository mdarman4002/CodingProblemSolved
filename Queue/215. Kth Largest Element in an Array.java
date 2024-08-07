class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        //     for(int i = 0; i < nums.length; i++){
        //         if(pq.size() < k){
        //             pq.add(nums[i]);
        //         }else if(pq.peek() < nums[i]){
        //             pq.remove();
        //             pq.add(nums[i]);

        //         }
        //     }
        //     return pq.peek();
           
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        for(int i = 0; i < k-1; i++){
            pq.remove();
        }return pq.peek();
    }
}
