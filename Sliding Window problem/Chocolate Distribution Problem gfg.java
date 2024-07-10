class Solution {
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        // your code here
        Collections.sort(a);
        long min = a.get(0);
        long max = a.get(0);
        long diff = Long.MAX_VALUE;
        
        for(int i = 0; i <= n-m; i++){
            min = a.get(i);
            max = a.get(m+i-1);
            diff = Math.min(diff, max - min);
        }
        
        return diff;
    }
}
