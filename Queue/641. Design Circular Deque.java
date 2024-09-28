class MyCircularDeque {
    private int[] deque;
    private int head; // points to the front element
    private int tail; // points to the next empty slot after the last element
    private int count;
    private int capacity;

    public MyCircularDeque(int k) {
        // No need for a check since k is always positive
        deque = new int[k];
        head = 0; // head points to the front element
        tail = 0; // tail points to the next empty position
        count = 0;
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (count == capacity) {
            return false; // Deque is full
        }
        head = (head - 1 + capacity) % capacity; // Move head backward
        deque[head] = value; // Insert the value
        count++;
        return true;
    }

    public boolean insertLast(int value) {
        if (count == capacity) {
            return false; // Deque is full
        }
        deque[tail] = value; // Insert the value
        tail = (tail + 1) % capacity; // Move tail forward
        count++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false; // Deque is empty
        }
        head = (head + 1) % capacity; // Move head forward
        count--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false; // Deque is empty
        }
        tail = (tail - 1 + capacity) % capacity; // Move tail backward
        count--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1; // Deque is empty
        }
        return deque[head]; // Return the front element
    }

    public int getRear() {
        if (isEmpty()) {
            return -1; // Deque is empty
        }
        return deque[(tail - 1 + capacity) % capacity]; // Return the last element
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
