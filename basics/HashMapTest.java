import java.util.HashMap;

public class HashMapTest {

    static public HashMap<Integer, Student> buildMap(Student[] students) {
        HashMap<Integer, Student> map = new HashMap<Integer, Student>();
        for (Student s: students) map.put(s.getId(), s);
        return map;
    }

    public static void main (String [] args)
    {
        Student[] students = new Student[10];
        for (int i = 0; i < 10; i++) {
            students[i] = new Student(i);
        }
        HashMap<Integer, Student> sMap = buildMap(students);
        System.out.println("Students are:");
        for (int i = 0; i < 10; i++) {
            System.out.println(sMap.get(i));
        }
    }
}

class Student {
    private int id;

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return Integer.toString(id);
    }
}
