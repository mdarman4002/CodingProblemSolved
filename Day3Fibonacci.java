
public class Day3Fibonacci {
    public static int fib(int n) {
        if(n <= 1){
            return n;
        }
        else{
            return fib(n-1)+fib(n-2);
        }
    }
    public static int printFib(int num){
        int sum = 0;
        for(int i = 0; i< num; i++){
            sum += fib(i);
        }
        return sum;
    }
    public static void main(String args[]){
        int num = 5;
        System.out.println(printFib(num));

    }
}
