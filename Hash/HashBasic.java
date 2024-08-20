//#endregion
/**
 * HashBasic
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class HashBasic {

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();

        //put
        map.put("India",100);
        map.put("Amererica", 45);
        map.put("china",125);
        map.put("Lanka",8);
        map.put("England",11);

        //get
        int indiaKey = map.get("India"); // 100
        System.out.println(indiaKey);

        //containsKey()
        boolean indiaValid = map.containsKey("India");
        System.out.println(indiaValid);

        boolean pakValid = map.containsKey("Pak");
        System.out.println(pakValid);

        //remove
        map.remove("china"); System.out.println(map.get("china")); // null

        // size()
        System.out.println(map.size());
        // isEmpty()
        System.out.println("isEmpty() "+map.isEmpty());
        System.out.println(map); // unordered
        // clear()
       // map.clear();
        System.out.println(map);
        System.out.println("isEmpty() "+map.isEmpty());

        // map.keySet()
        Set<String> set = map.keySet();
        System.out.println(set);
        for (String key : set) {
            System.out.println("key "+key);
        }
        System.out.println("hashcode: "+set.hashCode());
        //entrySet()
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        entrySet.forEach(entry -> {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key: "+ key + "|| value : "+value);
        });
System.out.println("--------- ---------- ----------");
        for(Map.Entry<String,Integer> EntrySet: map.entrySet()){
            String key = EntrySet.getKey();
            int value = EntrySet.getValue();
            System.out.println("key: "+ key + "|| value : "+value);

            System.out.println("hash key : "+ key.hashCode());
           
        }
    }
}
