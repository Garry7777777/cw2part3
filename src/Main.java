import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // получили строоку с консоли через args
        // хардкод - имитирует полученный ввод
        String[] myString = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        System.out.println("В тексте " + myString.length +" слов");

        System.out.println("TOP10:");
        Stream.of(myString).collect(Collectors.toMap(key -> key, value -> 1, Integer::sum)).entrySet().stream().
                sorted(Map.Entry.comparingByKey()).
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                limit( 10).
                forEach(s -> System.out.println(s.getKey()+ " — "+ s.getValue()));
    }
}