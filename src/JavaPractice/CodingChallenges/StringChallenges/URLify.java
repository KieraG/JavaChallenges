package JavaPractice.CodingChallenges.StringChallenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class URLify {
    /**
     * Method to replace all spaces in a string with '%20'
     * Assumes that string has sufficient space and just enough space to hold additional characters
     * Assumes that string may not end in a space/spaces
     *
     * @param string string to URLify
     */
    public void URLify(char[] string) {
        int replaceIndex = 0;
        boolean foundFirstCharacter = false;
        for (int charIndex = string.length; charIndex > 0; charIndex--) {
            if (foundFirstCharacter) {
                // TODO
            } else if (string[charIndex] != ' ') {
                foundFirstCharacter = true;
            }


        }
    }

    @Test
    void TestURLify() {
        var string = new char[]{'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 't', 'e', 's', 't', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        URLify(string);
        String outputString = new String(string);
        assumeTrue(outputString.equals("This%20is%20a%20test"));
    }

}
