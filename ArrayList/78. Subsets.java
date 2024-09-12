


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int subset = 1 << len;
        List<List<Integer>> result = new ArrayList<>();
        for(int num = 0; num < subset; num++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < len; j++){
                if((num & (1 << j)) != 0 ){
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }return result;
    }
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        findSubSets(nums, 0, new ArrayList<>());
        return result;
    }
    public void findSubSets(int nums[], int index, ArrayList<Integer> list){
        if(index == nums.length){
            result.add(new ArrayList<>(list));
            return;
            
        }
        list.add(nums[index]);
        findSubSets(nums, index+1, list);
        list.remove(list.size()-1);
        findSubSets(nums, index+1, list);

    }
}
