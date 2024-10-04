Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

Example 1:

Input: arr1 = [2,3,1,3, 2,4, 6, 7,9, 2, 19], arr2 = [2,1,4, 3, 9, 6]
Output: [2,2,2,1,4, 3, 3, 9, 6, 7, 19]

Example 2:

Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]

Constraints:

. 1 <= arr1.length, arr2.length <= 1000

. 0 <= arr1[i], arr2[i] <= 1000

. All the elements of arr2 are distinct.

. Each arr2[i] is in arr1.



import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int num1[] = { 2,3,1,3,2,4,6,7,9,2,19};
        int num2[] = { 2,1,4,3,9,6 };
        sortednum2(num1, num2);
    }

    public static void sortednum2(int nums1[], int[] nums2){
	  HashMap<Integer,Integer> map = new HashMap<>();
	  for(int ele: nums1){
	      map.put(ele, map.getOrDefault(ele, 0)+1);
	  }
	  ArrayList<Integer> list = new ArrayList<>();
	  for(int ele: nums2){
	      list.add(ele);
	      int count = map.get(ele);
	     if(map.containsKey(ele)){
	         for(int i = 1; i <count; i++){
	         list.add(ele);
	     }
	     }
	     
	     map.remove(ele);
	  }
	  ArrayList<Integer> maplist = new ArrayList<>();
	  for(Map.Entry<Integer,Integer> entry: map.entrySet()){
	      int value = entry.getValue();
	      int key = entry.getKey();
	      for(int i = 1; i <= value; i++){
	          maplist.add(key);
	      }
	  }
	  Collections.sort(maplist);
	  for(int ele: maplist){
	      list.add(ele);
	  }
	  System.out.print(list);
	    
	}
}
