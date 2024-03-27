import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args){
        Map<Integer,String> sports = new HashMap<>();

        sports.put(null,null);
        sports.put(1,"Cricket");
        sports.put(2, "Football");
        sports.put(1,"football");
        sports.put(4,"Basketball");
        sports.put(6,"Tennis");
        sports.put(2, "Football");
        sports.put(5, "Volleyball");
        sports.put(3, "Rugby");

        System.out.println(sports);

        System.out.println("Iterating the values ");
        Set<Map.Entry<Integer,String>> listEntry = sports.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator = listEntry.iterator();

        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey()+" :: "+entry.getValue());
        }
        System.out.println(sports.get(5));

    }
}
