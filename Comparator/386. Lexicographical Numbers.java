/**
 * Solution class for generating lexical order of integers up to n.
 */
class Solution {
    /**
     * Generates the lexical order of integers up to n.
     * 
     * @param n The upper limit of the lexical order.
     * @return A list of integers in lexical order.
     */
    public List<Integer> lexicalOrder(int n) {
        // Initialize an empty list to store the result
        ArrayList<Integer> list = new ArrayList<>();
        
        // Create an array of strings to store the numbers from 1 to n as strings
        String[] arr = new String[n];
        
        // Convert the numbers from 1 to n to strings and store them in the array
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(i + 1);
        }
        
        // Sort the array of strings in lexicographical order
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                // Use the default string comparison to sort the strings
                return a.compareTo(b);
            }
        });
        
        // Convert the sorted strings back to integers and add them to the list
        for (int i = 0; i < n; i++) {
            int ele = Integer.parseInt(arr[i]);
            list.add(ele);
        }
        
        // Return the list of integers in lexical order
        return list;
    }
}
