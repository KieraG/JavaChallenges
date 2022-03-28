package JavaPractice.CodingChallenges.StringChallenges;

public class IsPalindromePermutation {

    /**
     * Method for determining whether a string is a permutation of a palindrome
     *
     * @param string1 String to check if palindrome
     * @return true if palindrome
     * @implNote To be capable of being permutated into a palindrome, a string needs to have at most 1 instance of a character that occurs an odd number of times in the string.
     * @implNote All other characters must exist in the string an even number of times.
     * <p>
     * Assuming that only 256 possible characters
     */
    public boolean IsPalindromePermutation(String string1) {
        int[] characterCountArray = new int[256];

        for (var character : string1.toCharArray()) {
            characterCountArray[character]++;
        }

        boolean foundOddNumberOfChar = false;
        for (var numberOfCharactersFound : characterCountArray) {
            if (numberOfCharactersFound % 2 != 0) {
                if (!foundOddNumberOfChar) {
                    foundOddNumberOfChar = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
