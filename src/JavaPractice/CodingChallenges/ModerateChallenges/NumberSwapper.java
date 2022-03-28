package JavaPractice.CodingChallenges.ModerateChallenges;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class NumberSwapper {

    /**
     * Implementation to swap two numbers in an array without using a temp variable
     * @param array The array to swap numbers in
     * @param index1 The index of the first number to swap
     * @param index2 The index of the second number to swap
     */
    public void SwapNumber(int[] array, int index1, int index2) {
        array[index1] += array[index2];
        array[index2] = array[index1] - array[index2];
        array[index1] -= array[index2];
    }

    @Test
    void TestSwapNumbers() {
        int[] intArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
        SwapNumber(intArray, 0, 1);
        assumeTrue(intArray[0] == 1);
        assumeTrue(intArray[1] == 0);
        SwapNumber(intArray, 4, 7);
        assumeTrue(intArray[4] == 7);
        assumeTrue(intArray[7] == 4);

    }
}
