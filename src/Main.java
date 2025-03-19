import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "Java", "kata", "python", "pYthon", "123");
        System.out.println("-------My getWordCount solution-------");
        System.out.println(MapKata.getWordCount(words));
        System.out.println("------Using Fast Map getOrDefault for getWordCount-----");
        System.out.println(MapKata.getWordCountFast(words));
    }
}