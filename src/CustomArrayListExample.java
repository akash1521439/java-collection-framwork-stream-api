import java.time.LocalDate;
import java.util.*;

public class CustomArrayListExample {
    public static void main(String[] args){
        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee(101,"ABC",2000.00,LocalDate.of(2024, 3, 10)));
        employee.add(new Employee(102,"ABC",2000.00,LocalDate.of(2024, 3, 10)));
        employee.add(new Employee(101,"ACD",3000.00,LocalDate.of(2024, 3, 15)));
        employee.add(new Employee(103,"BCD",3000.00,LocalDate.of(2024, 3, 15)));
        employee.add(new Employee(102,"CDE",5000.00,LocalDate.of(2024, 3, 20)));
        employee.add(new Employee(103,"ADE",5000.00, LocalDate.of(2024, 3, 20)));

        System.out.println("Original List "+ employee);
        Collections.sort(employee);
        System.out.println("Sorted List "+employee);

        Iterator<Employee> iterator = employee.iterator();
        System.out.println("Iterate using iterator");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("Iterate using foreach");
        employee.forEach(System.out::println);

        System.out.println("Sorting using Comparator Interface");
        Comparator<Employee> compareByName = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(employee,compareByName);
        System.out.println(employee);
        employee.forEach(System.out::println);

        System.out.println("Compartor interface using Java8");
        Collections.sort(employee,Comparator.comparing(Employee::getName));
        System.out.println(employee);

        System.out.println("By salary");
        Collections.sort(employee,Comparator.comparing(Employee::getSalary));
        System.out.println(employee);

        System.out.println("By salary then Name");
        Collections.sort(employee,Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
        System.out.println(employee);

    }

}
