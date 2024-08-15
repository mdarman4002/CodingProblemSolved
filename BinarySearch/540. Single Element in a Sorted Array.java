class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        if(len== 1){
            return nums[0];
        }else if(nums[0] != nums[1]){
            return nums[0];
        }else if(nums[len-2] != nums[len-1]){
            return nums[len-1];
        }

        int start = 0; int end = len-1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]){
                return nums[mid];
            }else if(mid % 2 == 1){ // if mid is odd then 
                if(nums[mid] == nums[mid-1]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }

            }else if(mid % 2 == 0){ // if mid is even then
                if(nums[mid] == nums[mid+1]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        } return -1;
    }
}
