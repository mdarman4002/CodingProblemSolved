// O(k) time will take
// class ProductOfNumbers {
//     private ArrayList<Integer> list;

//     public ProductOfNumbers() {
//          list = new ArrayList<>();
//     }
    
//     public void add(int num) {
//         list.add(num);
//     }
    
//     public int getProduct(int k) {
//         int size = list.size();
//         int res = 1;
//         for(int i = size-1; i >= size - k; i--){
//             res *= list.get(i);
//         }
//         return res;
//     }
// }




import java.util.ArrayList;

/**
 * The ProductOfNumbers class provides a way to maintain a list of numbers
 * and efficiently calculate the product of the last k numbers added to the list.
 * 
 * The class has two implementations:
 * 1. An O(k) solution that calculates the product by iterating through the last k elements.
 * 2. An O(1) solution that maintains a cumulative product and handles zeros appropriately.
 */
class ProductOfNumbers {
    private ArrayList<Integer> list;

    /**
     * Initializes an empty ProductOfNumbers object.
     */
    public ProductOfNumbers() {
        list = new ArrayList<>();
    }

    /**
     * Adds a number to the list. If the number is zero, the list is cleared.
     * 
     * @param num The number to be added to the list.
     * 
     * Time Complexity: O(1) on average, O(n) in the worst case when clearing the list.
     */
    public void add(int num) {
        if (num == 0) {
            list.clear(); // Clear the list if the number is zero
            return;
        }
        // Get the last product or 1 if the list is empty
        int prev = (list.size() == 0) ? 1 : list.get(list.size() - 1);
        // Add the cumulative product to the list
        list.add(prev * num);
    }

    /**
     * Returns the product of the last k numbers added to the list.
     * If there are fewer than k numbers, returns 0.
     * 
     * @param k The number of last elements to consider for the product.
     * @return The product of the last k numbers, or 0 if there are fewer than k numbers.
     * 
     * Time Complexity: O(1)
     */
    public int getProduct(int k) {
        int size = list.size();
        if (size < k) {
            return 0; // Not enough elements
        } else if (size == k) {
            return list.get(size - 1); // Return the product of all elements
        } else {
            // Return the product of the last k elements
            return (list.get(size - 1) / list.get(size - 1 - k));
        }
    }
}

/**
 * Example usage of the ProductOfNumbers class:
 * 
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num); // Adds a number to the list
 * int param_2 = obj.getProduct(k); // Gets the product of the last k numbers
 */
