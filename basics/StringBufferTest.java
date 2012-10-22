import java.lang.StringBuffer;

public class StringBufferTest {

    static public String joinWords(String[] words) {
        StringBuffer s = new StringBuffer();
        for (String w: words) {
            s.append(w);
        }
        return s.toString();
    }
    public static void main (String [] args)
    {
        String[] a = {"a", "b", "c"};
        System.out.println(joinWords(a));
    }
}
