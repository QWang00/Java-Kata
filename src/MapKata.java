
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
            character = java.lang.Character.toLowerCase(character);
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

    // Find the First Repeating Element in an int List, If no elements repeat, return Integer.MIN_VALUE
    // NOTE: HashMap does not guarantee orders so the first repeat element can be any one int.
    public static int findFirstRepeating (int[] nums){
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            int currentValue = entry.getValue();
            if (currentValue > 1) return entry.getKey();
        }
        return Integer.MIN_VALUE;

    }

    public static int findFirstRepeatingSolution(List<Integer> numbers) {
        Set<Integer> seen = new HashSet<>();

        for (int num : numbers) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return Integer.MIN_VALUE;
    }

 //    Find All Duplicates in an int Array
    public static int[] getAllDuplicates (int[] nums){
        ArrayList<Integer> duplicateList = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            if(entry.getValue() >1) duplicateList.add(entry.getKey());
        }
        int[] arr = duplicateList.stream().mapToInt(Integer::intValue).toArray();

        return arr;
    }

//    Find the Character with the Highest Frequency in a String, if multiple, return any. ignore spaces; case-sensitive;
    public static char getMostFreqChar(String word){
        // empty: null char
        if(word.isEmpty()) return '\0';
        // trim the string
        String trimmed = word.replaceAll("\\s", "");
        // iterate the char array, create frequent map
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char character : trimmed.toCharArray()){
            freqMap.put(character, freqMap.getOrDefault(character, 0)+1);
        }
        // initialize the result to be the first char
        char result = trimmed.toCharArray()[0];
        int highestValue = 0;
        // iterate the map, find the value with the biggest number in the map and its key (last one)
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            int currentValue = entry.getValue();
            char currentKey = entry.getKey();
            if(currentValue > highestValue) {
                highestValue = currentValue;
                result = currentKey;
            }
        }
        // return the key
        return result;

    }

    public static char getMostFreqCharSolution(String input) {
        if (input == null || input.isEmpty()) {
            return '\0'; // return null character if empty
        }

        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            if (c == ' ') continue; // skip spaces
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        char mostFreqChar = '\0';
        int maxFreq = 0;

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostFreqChar = entry.getKey();
            }
        }

        return mostFreqChar;
    }

//    Find the Index of the First Non-Repeating Character in a string, if not exists, return -1; case-sensitive and include spaces
    public static int getFirstUniqueCharIndex(String input){
        // empty or null input, return -1
        if(input==null || input.isEmpty()) return -1;
        // create a frequency map to count character frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char character : input.toCharArray()){
            freqMap.put(character, freqMap.getOrDefault(character, 0)+1);
        }

        char key = '\0';
        // iterate the frequency map to find the first key with the value as 1
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            if(entry.getValue() == 1) {
                // if found, set the key
                key = entry.getKey();
                // iterate the string, found the index of the key found.
                for (int i = 0; i < input.length(); i++) {
                    char current = input.charAt(i);
                    if(key == current){
                        return i;
                    }
                }
            }
        }

        return -1;
    }

    public static int getFirstUniqueCharIndexSolution(String input) {
        if (input == null || input.isEmpty()) {
            return -1;
        }

        Map<Character, Integer> freqMap = new HashMap<>();

        // First pass: count character frequencies
        for (char c : input.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Second pass: find the first character with frequency 1
        for (int i = 0; i < input.length(); i++) {
            if (freqMap.get(input.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // No unique character found
    }

//    Group Words That Are Anagrams, case-sensitive and include spaces
    public static List<List<String>> groupAnagrams(String[] words){
        // empty or null : return empty list
        if(words== null || words.length == 0 ) return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();
        List<Map<Character, Integer>> mapList = new ArrayList<>();

        // iterate input array to create frequency maps for each word, and add all maps to a list
        for(String word : words){
            Map<Character, Integer> freqMap = new HashMap<>();
            for(char character : word.toCharArray()){
                freqMap.put(character, freqMap.getOrDefault(character, 0) +1);
            }
            mapList.add(freqMap);
        }

        // iterate each map to check if there are any map equal to it, if there are, add them to the result list
        for (int i = 0; i < mapList.size(); i++) {
            for (int j = i+1; j < mapList.size(); j++) {
                if(mapList.get(i).equals(mapList.get(j))) result.add(new ArrayList<>(Arrays.asList(words[i], words[j])));
            }
        }
        return result;
    }

    public static List<List<String>> groupAnagramsSolution(String[] words) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word : words) {
            // Sort the characters of the word to get the key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); // e.g., "eat" → "aet"

            // Group by anagram key
            if (!anagramMap.containsKey(key)) {
                anagramMap.put(key, new ArrayList<>());
            }

            anagramMap.get(key).add(word);
        }

        // Return grouped values
        return new ArrayList<>(anagramMap.values());
//        Loop Breakdown
//        Step	Word	Sorted Key	Map State (anagramMap)
//        1	"eat"	"aet"	{ "aet": ["eat"] }
//        2	"tea"	"aet"	{ "aet": ["eat", "tea"] }
//        3	"tan"	"ant"	{ "aet": ["eat", "tea"], "ant": ["tan"] }
//        4	"ate"	"aet"	{ "aet": ["eat", "tea", "ate"], "ant": ["tan"] }
//        5	"nat"	"ant"	{ "aet": ["eat", "tea", "ate"], "ant": ["tan", "nat"] }
//        6	"bat"	"abt"	{ "aet": ["eat", "tea", "ate"], "ant": ["tan", "nat"], "abt": ["bat"]
    }

}
