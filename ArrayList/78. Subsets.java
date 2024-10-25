


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

//                 For num = 0 (binary 000): list = []
// For num = 1 (binary 001): list = [1]
// For num = 2 (binary 010): list = [2]
// For num = 3 (binary 011): list = [1, 2]
// For num = 4 (binary 100): list = [3]
// For num = 5 (binary 101): list = [1, 3]
// For num = 6 (binary 110): list = [2, 3]
// For num = 7 (binary 111): list = [1, 2, 3]
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
