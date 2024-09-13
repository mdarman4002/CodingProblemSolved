class Solution {
    /**
     * This method takes an array and a set of queries as input, 
     * and returns an array of results where each result is the XOR of a subarray 
     * specified by the corresponding query.
     * 
     * @param arr The input array
     * @param queries A 2D array where each row represents a query, 
     *                and each query is a range [left, right] in the input array
     * @return An array of results where each result is the XOR of a subarray 
     *         specified by the corresponding query
     */ 
    public int[] xorQueries(int[] arr, int[][] queries) {
        // Initialize the result array with the same length as the number of queries
        int[] result = new int[queries.length];
        
        // Initialize an index to keep track of the current result
        int index = 0;
        
        // Iterate over each query
        for(int query[]: queries){
            // Extract the left and right boundaries of the query
            int left = query[0];
            int right = query[1];
            
            // Initialize the XOR result for this query
            int xor = arr[left];
            
            // Iterate over the subarray specified by the query
            for(int i = left+1; i <= right; i++){
                // XOR the current element with the result
                xor ^= arr[i];
            }
            
            // Store the result for this query
            result[index++] = xor;
        }
        
        // Return the array of results
        return result;
    }
}
