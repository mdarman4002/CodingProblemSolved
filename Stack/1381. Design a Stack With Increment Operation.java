/**
 * A custom implementation of a stack that supports push, pop, and increment operations.
 */
class CustomStack {
    /**
     * The underlying array to store the stack elements.
     */
    int stack[];
    
    /**
     * The array to store the increment operations.
     */
    int operations[];
    
    /**
     * The maximum capacity of the stack.
     */
    int capacity;
    
    /**
     * The current size of the stack.
     */
    int size;
    
    /**
     * The current index of the top element in the stack.
     */
    int index;
    
    /**
     * Initializes the custom stack with a given maximum size.
     * 
     * @param maxSize the maximum size of the stack
     */
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        operations = new int[maxSize];
        capacity = maxSize;
        size = 0;
        index = -1;
    }
    
    /**
     * Pushes an element onto the stack.
     * 
     * @param x the element to push
     */
    public void push(int x) {
        if (isFull()) {
            return;
        }
        index++;
        size++;
        stack[index] = x;
    }
    
    /**
     * Pops an element from the stack.
     * 
     * @return the popped element, or -1 if the stack is empty
     */
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int val = stack[index];
        val += operations[index];
        if (index > 0) {
            operations[index - 1] += operations[index];
        }
        operations[index] = 0;
        index--;
        size--;
        return val;
    }
    
    /**
     * Increments the top k elements of the stack by a given value.
     * 
     * @param k the number of elements to increment
     * @param val the increment value
     */
    public void increment(int k, int val) {
        if (isEmpty()) {
            return;
        }
        int num = Math.min(size, k);
        operations[num - 1] += val;
    }

    /**
     * Checks if the stack is full.
     * 
     * @return true if the stack is full, false otherwise
     */
    private boolean isFull() {
        return (size == capacity);
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise
     */
    private boolean isEmpty() {
        return (size == 0);
    }
}
