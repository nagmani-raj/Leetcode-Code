public class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, int[]> occupiedFamilySeats = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int col = reservedSeat[1];
            if (col == 1 || col == 10) {
                continue;
            }
            int[] rowFamilySeats = occupiedFamilySeats.getOrDefault(row, new int[3]);
            if (col == 2 || col == 3) {
                rowFamilySeats[0] = 1;
                occupiedFamilySeats.put(row, rowFamilySeats);
            }
            if (col == 8 || col == 9) {
                rowFamilySeats[2] = 1;
                occupiedFamilySeats.put(row, rowFamilySeats);
            }
            if (col == 4 || col == 5) {
                rowFamilySeats[0] = 1;
                rowFamilySeats[1] = 1;
                occupiedFamilySeats.put(row, rowFamilySeats);
            }
            if (col == 6 || col == 7) {
                rowFamilySeats[1] = 1;
                rowFamilySeats[2] = 1;
                occupiedFamilySeats.put(row, rowFamilySeats);
            }
        }
        int count = n * 2 - 2 * occupiedFamilySeats.size();
        for (int[] familySeats : occupiedFamilySeats.values()) {
            if (familySeats[0] == 0) {
                count++;
            }
            if (familySeats[2] == 0) {
                count++;
            }
            if (familySeats[0] != 0 && familySeats[2] != 0 && familySeats[1] == 0) {
                count++;
            }
        }
        return count;
    }
}
