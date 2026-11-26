
class Solution {
    public boolean canAliceWin(int n) {

        int stones = 10;
        int turn = 0;

        while (n >= stones) {
            n = n - stones;
            stones--;
            turn++;
        }

        if (turn % 2 == 0) {
            return false;
        }

        return true;
    }
}
