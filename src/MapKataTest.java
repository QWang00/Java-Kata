import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MapKataTest {
    @Nested
    class FindFirstRepeating {
        @Test
        @DisplayName("Should return integer min value when there is no repeating element")
        public void noRepeating() {
            int[] nums = new int[]{1,2,3,4,5};
            int result =  MapKata.findFirstRepeating(nums);
            assertEquals(Integer.MIN_VALUE, result);
        }

        @Test
        @DisplayName("Should return integer min value when the array is empty")
        public void emptyArray (){
            int[] nums = {};
            assertEquals(Integer.MIN_VALUE, MapKata.findFirstRepeating(nums));
        }

        @Test
        @DisplayName("Should return the first repeating element when there are multiple repeating")
        public void multiRepeating (){
            int[] nums = new int[]{1, 3, 3, 1, 6};
            int result = MapKata.findFirstRepeating(nums);
            assertEquals(1, result);
        }

        @Test
        @DisplayName("Should return the repeating element when there is only one repeating element")
        public void singleRepeating(){
            int[] nums = new int[]{3, 3, 1, 4};
            int result = MapKata.findFirstRepeating(nums);
            assertEquals(3, result);

        }

    }

    @Nested
    class GetAllDuplicates{
        @Test
        @DisplayName("Should return empty array when int array is empty")
        public void emptyArray() {
            int[] nums = new int[]{};
            int[] result = MapKata.getAllDuplicates(nums);
            assertTrue(result.length == 0);
        }

        @Test
        @DisplayName("Should return empty array when there are no duplicates")
        public void noDuplicates () {
            int[] nums = {1,2,3,4};
            int[] result = MapKata.getAllDuplicates(nums);
            assertTrue(result.length == 0);
        }

        @Test
        @DisplayName("Should return array with single element when there is same element appearing multiple times")
        public void singleElementDuplicates () {
            int[] nums = {1,1,1,1,1};
            int[] result = MapKata.getAllDuplicates(nums);
            //assertEquals(1, result[0]);
            assertEquals(1, result.length);
        }

        @Test
        @DisplayName("Should return array with multi elements when there are multiple elements repeating")
        public void multiDuplicates () {
            int[] nums = {1,1,2,2,2,3,3,3,3,6};
            int[] result = MapKata.getAllDuplicates(nums);
            //assertEquals(3, result.length);
            assertEquals(1, result[0]);
            assertEquals(2, result[1]);
            assertEquals(3, result[2]);
        }
    }

    @Nested
    class GetMostFreqChar{
        @Test
        @DisplayName("Should return null char when the string is empty")
        public void emptyString () {
            String word = "";
            char result = MapKata.getMostFreqChar(word);
            assertEquals('\0', result);
        }

        @Test
        @DisplayName("Should treat uppercase and lowercase characters as different")
        public void differentCases(){
            String word = "aAaAA";
            char result = MapKata.getMostFreqChar(word);
            assertEquals('A', result);
            assertNotEquals('a', result);
        }

        @Test
        @DisplayName("Should ignore spaces when determining the most frequent character")
        public void spacesExist(){
            String word = "a b c d ";
            char result = MapKata.getMostFreqChar(word);
            assertNotEquals(' ', result);
        }

        @Test
        @DisplayName("Should return the single most frequent character when only one exists")
        public void singleMostFreq(){
            String word = "abbc";
            char result = MapKata.getMostFreqChar(word);
            assertEquals('b', result);
        }

        @Test
        @DisplayName("Should return any of the most frequent characters if there's a tie")
        public void multiMostFrequent (){
            String word = "aabb";
            char result = MapKata.getMostFreqChar(word);
            assertTrue(result == 'a' || result == 'b');
        }
    }

    @Nested
    class GetFirstUniqueCharIndex {

        @Test
        @DisplayName("Should return -1 when the input is null")
        void nullInput(){
            String input = null;
            int result = MapKata.getFirstUniqueCharIndex(input);
            assertEquals(-1, result);

        }

        @Test
        @DisplayName("Should return -1 when the input is empty")
        void emptyInput(){
            String input = "";
            int result = MapKata.getFirstUniqueCharIndex(input);
            assertEquals(-1, result);
        }

        @Test
        @DisplayName("Should return -1 when there are no unique characters")
        void noUniqueChar(){
            String input = "aaabbb";
            int result = MapKata.getFirstUniqueCharIndex(input);
            assertEquals(-1, result);
        }

        @Test
        @DisplayName("Should consider spaces when determining the unique character")
        void spacesExists(){
            String input = " aaa";
            int result = MapKata.getFirstUniqueCharIndex(input);
            assertEquals(0, result);
        }

        @Test
        @DisplayName("Should treat upper cases and lower cases characters different")
        void differentCases(){
            String input1 = "aA";
            String input2 = "Aa";
            int result1 = MapKata.getFirstUniqueCharIndex(input1);
            int result2 = MapKata.getFirstUniqueCharIndex(input2);
            assertEquals(0, result1);
            assertEquals(0, result2);

        }

        @Test
        @DisplayName("Should return the index of the only unique character when it exists")
        void singleUnique(){
            String input = "abbbb";
            int result = MapKata.getFirstUniqueCharIndex(input);
            assertEquals(0, result);
        }

        @Test
        @DisplayName("Should return the index of the first unique character when multiple unique characters exist")
        void multiUnique(){
            String input = "abc";
            int result = MapKata.getFirstUniqueCharIndex(input);
            assertEquals(0, result);
        }
    }

    @Nested
    class GroupAnagrams{

        @Test
        @DisplayName("Should return empty list when input is empty")
        void emptyInput(){
            String[] input = new String[]{};
            List<List<String>> result = MapKata.groupAnagrams(input);
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Should return empty list when input string is null")
        void nullInput(){
            String[] input = null;
            List<List<String>> result = MapKata.groupAnagrams(input);
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Should return empty list when there are no anagrams")
        void noAnagrams(){
            String[] input = {"a", "b", "C"};
            List<List<String>> result = MapKata.groupAnagrams(input);
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Should return single list when there are only one group of anagrams")
        void singleAnagrams(){
            String[] input = {"eat", "tea", "help"};
            List<List<String>> result = MapKata.groupAnagrams(input);
            List<List<String>> expected = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList("eat", "tea"))));
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should return a list with multiple lists of anagrams when there are multiple groups of anagrams")
        void multiAnagrams(){
            String[] input = {"eat", "tea", "help", "pelh"};
            List<List<String>> result = MapKata.groupAnagrams(input);
            List<List<String>> expected = new ArrayList<>(Arrays.asList(
                    new ArrayList<>(Arrays.asList("eat", "tea")),
                    new ArrayList<>(Arrays.asList("help", "pelh"))
            ));
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should treat duplicate words as anagrams")
        void duplicateWords(){
            String[] input = {"eat", "eat", "help"};
            List<List<String>> result = MapKata.groupAnagrams(input);
            List<List<String>> expected = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList("eat", "eat"))));
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should treat lower and upper cases characters as different")
        void differentCasesExist(){
            String[] input = {"Eat", "tea", "Help", "pleH"};
            List<List<String>> result = MapKata.groupAnagrams(input);
            List<List<String>> expected = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList("Help", "pleH"))));
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should consider spaces when determining anagrams")
        void spacesExist(){
            String[] input = {"E at", "t aE", "help"};
            List<List<String>> result = MapKata.groupAnagrams(input);
            List<List<String>> expected = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList("E at", "t aE"))));
            assertEquals(expected, result);
        }
    }
}
