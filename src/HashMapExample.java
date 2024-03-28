import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.Collectors;

public class HashMapExample {
    public static void main(String[] args){
        Map<Integer,String> sports = new HashMap<>();

        //sports.put(null,null);
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

        //Map into Linked list
        List<Map.Entry<Integer,String>> entrySet = new LinkedList<>(sports.entrySet());
        //Sort using comparator interface
        Collections.sort(entrySet, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        //converting linkedlist to linkedHashMap
        Map<Integer,String> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<Integer,String> me:entrySet){
            sortedMap.put(me.getKey(), me.getValue());
        }
        System.out.println(sortedMap);

        System.out.println("Sorting based on key /value using stream API's ");
        Map<Integer,String> sortUsingStream = sports.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)->e2,LinkedHashMap::new
                ));
        System.out.println(sortUsingStream);

    }
}
