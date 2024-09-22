---------Memory lImit Exceeded----------- it's hard level question

class Solution {
    public int findKthNumber(int n, int k) {
        String[] arr = new String[n];
        for(int i = 0; i < n ; i++){
            arr[i] = String.valueOf(i+1);
        }
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                return a.compareTo(b);
            }
        });
        int output = Integer.parseInt(arr[k - 1]);
        return output;
    }
    
}

