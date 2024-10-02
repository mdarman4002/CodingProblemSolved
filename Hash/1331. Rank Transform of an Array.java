class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int ele: arr){
            map.put(ele,ele);
        }
        
        LinkedHashMap<Integer,Integer> linkmap = new LinkedHashMap<>();
        int index = 1;
        for(int key: map.keySet()){
           if(!linkmap.containsKey(key)){
              linkmap.put(key,index++);
           }else{
            linkmap.put(key, map.get(key));
           }
        }
        int[] result = new int[arr.length];
        int ind = 0;
        for(int ele: arr){
            result[ind++] = linkmap.get(ele);
        }
        return result;

    }
}


-----------------------------------------------------------------------------

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
      
        int[] sortedarr = new int[arr.length];
        int index = 0;
        for(int ele: arr){
            sortedarr[index++] = ele;
        }
        Arrays.sort(sortedarr);

        LinkedHashMap<Integer,Integer> linkmap = new LinkedHashMap<>();
        int ind = 1;

        for(int ele: sortedarr){
            if(!linkmap.containsKey(ele)){
            linkmap.put(ele,ind++);
            }else{
                linkmap.put(ele, linkmap.get(ele));
            }
        }
        int result[] = new int[arr.length];
        int indexx = 0;
        for(int key: arr){
            result[indexx++] = linkmap.get(key);
        }
        return result;
    }
}
