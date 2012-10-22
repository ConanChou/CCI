import java.util.ArrayList;

public class ArrayListTest {
    public static ArrayList<String> merge(String[] a, String[] b) {
        ArrayList<String> sentence = new ArrayList<String>();
        for (String s: a) sentence.add(s);
        for (String s: b) sentence.add(s);
        return sentence;
    }
    public static void main (String [] args)
    {
        String[] a = {"a", "b", "c"};
        String[] b = {"x", "y", "z", "a"};
        ArrayList<String> c = merge(a, b);
        for (int i = 0; i < c.size(); i++) System.out.println(c.get(i));
    }
}
