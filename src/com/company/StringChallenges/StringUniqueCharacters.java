package com.company.StringChallenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Arrays;


public class StringUniqueCharacters {


    enum MethodType {
        DataStructuresAllowed,
        BruteForce,
        Sorting
    }


    public static boolean AreAllCharactersUnique(String string, MethodType methodType) throws Exception {
        switch (methodType) {
            case Sorting: {
                return AreAllCharactersUniqueSorting(string);
            }
            case BruteForce: {
                return AreAllCharactersUniqueBruteForce(string);
            }
            case DataStructuresAllowed: {
                return AreAllCharactersUniqueDataStructuresAllowed(string);
            }
            default:
                throw new Exception("Unknown MethodType to use");
        }
    }

    /**
     * Brute force attempt at telling whether the input string contains all unique characters
     * @param string The string to check if all characters in it are unique
     * @return true if all characters in the string only appear once in the string
     *
     * Time Complexity
     * Best Case 0(1) since it could return false on the first index
     * Worst Case O(n^2) where n is the length of the string because for every character, it loops over every other character
     * Average Case O(n^2)
     *
     * Space Complexity
     * O(n) where n is the number of characters in the input string
     */
    private static boolean AreAllCharactersUniqueBruteForce(String string) {

        for (int i = 0; i < string.length() - 1; i++) {
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     *  Attempt at telling whether the input string contains all unique characters by sorting the string first
     * @param string The string to check if all characters in it are unique
     * @return true if all characters in the string only appear once in the string
     *
     * Time Complexity
     * n = length of input string
     * Best Case 0(n log n) since Arrays.sort has a time complexity of O(n log n) and there is only one iteration through the string after that
     * Worst Case O(n log n) because Arrays.sort has a time complexity of O(n log n)
     * Average Case O(n log n)
     *
     * Space Complexity
     * Unknown because of Arrays.sort
     */
    public static boolean AreAllCharactersUniqueSorting(String string) {
        var sortedString = string.toCharArray();
        Arrays.sort(sortedString);

        for (int i = 0; i < sortedString.length - 1; i++) {
            if (sortedString[i] == sortedString[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     *  Attempt at telling whether the input string contains all unique characters by using an extra data structure
     * @param string The string to check if all characters in it are unique
     * @return true if all characters in the string only appear once in the string
     *
     * Time Complexity
     * n = length of input string
     * Best Case 0(1)
     * Worst Case O(n)
     * Average Case O(n)
     *
     * Space Complexity
     * O(n) because the boolean array will always retain the same size regardless
     */

    public static boolean AreAllCharactersUniqueDataStructuresAllowed(String string) {
        boolean[] charMap = new boolean[65535];
        for (char character : string.toCharArray()) {
            if (!charMap[character]) {
                charMap[character] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    void TestAreAllCharactersUniqueBruteForce() throws Exception {
        assumeTrue(!AreAllCharactersUnique("testString", MethodType.BruteForce), "String 'testString' returned true");
        assumeTrue(AreAllCharactersUnique("asd", MethodType.BruteForce), "String 'asd' returned false");
        assumeTrue(!AreAllCharactersUnique("asdd", MethodType.BruteForce), "String 'asdd' returned true");
        assumeTrue(!AreAllCharactersUnique("��", MethodType.BruteForce), "String '��' returned true");
        assumeTrue(AreAllCharactersUnique("�", MethodType.BruteForce), "String '�' returned false");
        assumeTrue(AreAllCharactersUnique(" ", MethodType.BruteForce), "String ' ' returned false");
        assumeTrue(!AreAllCharactersUnique("  ", MethodType.BruteForce), "String '  ' returned true");
    }

    @Test
    void TestAreAllCharactersUniqueDataStructures() throws Exception {
        assumeTrue(!AreAllCharactersUnique("testString", MethodType.DataStructuresAllowed), "String 'testString' returned true");
        assumeTrue(AreAllCharactersUnique("asd", MethodType.DataStructuresAllowed), "String 'asd' returned false");
        assumeTrue(!AreAllCharactersUnique("asdd", MethodType.DataStructuresAllowed), "String 'asdd' returned true");
        assumeTrue(!AreAllCharactersUnique("��", MethodType.DataStructuresAllowed), "String '��' returned true");
        assumeTrue(AreAllCharactersUnique("�", MethodType.DataStructuresAllowed), "String '�' returned false");
        assumeTrue(AreAllCharactersUnique(" ", MethodType.DataStructuresAllowed), "String ' ' returned false");
        assumeTrue(!AreAllCharactersUnique("  ", MethodType.DataStructuresAllowed), "String '  ' returned true");

    }

    @Test
    void TestAreAllCharactersUniqueSorting() throws Exception {
        assumeTrue(!AreAllCharactersUnique("testString", MethodType.Sorting), "String 'testString' returned true");
        assumeTrue(AreAllCharactersUnique("asd", MethodType.Sorting), "String 'asd' returned false");
        assumeTrue(!AreAllCharactersUnique("asdd", MethodType.Sorting), "String 'asdd' returned true");
        assumeTrue(!AreAllCharactersUnique("��", MethodType.Sorting), "String 'asdd' returned true");
        assumeTrue(AreAllCharactersUnique("�", MethodType.Sorting), "String '�' returned false");
        assumeTrue(AreAllCharactersUnique(" ", MethodType.Sorting), "String ' ' returned false");
        assumeTrue(!AreAllCharactersUnique("  ", MethodType.Sorting), "String '  ' returned true");

    }

}
