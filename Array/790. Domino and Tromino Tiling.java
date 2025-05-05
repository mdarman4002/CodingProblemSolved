class Solution {
    public int numTilings(int n) {
       // int mod = 1000000007; 
         final int mod= 1000_000_007;
        long arr[] = new long[1000];
        arr[0] = 0; 
        arr[1] = 1; 
        arr[2] = 2; 
        arr[3] = 5; 
        
        
        for(int i = 4; i <= n; i++){
            arr[i] = (2 * arr[i - 1] + arr[i - 3]) % mod; 
        }
        
        return (int)arr[n]; 
    }
}
