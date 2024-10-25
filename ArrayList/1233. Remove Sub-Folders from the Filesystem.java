import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * Removes subfolders from a list of folders.
     * 
     * @param folder An array of folder paths.
     * @return A list of folder paths with no subfolders.
     */
    public List<String> removeSubfolders(String[] folder) {
        // Sort the folder array to ensure subfolders come immediately after their parent folders.
        Arrays.sort(folder);

        // Initialize the result list and add the first folder.
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);

        // Iterate through the sorted folder array starting from the second folder.
        for (int i = 1; i < folder.length; i++) {
            // Create a string representing the last folder followed by a "/".
            String lastFolder = ans.get(ans.size() - 1) + "/";

            // If the current folder does not start with the last folder path, add it to the result.
            if (!folder[i].startsWith(lastFolder)) {
                ans.add(folder[i]);
            }
        }

        // Return the list of folders without subfolders.
        return ans;
    }
}
