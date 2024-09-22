
---------------- Again Memory Limit Exceeded ------------it's hard level quesiton

class Solution {
    public int findKthNumber(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            dfs(i, n, list,k, 0);
        }
        return list.get(k-1);
    }
    public void dfs(int cur, int target, ArrayList<Integer> list, int k, int curK){
       
        if(curK > k){
            return;
        }
        list.add(cur);
        for(int digit = 0 ; digit <= 9; digit++){

            if(curK > k || cur * 10  + digit > target){
                break;
            }
            dfs(cur * 10 + digit, target, list, k, curK++);
        }
    }

}
