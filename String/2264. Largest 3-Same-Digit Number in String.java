class Solution {
    public String largestGoodInteger(String num) {
        String[] check = {"999","888","777","666","555","444","333","222","111","000"};
        for(int i = 0; i <= 9; i++){
            String re = check[i];
            if(num.contains(re)){
                return re;
            }
        }
        return "";
    }
}

class Solution {
    public String largestGoodInteger(String num) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        findLargeNum(num, maxHeap);
        maxHeap.add(-1);

        StringBuilder sb = new StringBuilder("");
        if (maxHeap.peek() != -1) {
            int max = maxHeap.peek();
            for (int i = 0; i < 3; i++) {
                sb.append(max);
            }
        }
        return sb.toString();

    }

    public PriorityQueue<Integer> findLargeNum(String num, PriorityQueue<Integer> maxHeap) {
        int n = num.length();
        for (int i = 0; i < n - 2; i++) {
            char ch = num.charAt(i);

            if (ch == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                maxHeap.add(ch - '0');
            }

        }
        return maxHeap;
    }
}


