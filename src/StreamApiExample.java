import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiExample {
    public static void main(String [] args){

        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee(101,"ABC",2000.00, LocalDate.of(2024, 3, 10)));
        employee.add(new Employee(102,"ABC",2000.00,LocalDate.of(2024, 3, 10)));
        employee.add(new Employee(101,"ACD",3000.00,LocalDate.of(2024, 3, 15)));
        employee.add(new Employee(103,"BCD",3000.00,LocalDate.of(2024, 3, 15)));
        employee.add(new Employee(102,"CDE",5000.00,LocalDate.of(2024, 3, 20)));
        employee.add(new Employee(103,"ADE",5000.00,LocalDate.of(2024, 3, 20)));

        System.out.println("Stream operations to iterate Values !!!");
        employee.stream().forEach(System.out::println);

        System.out.println("Stream operations filter() !!!");
        employee.stream().filter(s->s.getName().startsWith("A"))
                .forEach(System.out::println);

        System.out.println("Stream operations  filter() and map() !!!");
        employee.stream().filter(s->s.getName().startsWith("A"))
                .map(s->s.getName().toLowerCase())
                .forEach(System.out::println);

        System.out.println("Stream operations  on Parallel Stream!!!");
        employee.parallelStream().forEach(System.out::println);

        System.out.println("Stream operations  Sorted() !!!");
        employee.stream().sorted().forEach(System.out::println);

        System.out.println("Stream operations  Sorted() !!!");
        employee.stream()
                .sorted((a,b)->a.getJoiningDate().compareTo(b.getJoiningDate()))
                .forEach(System.out::println);

        System.out.println("Stream operations using Stream.of !!!");
        Stream.of(employee).forEach(System.out::println);

        System.out.println(" Integer Stream  !!!");
        IntStream.range(1,10).mapToObj(i->"a"+i)
                .forEach(System.out::println);

        System.out.println("Adavance Stream Operations  ");
        employee.stream()
                .filter(x->x.getName().startsWith("A"))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Group by joining date");
        Map<Object, List<Employee>> byJoiningDate = employee.stream()
                .collect(Collectors.groupingBy(x->x.getJoiningDate()));
        byJoiningDate.forEach((a,b)-> System.out.format("Joining Date %s :: %s\n",a,b));

        DoubleSummaryStatistics bySalary = employee.stream()
                .collect(Collectors.summarizingDouble(s->s.getSalary()));
        System.out.println(bySalary);

        Double totalSalExp = employee.stream()
                .map(s->s.getSalary())
                .reduce(0.00,(a,b)->a+b);
        System.out.println("reduce() :: "+totalSalExp);

        Optional<Employee> maxSal = employee.stream()
                .reduce((Employee a,Employee b)-> a.getSalary()<b.getSalary() ? b:a);
        if (maxSal.isPresent()){
            System.out.println("Max Salary "+maxSal);
        }


    }
}
