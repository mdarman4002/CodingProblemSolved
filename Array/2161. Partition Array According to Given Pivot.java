class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;
        int[] res = new int[len];
        int index = 0;
        int pivotCount = 0;
       // ArrayList<Integer> pivotList = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(nums[i] < pivot){
                res[index++] = nums[i];
            }
            else if(nums[i] == pivot){
               // pivotList.add(pivot);
               pivotCount++;
            }
        }
        for(int i = 0; i < pivotCount; i++){
            res[index++] = pivot;
        }
        for(int i = 0; i < len; i++){
            if(nums[i] > pivot && index < len){
                res[index++] = nums[i];
            }
        }
        return res;
    }
}
-----------------------------------------------------------------

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n  = nums.length;
        int res[] = new int[n];
        int i = 0;
        int j = n-1;
      //  int pivotCount = 0;
        int startIndex = 0;
        int endIndex = n-1;
        while(i < n && j >= 0){
            // if(nums[i] == pivot){
            //     pivotCount++;
            // }
            if(nums[i] < pivot){
                res[startIndex++] = nums[i];
            }if(nums[j] > pivot){
                res[endIndex--] = nums[j];
            }
            i++;
            j--;
        }
        for(int pvt = startIndex; pvt <= endIndex; pvt++){
            res[startIndex++] = pivot;
        }
        return res;

    }
}
