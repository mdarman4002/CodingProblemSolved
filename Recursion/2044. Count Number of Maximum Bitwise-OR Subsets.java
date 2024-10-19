class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int target = 0;
        for (int ele : nums) {
            target |= ele;
        }

        return findTarget( nums,0 ,  target, 0);
    }
    public int  findTarget(int[] nums,int index,  int target, int cur){
        if(index == nums.length){
           return cur == target ? 1:0;
            
        }
        // cur |= nums[index];
        int includeCur = findTarget( nums,index+1,  target,  cur | nums[index]);
        int excludeCur = findTarget( nums,index+1,  target, cur);  
        return includeCur + excludeCur;

    }
}

