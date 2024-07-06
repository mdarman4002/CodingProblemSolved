class Solution {
    public int passThePillow(int n, int time) {
        if(time < n){
            return time+1;
        }
        int totalround = time / (n-1);
        boolean direction = totalround % 2 != 0;
        if(direction){
            return n - (time % (n-1));
        }else{
            return time % (n-1) + 1;
        }
    }
}

// documentaion

class Solution {
    public int passThePillow(int n, int time) {
        // If time is less than n, the pillow is still in the first round
        if(time < n){
            return time+1;
        }
        
        // Calculate the total number of rounds
        int totalround = time / (n-1);
        
        // Check if the pillow is moving in the reverse direction
        boolean direction = totalround % 2 != 0;
        
        // If the pillow is moving in the reverse direction
        if(direction){
            // Calculate the position of the pillow
            return n - (time % (n-1));
        }else{
            // If the pillow is moving in the forward direction
            // Calculate the position of the pillow
            return time % (n-1) + 1;
        }
    }
}
