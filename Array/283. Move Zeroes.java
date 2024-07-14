class Solution {
    // public static void main(String[] args) {
    //     int[] array = {0,1,0,3,12};
    //     moveZeroes(array);
    // }
    public  void moveZeroes(int[] nums) {
        int zero = 0;
        int index = 0;
        // if(nums.length == 0){
        //     System.out.println(0);
        // }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
               nums[index++] = nums[i];  
            }
            else{
                zero +=1 ;
            }
        }
        // while(index < nums.length){
        //     nums[index++] = 0;
        // }
        for(int j = nums.length-zero; j < nums.length; j++){
            nums[j] = 0;
        }
        // for(int out: nums){
        //     System.out.print(out + " ");
        // }
    }
}
