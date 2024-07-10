class Solution {
    public int minOperations(String[] logs) {
        int level = 0;
        for (String l : logs) {
            if (l.equals("../")) {
                if (level >= 1) {
                    level-= 1;
                }
            } else if (l.equals("./")) {
                continue;
            }
            else{
                level += 1;
            }
        }
        return level;
    }
}
