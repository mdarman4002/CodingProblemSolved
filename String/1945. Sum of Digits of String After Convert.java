class Solution {
    /**
     * Main method to test the getLucky method
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(getLucky("iiii", 1));
    }

    /**
     * Calculates the "lucky number" based on a given string and an integer k
     * 
     * @param s the input string
     * @param k the number of iterations
     * @return the calculated lucky number
     */
    public static int getLucky(String s, int k) {
        // Initialize an empty string to store the digit values
        String digit = "";
        
        // Convert each character in the input string to its corresponding digit value (a=1, b=2, ..., z=26)
        for (int i = 0; i < s.length(); i++) {
            digit += s.charAt(i) - 'a' + 1;
        }
        
        // Print the digit string
        System.out.println(digit);
        
        // Initialize the sum to 0
        int sum = 0;
        
        // Calculate the initial sum by adding up the digit values
        for (int i = 0; i < digit.length(); i++) {
            sum = sum + digit.charAt(i) - '0';
        }
        
        // If k is 1, return the initial sum
        if (k == 1) {
            return sum;
        }
        
        // Otherwise, iterate k-1 times to calculate the lucky number
        while (k > 1) {
            // Convert the sum to a string
            String str = String.valueOf(sum);
            
            // Reset the sum to 0
            sum = 0;
            
            // Calculate the new sum by adding up the digit values of the previous sum
            for (int i = 0; i < str.length(); i++) {
                sum = sum + str.charAt(i) - '0';
            }
            
            // Decrement k
            k--;
        }
        
        // Return the final lucky number
        return sum;
    }
}
