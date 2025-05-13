class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] ans;
        int n = digits.length;
        int[] freq = new int[10];
        for (int i : digits) freq[i]++;

        int[] last = new int[10];
        int[] middle = new int[10];
        int[] first = new int[10];
        int[] res = new int[900];
        int n1 = 0, n2 = 0, n3 = 0, size = 0;

        for (int i = 0; i < 10; i++) {
            if (freq[i] == 0) continue;
            if (i % 2 == 0) last[n3++] = i;
            if (i > 0) first[n1++] = i;
            middle[n2++] = i;
        }

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n3; k++) {
                    int a = first[i], b = middle[j], c = last[k];
                    int x = a * 100 + b * 10 + c;
                    if (a != b && b != c && a != c) {
                        res[size++] = x;
                    } else if ((a == b && b != c) || (a == c && a != b)) {
                        if (freq[a] > 1) res[size++] = x;
                    } else if (b == c && a != b) {
                        if (freq[b] > 1) res[size++] = x;
                    } else if (freq[a] > 2) {
                        res[size++] = x;
                    }
                }
            }
        }

        ans = new int[size];
        for (int i = 0; i < size; i++) ans[i] = res[i];
        return ans;
    }
}

// class Solution {
//     public int[] findEvenNumbers(int[] digits) {
//         int n = digits.length;
//         Set<Integer> set = new HashSet<>();
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 for (int k = 0; k < n; k++) {
//                     if (digits[k] % 2 == 0 && digits[i] != 0 && (i != j && j != k && k != i)) {

//                         int num = digits[i] * 100 + digits[j] * 10 + digits[k];

//                         set.add(num);

//                     }
//                 }
//             }
//         }
//         int res[] = new int[set.size()];
//         ArrayList<Integer> list = new ArrayList<>();
//         int index = 0;
//         for (int ele : set) {
//             list.add(ele);
//             // res[index++] = ele;
//         }
//         Collections.sort(list);
//         for (int ele : list) {
//             res[index++] = ele;
//         }
//         return res;
//     }
// }
