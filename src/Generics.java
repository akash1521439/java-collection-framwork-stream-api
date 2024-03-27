interface Converter<F,T>{
    T convert(F from);
}
class Something{
    String startsWith(String s){
        return String.valueOf(s.charAt(0));
    }
}
public class Generics {
    public static void main(String[] args){
        Converter<String,Integer> converter = (Integer::valueOf);
//        Converter<String,Integer> converter = (from -> Integer.valueOf(from));
        Integer converted = converter.convert("123");
        System.out.println(converted);

        Something something = new Something();
        System.out.println(something.startsWith("java"));
        Converter<String,String> newConverter = something::startsWith;
        String someConverted = newConverter.convert("Java");
        System.out.println(someConverted);


    }
}
