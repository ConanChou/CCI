/**
 * implement an algorithm to determine if a string has all
 * unique characters. what if you cannot use additional data structure?
 */
public class Q1_1 {
    static boolean isUniueChar(String s) {
        if (s.length() > 256) {
            return false;
        }
        boolean[] charSet = new boolean[256];
        for (int i=0; i<s.length(); i++) {
            int val= s.charAt(i);
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

    static boolean isUniueCharBitVector(String s) {
        if (s.length() > 256) {
            return false;
        }
        int checker = 0;
        for (int i=0; i<s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String args[]) {
        String s = "This is a test string.";
        String s1 = "abcdefg";
        System.out.println(isUniueChar(s));
        System.out.println(isUniueChar(s1));
        System.out.println(isUniueCharBitVector(s));
        System.out.println(isUniueCharBitVector(s1));
    }
}
