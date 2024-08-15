
class Sol {
    public static int search(int n, int arr[]) {
        // your code here
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = ans ^arr[i];
        }return ans;
    }
}
// 
The XOR operation has the following properties:
a ^ a = 0 (i.e., XORing a number with itself results in 0)
a ^ 0 = a (i.e., XORing a number with 0 results in the number itself)
a ^ b = b ^ a (i.e., XORing two numbers is commutative)

n = 5, arr[] = {1, 1, 2, 5, 5}

Here's how the XOR operation will work:

ans = 0
ans = ans ^ arr[0] = 0 ^ 1 = 1
ans = ans ^ arr[1] = 1 ^ 1 = 0 (cancel out the pair of 1s)
ans = ans ^ arr[2] = 0 ^ 2 = 2
ans = ans ^ arr[3] = 2 ^ 5 = 7
ans = ans ^ arr[4] = 7 ^ 5 = 2 (cancel out the pair of 5s)
