import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "Java", "kata", "python", "pYthon", "123");
        System.out.println("-------My getWordCount solution-------");
        System.out.println(MapKata.getWordCount(words));
        System.out.println("------Using Fast Map getOrDefault for getWordCount-----");
        System.out.println(MapKata.getWordCountSolution(words));

        System.out.println("------getFirstNonRepeatChar----");
        System.out.println(MapKata.getFirstNonRepeatChar("JJJ"));
        System.out.println(MapKata.getFirstNonRepeatChar("swiss"));
        System.out.println(MapKata.getFirstNonRepeatSolution("KKK"));
        System.out.println(MapKata.getFirstNonRepeatSolution("swiss"));

        System.out.println("------getMostFrequentNumber----");
        System.out.println(MapKata.findMostFrequent(Arrays.asList()));
        System.out.println(MapKata.findMostFrequent(Arrays.asList(2,3,4,5)));
        System.out.println(MapKata.findMostFrequent(Arrays.asList(2,3,4,2,2)));
        System.out.println(MapKata.findMostFrequent(Arrays.asList(2,1,2,3,1)));

        System.out.println("----areAnagrams---");
        System.out.println(MapKata.areAnagrams("abc", "cba"));
        System.out.println(MapKata.areAnagrams("shfrlajdlf", "ksjd"));
        System.out.println(MapKata.areAnagrams(" ", " "));
        System.out.println(MapKata.areAnagrams("Listen", "Silent"));

    }
}