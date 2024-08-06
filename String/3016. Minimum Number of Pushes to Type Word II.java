class Solution {
    public int minimumPushes(String word) {
        int[] frq = new int[26];
        for(char ch: word.toCharArray()){
            frq[ch-'a']++;
        }
        Arrays.sort(frq);
        int count = 0;
        int output = 0; 
        for(int i = 25; i >=0; i--){
            // int mul = 0;
            // if(count <8){
            //     mul = 1;
            // }else if(count <16){
            //     mul = 2;
            // }else if(count < 24){
            //     mul = 3;
            // }else{
            //     mul = 4;
            // }
            int val = frq[i] * (count / 8 + 1);
            output += val;
            count++;
        }return output;
    }
}


public class Solution {

    public int minimumPushes(String word) {
        // Create a frequency array to store the count of each character in the word
        int[] frq = new int[26];
        for (char ch : word.toCharArray()) {
            frq[ch - 'a']++; // increment the count for the corresponding character
        }
        
        // Sort the frequency array in descending order
        Arrays.sort(frq);
        
        // Initialize variables to keep track of the count and output
        int count = 0;
        int output = 0;
        
        // Iterate through the sorted frequency array
        for (int i = 25; i >= 0; i--) {
            // Calculate the number of pushes required for the current character
            int val = frq[i] * (count / 8 + 1);
            output += val; // add to the total output
            count++; // increment the count
        }
        
        return output; // return the minimum number of pushes required
    }
}
