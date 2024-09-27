/**
 * MyCalendarTwo class represents a calendar that allows booking of events with overlapping intervals.
 */
class MyCalendarTwo {
    /**
     * A TreeMap to store the bookings, where the key is the time and the value is the count of bookings at that time.
     */
    private Map<Integer, Integer> map;
    
    /**
     * The maximum allowed overlap of bookings.
     */
    private int maxOverlap;

    /**
     * Constructor to initialize the calendar.
     */
    public MyCalendarTwo() {
        map = new TreeMap<>();
        maxOverlap = 2;
    }

    /**
     * Book an event with the given start and end times.
     * 
     * @param start the start time of the event
     * @param end the end time of the event
     * @return true if the event is booked successfully, false otherwise
     */
    public boolean book(int start, int end) {
        // Increment the count at the start time
        map.put(start, map.getOrDefault(start, 0) + 1);
        
        // Decrement the count at the end time
        map.put(end, map.getOrDefault(end, 0) - 1);

        int countOverlap = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // Calculate the overlap count by summing up the values in the map
            countOverlap += entry.getValue();

            // Check if the overlap count exceeds the maximum allowed overlap
            if (countOverlap > maxOverlap) {
                // Revert the changes made to the map
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                if (map.get(start) == 0) {
                    map.remove(start);
                }
                if (map.get(end) == 0) {
                    map.remove(end);
                }
                return false;
            }
        }
        return true;
    }
}
