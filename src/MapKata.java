import java.util.*;

public class MapKata {
    public static Map<String, Integer> getWordCount (List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            if(wordCount.containsKey(word)){
                wordCount.put(word, wordCount.get(word)+1);
            } else {
                wordCount.put(word, 1);
            }
        }
        return wordCount;
    }

    public static Map<String, Integer> getWordCountFast (List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
        }
        return wordCount;
    }
}
