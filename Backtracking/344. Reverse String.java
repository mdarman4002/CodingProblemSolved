class Solution {
    public void reverseString(char[] s) {
        int start = 0; int end = s.length - 1;
       
        recur(s,start);
      

    }
    public void recur(char[] s, int start){
        if(start == s.length/2){
            return;
        }
        recur(s, start+1);
        swap(s, start, s.length- start-1);
    }
     public void swap(char[] s, int start, int end){
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
     }
}
