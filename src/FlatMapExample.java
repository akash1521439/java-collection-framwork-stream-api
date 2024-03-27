import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args){
        Order order1 = new Order("123", Arrays.asList(new Product("ABC",1),
                new Product("XYZ",2),
                new Product("PQR",3)));
        Order order2 = new Order("456",Arrays.asList(
                new Product("ABC",1),
                new Product("XYZ",2),
                new Product("BCD",6)));
        List<Order> orderList = Arrays.asList(order1,order2);

        List<Product> uniqueProducts = orderList.stream().
                flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
        uniqueProducts.forEach(System.out::println);
    }
}
