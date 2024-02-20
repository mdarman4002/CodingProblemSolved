// class Day2PowerOfTwo {
//     public boolean isPowerOfTwo(int n) {
//         double pot = 
        
//     }
//     public static void main(String args[]){
//         System.out.println(isPowerOfTwo());
//     }
// }

public class Day2PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        else{
            boolean  b = (n & (n-1)) == 0;
            return b;
        }
        
    }
    public static void main(String args[]){
        int n = 16;
        System.out.println(isPowerOfTwo(n));
    }
}
