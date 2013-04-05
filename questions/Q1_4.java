/**
 * urlize a string. you need to strip it first.
 * the space inside the string should be replaced by "%20"
 * the true length of the original string is given
 */

import java.util.ArrayList;

public class Q1_4 {
    static String urlize(String s, int length) {
        char[] charArray = s.toCharArray();
        int start_strip = 0;

        for (int i = 0; i<s.length(); i++) {
            if (charArray[i] == ' ') {
                start_strip += 1;
            } else {
                break;
            }
        }
        int spaceCount = 0;
        for (int i = start_strip; i<length + start_strip; i++) {
            if (charArray[i] == ' ') {
                spaceCount += 1;
            }
        }
        char[] newCharArray = new char[length + 2*spaceCount];

        for (int i = 0, j = start_strip; j < start_strip + length; j++) {
            if (charArray[j] == ' ') {
                newCharArray[i] = '%';
                newCharArray[i+1] = '2';
                newCharArray[i+2] = '0';
                i += 3;
            } else {
                newCharArray[i] = charArray[j];
                i += 1;
            }
        }
        return new String(newCharArray);
    }

    public static void main(String args[]) {
        String s = "  a b c  ";
        System.out.println(urlize(s,5));
    }
}
