import java.util.*;

public class MapKata {
//    Implement a Frequency Counter
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

    public static Map<String, Integer> getWordCountSolution(List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
        }
        return wordCount;
    }

//    Find the First Non-Repeating Character in a String, if all are repeating, return '_'
    public static String getFirstNonRepeatChar (String word) {
        Map<Character, Integer> charCount = new HashMap<>();
        for(char character : word.toCharArray()){
            charCount.put(character, charCount.getOrDefault(character, 0) +1);
        }

        if(!charCount.containsValue(1)) return "_";
        Character uniqueKey = 0;
        for(Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if(entry.getValue() == 1) {
                uniqueKey = entry.getKey();
                break;
            }
        }
        return uniqueKey.toString();

    }

    public static char getFirstNonRepeatSolution(String word) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for(char character : word.toCharArray()) {
            charCount.put(character, charCount.getOrDefault(character, 0)+1);
        }

        for(char character : word.toCharArray()){
            if(charCount.get(character) == 1) return character;
        }

        return '_';
    }
}
