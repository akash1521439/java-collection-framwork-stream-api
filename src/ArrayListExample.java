import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args){
        List<Integer> myList = new ArrayList<>();

        myList.add(2);
        myList.add(5);
        myList.add(4);
        myList.add(3);
        myList.add(1);
        System.out.println("Original List " + myList);
        Collections.sort(myList);

        System.out.println("Sorted List " + myList);

        List<Integer> firstFiveNumber = new ArrayList<>(myList);
        System.out.println("First 5 digit List " + firstFiveNumber);
        List<Integer> nextFiveNumber = new ArrayList<>();
        nextFiveNumber.add(6);
        nextFiveNumber.add(7);
        nextFiveNumber.add(8);
        nextFiveNumber.add(9);
        nextFiveNumber.add(10);

        List<Integer> firstTenNumbers = new ArrayList<>(firstFiveNumber);
        firstTenNumbers.addAll(nextFiveNumber);
        System.out.println("First 10 digit List " + firstTenNumbers);

        System.out.println("Iterating over elements of the list using Iterator interface");

        Iterator<Integer> myIterator = firstTenNumbers.iterator();
        while (myIterator.hasNext()){
            System.out.println(myIterator.next());
        }

        System.out.println("Iterator using For Each Loop");

        firstTenNumbers.forEach(
                System.out::println
        );


    }
}
