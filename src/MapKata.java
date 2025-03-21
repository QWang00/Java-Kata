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

//    Find the Most Frequent Element in an int Array, if multiple return any one
    public static int findMostFrequent(List<Integer> numbers){
        // check if the list is null or empty, if so,
        // return integer min value
        if (numbers.isEmpty()) return Integer.MAX_VALUE;

        // initialize a new hashmap for frequency
        Map<Integer, Integer> numberCount = new HashMap<>();
        // iterate through the integer list
        for(int num : numbers) {
            // put the number to the map as key, frequency as value
            numberCount.put(num, numberCount.getOrDefault(num, 0)+1);
        }

        System.out.println(numberCount);

        List<Integer> valueList = new ArrayList<>();
        // iterate the map value
        for(int value : numberCount.values()){
            valueList.add(value);
        }
        // initialize mostValue to the first value
        int mostValue = valueList.get(0);
        for (int i = 1; i < valueList.size(); i++) {
            int currentValue = valueList.get(i);
            if(currentValue > mostValue) mostValue = currentValue;
        }
        System.out.println("the most frequent number is: " + mostValue);
        // initialize the result key to 0
        int resultKey = 0;
        // iterate the map entry
        for(Map.Entry<Integer, Integer> entry : numberCount.entrySet()) {
            // check if the current value equals to the biggest number, if yes,
            if(entry.getValue() == mostValue) {
                resultKey = entry.getKey();
                break;
            }
            // set the result key to current key
            // break the loop

        }
        // return the result key
        return resultKey;

    }

    public static Optional<Integer> findMostFrequentSolution(int[] nums) {
        if (nums.length == 0) {
            return Optional.empty(); // Return empty if no elements exist
        }

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        int mostFrequentElement = nums[0];

        for (var entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostFrequentElement = entry.getKey();
            }
        }

        return Optional.of(mostFrequentElement);
    }

    // Check if two strings are anagrams (same characters with same frequency), ignore cases
    public static boolean areAnagrams (String str1, String str2){
        if(!(str1.length() == str2.length())) return false;

        Map<Character, Integer> str1Map = getCharFreqMap(str1);
        Map<Character, Integer> str2Map = getCharFreqMap(str2);

        return  str1Map.equals(str2Map);
    }

    private static Map<Character, Integer> getCharFreqMap (String str){
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char character : str.toCharArray()){
            character = Character.toLowerCase(character);
            freqMap.put(character, freqMap.getOrDefault(character, 0)+1);
        }
        return freqMap;
    }

    public static boolean areAnagramsSolution(String str1, String str2) {
        // Clean both strings: remove non-letter characters and convert to lowercase
        str1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        str2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Early exit if lengths don't match
        if (str1.length() != str2.length()) return false;

        return getCharFreqMap(str1).equals(getCharFreqMap(str2));
    }





}
