import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args){
        Set<String> courses = new HashSet<>();

        courses.add(null);
        courses.add("CoreJava8");
        courses.add("CoreJava9");
        courses.add("CoreJava11");
        courses.add("CoreJava11");
        courses.add("CoreJava17");
        courses.add("CoreJava09");
        courses.add("CoreJava10");
        courses.add("CoreJava17");
        courses.add("CoreJava21");
        courses.add("CoreJava21");
        courses.add("CoreJava9");
        courses.add("CoreJava8");

        System.out.println(courses);

        SortedSet<String> course = new TreeSet<>();
//        course.add(null);
        course.add("CoreJava8");
        course.add("CoreJava9");
        course.add("CoreJava11");
        course.add("CoreJava11");
        course.add("CoreJava17");
        course.add("CoreJava09");
        course.add("CoreJava10");
        course.add("CoreJava17");
        course.add("CoreJava21");
        course.add("CoreJava21");
        course.add("CoreJava9");
        course.add("CoreJava8");

        System.out.println(course);

        Set<String> fruits = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        // Set<String> fruits = new TreeSet<>(Comparator.reverseOrder());
        fruits.add("apple");
        fruits.add("Apple");
        fruits.add("orange");
        fruits.add("Orange");
        fruits.add("grapes");
        fruits.add("Grapes");

        System.out.println(fruits);

    }
}
