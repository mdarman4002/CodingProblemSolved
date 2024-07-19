class Solution {
    public int findKthPositive(int[] arr, int k) {
        int arrlen = arr.length;
        int max = arr[arrlen-1];
        int index = 0; int missing = 0;
        for(int i = 1; i <= max; i++){
            if(missing == k){
                return i - 1;
            }
            if(arr[index] == i){
                index += 1;
            }
            else{
                missing += 1;
            }
        }return arrlen + k;
    }
}
