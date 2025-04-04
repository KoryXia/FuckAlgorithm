/*
 * @lc app=leetcode id=860 lang=java
 *
 * [860] Lemonade Change
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }

            if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                ten++;
                five--;
            }

            if (bill == 20) {
                if (five >= 1 && ten >= 1) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }

            }
        }
        return true;
    }
}
// @lc code=end

