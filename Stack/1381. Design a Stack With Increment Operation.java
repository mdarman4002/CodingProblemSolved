/**
 * CustomStack class represents a stack data structure with a fixed maximum size.
 */
class CustomStack {
    /**
     * The underlying array to store stack elements.
     */
    int stack[];
    /**
     * The maximum size of the stack.
     */
    int size;
    /**
     * The current index of the stack, pointing to the next available position.
     */
    int index;

    /**
     * Constructor to initialize the CustomStack with a given maximum size.
     * 
     * @param maxSize The maximum size of the stack.
     */
    public CustomStack(int maxSize) {
        size = maxSize;
        stack = new int[size];
        index = 0;
    }

    /**
     * Pushes an element onto the stack if it's not full.
     * 
     * @param x The element to be pushed onto the stack.
     */
    public void push(int x) {
        if (isFull()) {
            return;
        }
        stack[index] = x;
        index++;
    }

    /**
     * Pops an element from the stack if it's not empty.
     * 
     * @return The popped element, or -1 if the stack is empty.
     */
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        index--;
        int poped = stack[index];
        stack[index] = 0;
        return poped;
    }

    /**
     * Increments elements up to a certain index by a given value.
     * 
     * @param k The index up to which elements should be incremented.
     * @param val The value to increment the elements by.
     */
    public void increment(int k, int val) {
        if (k >= size) {
            for (int i = 0; i < size; i++) {
                stack[i] = stack[i] + val;
            }
        } else {
            for (int i = 0; i < k; i++) {
                stack[i] = stack[i] + val;
            }
        }
    }

    /**
     * Checks if the stack is full.
     * 
     * @return True if the stack is full, false otherwise.
     */
    public boolean isFull() {
        return size == index;
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return index == 0;
    }
}
