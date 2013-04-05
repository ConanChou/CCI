/**
 * given two strings, write a method to decide if one is a 
 * permutation of the other.
 */

public class Q1_3 {
    static boolean isPermutationSort(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return sortString(s1).equals(sortString(s2));
    }

    static String sortString(String s) {
        char[] charArray = s.toCharArray();
        java.util.Arrays.sort(charArray);
        return new String(charArray);
    }

    static boolean isPermutationCount(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] charCount = new int[256];

        for (int i = 0; i<s1.length(); i++) {
            charCount[s1.charAt(i)]++;
        }

        for (int i = 0; i<s2.length(); i++) {
            --charCount[s2.charAt(i)];
        }
        int sum = 0;
        for (int c: charCount) {
            sum += c;
        }
        return sum==0;
    }
    public static void main(String args[]){
        String s1 = "conan";
        String s2 = "canon";

        System.out.println(isPermutationSort(s1, s2));
        System.out.println(isPermutationCount(s1, s2));
    }
}
