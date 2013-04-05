import java.lang.StringBuffer;

public class Q1_5 {
    static String compress(String s) {
        if (countCompress(s) >= s.length()) {
            return s;
        }
        StringBuffer sb = new StringBuffer();
        char[] charArray = s.toCharArray();
        char currentChar = '\0';
        int count = 0;

        for (char ch: charArray) {
            if (ch == currentChar) {
                count += 1;
            } else {
                if (currentChar != '\0'){
                    sb.append(currentChar).append(count);
                }
                currentChar = ch;
                count = 1;
            }
        }

        sb.append(currentChar).append(count);
        return sb.toString();
    }

    static int countCompress(String s) {
        char[] charArray = s.toCharArray();
        int count = 0;
        int length = 0;
        char currentChar = '\0';
        for (char ch: charArray) {
            if (ch == currentChar) {
                count += 1;
            } else {
                if (currentChar != '\0') {
                    length += 1+String.valueOf(count).length();
                }
                currentChar = ch;
                count = 1;
            }
        }
        return length += 1+String.valueOf(count).length();
    }

    public static void main (String [] args)
    {
        String s = "aaabaaaaaaaaaazzzadddafagaahahdasaaaddaaaaabccddd";
        System.out.println(compress(s));
    }
}
