
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increasing = increasing(nums);
        int decreasing = decreasing(nums);
        return Math.max(increasing, decreasing);
    }
    public int increasing(int nums[]){
        int count = 1;
        int max = 1;
      
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                count++;
                
                max = Math.max(count, max);
            }
            else{
                count  = 1;
            }
           

        }
        return max;

    }
    public int decreasing(int nums[]){
        int count= 1;
        int max = 1;
        
        for(int i = 1; i < nums.length; i++){
             if(nums[i] < nums[i-1]){
                count++;
               
                max = Math.max(count, max);
            }
            else{ 
                count = 1;
            }
           
        }
        return max;
    }
}
