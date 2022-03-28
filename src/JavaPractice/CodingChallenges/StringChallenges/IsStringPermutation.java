package JavaPractice.CodingChallenges.StringChallenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.HashMap;


public class IsStringPermutation {

    /**
     * Method to determine whether a string is a permutation of another using a map as a record of characters
     *
     * @param string1 First String to compare
     * @param string2 Second String to compare
     * @return true If strings are permutations of each other
     * Time Complexity:
     *      Best Case: O(1)
     *      Worst Case O(n)
     *      Average Case O(n)
     *
     * Space Complexity: O(n)
     *  Input Space = O(n)
     *  Auxiliary Space
     *      Best Case: O(n)
     *      Worst Case O(n)
     *      Average Case O(n)
     */
    boolean IsPermutation(String string1, String string2) {
        // Time Complexity = 0(1)
        // Space Complexity = O(1)
        if (string1.length() != string2.length()) {
            return false;
        }

        // Time Complexity = 0(1)
        // Space Complexity = O(1)
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

        // Time Complexity = 0(n)
        // Space Complexity = O(n)  toCharArray generates a new array with size n
        for (var character : string1.toCharArray()) {
            hashMap.merge(character, 1, Integer::sum);
        }

        // Time Complexity = 0(n)
        // Space Complexity = O(n)  toCharArray generates a new array with size n
        for (var character : string2.toCharArray()) {
            hashMap.merge(character, -1, Integer::sum);
        }

        // Time Complexity = 0(n)
        // Space Complexity = O(n)  HashMap.values() generates a new array with size n
        for (var value : hashMap.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to determine whether a string is a permutation of another using an integer array as a record of characters
     * Assumes that only 256 possible chars
     *
     * @param string1 First String to compare
     * @param string2 Second String to compare
     * @return true If strings are permutations of each other
     * Time Complexity:
     *      Best Case: O(1)
     *      Worst Case O(n)
     *      Average Case O(n)
     *
     * Space Complexity: O(n)
     *  Input Space = O(n)
     *  Auxiliary Space
     *      Best Case: O(n)
     *      Worst Case O(n)
     *      Average Case O(n)
     */

    boolean IsStringPermutationUsingInt(String string1, String string2) {

        // Time Complexity = 0(1)
        // Space Complexity = O(1)
        if (string1.length() != string2.length()) {
            return false;
        }

        // Time Complexity = 0(1)
        // Space Complexity = O(1)
        int[] check = new int[256];

        // strings have to be same length for permutation
        for (int i = 0; i < string1.length(); i++) {
            // Time Complexity = 0(n)
            // Space Complexity = O(n)  toCharArray generates a new array with size n
            check[string1.toCharArray()[i]]++;
            check[string2.toCharArray()[i]]--;
        }

        // Will always loop through 256 size array
        // Time Complexity = 0(1)
        // Space Complexity = O(1)
        for (var numberOfParticularChar : check) {
            if (numberOfParticularChar != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    void TestPermutation() {
        assumeTrue(IsPermutation("asd", "dsa"));
        assumeTrue(IsPermutation("abacus", "sucaba"));
        assumeTrue(IsPermutation("abacus", "sucaba"));
        assumeTrue(!IsPermutation("abacus", "abacusa"));
        assumeTrue(!IsPermutation("abacus", "abacusa"));
    }

    @Test
    void TestPermutationUsingIntArray() {
        assumeTrue(IsStringPermutationUsingInt("asd", "dsa"));
        assumeTrue(IsStringPermutationUsingInt("abacus", "sucaba"));
        assumeTrue(IsStringPermutationUsingInt("abacus", "sucaba"));
        assumeTrue(!IsStringPermutationUsingInt("abacus", "abacusa"));
        assumeTrue(!IsStringPermutationUsingInt("abacus", "abacusa"));
    }
}
