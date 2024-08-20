import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Demonstrates the difference between TreeMap and LinkedHashMap.
 */
public class LinkedTreeMap {
    public static void main(String[] args) {
        /**
         * Create a TreeMap, which is a sorted map that orders its entries by key.
         * The put operation takes O(log n) time because TreeMap uses a balanced binary search tree.
         */
        TreeMap<String, Integer> tm = new TreeMap<>();

        tm.put("India", 100); // India will be placed in the middle of the sorted order
        tm.put("Amererica", 45); // America will be placed before India in the sorted order
        tm.put("Afgan", 45); // Afgan will be placed before America in the sorted order
        tm.put("china", 125); // China will be placed after India in the sorted order
        tm.put("Lanka", 8); // Lanka will be placed at the beginning of the sorted order
        tm.put("England", 11); // England will be placed after Lanka in the sorted order

        /**
         * Create a LinkedHashMap, which is a hash map that preserves the order of insertion.
         * The put operation takes O(1) time because LinkedHashMap uses a hash table.
         */
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 100);
        lhm.put("Amererica", 45);
        lhm.put("Afgan", 45);
        lhm.put("china", 125);
        lhm.put("Lanka", 8);
        lhm.put("England", 11);

        /**
         * Print the contents of the TreeMap and LinkedHashMap.
         * The TreeMap will print the entries in sorted order by key, while the LinkedHashMap will print the entries in the order of insertion.
         */
        System.out.println("TreeMap: " + tm);
        System.out.println("LinkedHashMap: " + lhm);
    }
}
