import java.util.Arrays;

public class CharIncFreq {

    public static void main(String[] args) {
        String str = "arrrman";
        int fre[] = new int[26];

        // Count the frequency of each character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = ch - 'a';
            fre[index]++;
        }

        // Create a 2D array to store characters and their frequencies
        char[][] charFre = new char[26][2];
        for (int i = 0; i < 26; i++) {
            charFre[i][0] = (char) (i + 97); // character
            charFre[i][1] = (char) (fre[i]); // frequency
        }

        // Sort the 2D array based on the frequency in descending order
        Arrays.sort(charFre, (a, b) -> (int)b[1] - (int)a[1]);
// Arrays.sort(arr, (a, b) -> b - a);
// Arrays.sort(arr, (a, b) -> b.length() - a.length()); for string
        // Print the characters in descending order of their frequencies
        for (int i = 0; i < 26; i++) {
            if (charFre[i][1] != 0) {
                for (int j = 0; j < (int)charFre[i][1]; j++) {
                    System.out.print(charFre[i][0]);
                }
            }
        }
    }
}
