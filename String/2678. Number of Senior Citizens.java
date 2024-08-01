class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String str: details){
            int tenthDigit = str.charAt(11) - '0';
            int onesDigit = str.charAt(12) - '0';

            int age = tenthDigit * 10 + onesDigit;
            // String sub = str.substring(11,13);
            // int age = Integer.parseInt(sub);
            if(age > 60){
                count += 1;
            }
        }return count;
    }
}
