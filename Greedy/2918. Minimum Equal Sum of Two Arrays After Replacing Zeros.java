class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        long count1 = 0, count2 = 0;
        for(int num : nums1){
            count1 += num == 0 ? 1:0;
            sum1 += num == 0 ? 1 : num;
        }
        for(int num: nums2){
            sum2 += num == 0 ? 1: num;
            count2 += num == 0 ? 1: 0;
        }
        if((count1 == 0 && sum1 < sum2) || (count2 == 0 && sum1 > sum2)){
            return -1;
        }
        return Math.max(sum1, sum2);
    }
}

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        boolean hasZero1 = false, hasZero2 = false;

        for (int num : nums1) {
            sum1 += (num == 0) ? 1 : num;
            hasZero1 = (num == 0) ? true : hasZero1;
        }

        for (int num : nums2) {
            sum2 += (num == 0) ? 1 : num;
            hasZero2 = (num == 0) ? true : hasZero2;
        }

        // Using ternary for final condition and return
        return ((sum1 < sum2 && !hasZero1) || (sum2 < sum1 && !hasZero2)) ? -1 : Math.min(sum1, sum2);
    }
}


class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        boolean hasZero1 = false, hasZero2 = false;

        for (int num : nums1) {
            if (num == 0) {
                hasZero1 = true;
                sum1 += 1;
            } else {
                sum1 += num;
            }
        }

        for (int num : nums2) {
            if (num == 0) {
                hasZero2 = true;
                sum2 += 1;
            } else {
                sum2 += num;
            }
        }

        // If one sum is smaller but its array has no zero, return -1
        if ((sum1 < sum2 && !hasZero1) || (sum2 < sum1 && !hasZero2)) {
            return -1;
        }

        // Return the minimum sum
        return Math.max(sum1, sum2);
    }
}


