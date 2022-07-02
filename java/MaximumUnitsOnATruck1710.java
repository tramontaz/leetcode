import java.util.Arrays;
import java.util.Comparator;

import static java.lang.String.format;

public class MaximumUnitsOnATruck1710 {

    private final static Solution SOLUTION = new Solution();

    public static void main(String[] args) {
        test(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4, 8);
        test(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10, 91);
    }

    private static void test(int[][] boxTypes, int truckSize, int expected) {
        int result = SOLUTION.maximumUnits(boxTypes, truckSize);
        if (result != expected) {
            throw new IllegalStateException(format("Test failed. Result: %d but expected: %d. Boxes: %s.", result, expected, Arrays.toString(boxTypes)));
        }
    }
}

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(arr -> arr[1]));
        int ans = 0;
        for (int i = boxTypes.length - 1; i >= 0 && truckSize > 0; i--) {
            int boxes = boxTypes[i][0];
            int unitsInBox = boxTypes[i][1];
            while (boxes > 0 && truckSize > 0) {
                truckSize--;
                boxes--;
                ans += unitsInBox;
            }
        }

        return ans;
    }
}
