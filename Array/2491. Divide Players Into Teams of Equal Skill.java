/**
 * Solution class for dividing players into two groups with equal total skills.
 */
class Solution {
    /**
     * Divide players into two groups with equal total skills and return the product of the skills of the players in each group.
     * 
     * @param skill an array of integers representing the skills of the players
     * @return the product of the skills of the players in each group, or -1 if it's not possible to divide the players into two groups with equal total skills
     */
    public long dividePlayers(int[] skill) {
        long result = 0;

        // base case: if there are only two players, return the product of their skills
        if (skill.length == 2) {
            return (skill[0] * skill[1]);
        }

        // sort the skills array in ascending order
        Arrays.sort(skill);

        int i = 0;
        int j = skill.length - 1;
        int halfgroup[] = new int[skill.length / 2];
        int halfgroupProduct[] = new int[skill.length / 2];

        int index = 0;
        int productIndex = 0;
        int resultIndex = 0;
        int indexSum = -1;

        // iterate through the skills array and divide the players into two groups
        while (i < j) {
            halfgroup[index] = skill[i] + skill[j];
            halfgroupProduct[productIndex] = skill[i] * skill[j];
            result += halfgroupProduct[resultIndex];

            // check if the sum of the skills in each group is equal
            if (index >= 1) {
                if (halfgroup[indexSum + 1] != halfgroup[indexSum]) {
                    return -1;
                }
            }

            index++;
            productIndex++;
            resultIndex++;
            indexSum++;
            i++;
            j--;
        }

        return result;
    }
}
