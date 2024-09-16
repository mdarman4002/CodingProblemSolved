/**
 * Solution class to find the minimum time difference between two time points.
 */
public class Solution {
    /**
     * Main method to find the minimum time difference.
     * 
     * @param timePoints List of time points in "HH:mm" format.
     * @return The minimum time difference in minutes.
     */
    public int findMinDifference(List<String> timePoints) {
        int result = findMin(timePoints);
        return result;
    }

    /**
     * Helper method to find the minimum time difference.
     * 
     * @param timePoints List of time points in "HH:mm" format.
     * @return The minimum time difference in minutes.
     */
    public int findMin(List<String> timePoints) {
        /**
         * Convert time points to minutes and store in a list.
         */
        ArrayList<Integer> timeInMinuteList = new ArrayList<>();
        for (String time : timePoints) {
            String[] hoursMinute = time.split(":");
            int hours = Integer.parseInt(hoursMinute[0]);
            int minute = Integer.parseInt(hoursMinute[1]);
            int totalTimeInMinute = 0;
            if (hours == 0) {
                totalTimeInMinute = minute;
            } else {
                totalTimeInMinute = (hours * 60) + minute;
            }
            timeInMinuteList.add(totalTimeInMinute);
        }

        /**
         * Sort the list of time points in ascending order.
         */
        Collections.sort(timeInMinuteList);

        /**
         * Initialize the minimum time difference to maximum possible value.
         */
        int Min = Integer.MAX_VALUE;

        /**
         * Calculate the minimum time difference considering the wrap-around case.
         */
        Min = Math.min(Min, Math.abs(timeInMinuteList.get(0) + 24 * 60 - timeInMinuteList.get(timeInMinuteList.size() - 1)));

        /**
         * Calculate the minimum time difference for adjacent time points.
         */
        for (int i = 0; i < timeInMinuteList.size() - 1; i++) {
            Min = Math.min(Min, Math.abs(timeInMinuteList.get(i) - timeInMinuteList.get(i + 1)));
        }

        return Min;
    }
}
