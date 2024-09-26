/**
 * MyCalendar class represents a calendar system that allows booking of events.
 */
public class MyCalendar {
    /**
     * A TreeMap to store the booked events, where the key is the start time and the value is the end time.
     */
    TreeMap<Integer, Integer> map;

    /**
     * Constructor to initialize the calendar.
     */
    public MyCalendar() {
        map = new TreeMap<>();    
    }
    
    /**
     * Books an event on the calendar.
     * 
     * @param start the start time of the event
     * @param end the end time of the event
     * @return true if the event is successfully booked, false otherwise
     */
    public boolean book(int start, int end) {
        /**
         * Find the previous event that ends before the current event starts.
         */
        Integer prev = map.lowerKey(end);
        
        /**
         * Check if the current event conflicts with the previous event.
         * If the current event starts before the previous event ends, return false.
         */
        if(prev != null && start <= map.get(prev)-1){
            return false;
        }       
        
        /**
         * Book the event by adding it to the TreeMap.
         */
        map.put(start, end);
        return true;
    }
}

/**
 * Example usage:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
