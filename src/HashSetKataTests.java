import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HashSetKataTests {

    @Nested
    class RemoveDuplicates{
        @Test
        @DisplayName("Should return null when the input is null")
        void nullArray(){
            int[] input = null;
            List<Integer> result = HashSetKata.removeDuplicates(input);
            assertTrue(result == null);
        }

        @Test
        @DisplayName("Should return null when the input is empty")
        void emptyArray(){
            int[] input = {};
            List<Integer> result = HashSetKata.removeDuplicates(input);
            assertTrue(result == null);
        }

        @Test
        @DisplayName("Should return single element when all values are the same")
        void singleDuplicates(){
            int[] input = {1,1,1,1,1,1};
            List<Integer> result = HashSetKata.removeDuplicates(input);
            assertEquals(Arrays.asList(1), result);
        }

        @Test
        @DisplayName("Should return multiple elements when there are multiple duplicates in the input")
        void multiDuplicates(){
            int[] input = {1,2,3,4,5};
            List<Integer> result = HashSetKata.removeDuplicates(input);
            assertEquals(Arrays.asList(1,2,3,4,5), result);
        }

        @Test
        @DisplayName("Should remove duplicates and keep original order")
        void notNumericOrder(){
            int[] input = {4,7,1,4,10,1,9,10};
            List<Integer> result = HashSetKata.removeDuplicates(input);
            assertEquals(Arrays.asList(4,7,1,10,9), result);
        }

        @Test
        @DisplayName("Should work with negative and zero")
        void negativeAndZero(){
            int[] input = {-90, 1, 98, 0, 1};
            List<Integer> result = HashSetKata.removeDuplicates(input);
            assertEquals(Arrays.asList(-90,1,98,0), result);
        }
    }

    @Nested
    class FindMissingNumbers{
        @Test
        @DisplayName("Should return empty list when the input list is empty")
        void emptyInput(){
            int[] inputList = {};
            int n = 2;
            List<Integer> result = HashSetKata.findMissingNumbers(inputList, n);
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Should return empty list when the input list is null")
        void nullInput(){
            int[] inputList = null;
            int n = 2;
            List<Integer> result = HashSetKata.findMissingNumbers(inputList, n);
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Should return empty list when there are no missing numbers in the input list")
        void noMissing(){
            int[] inputList = {1,2,3,4,5};
            int n = 5;
            List<Integer> result = HashSetKata.findMissingNumbers(inputList, n);
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Should ignore extra numbers in the list when there are numbers larger than n")
        void largerNumbersThanN(){
            int[] inputList = {1,99};
            int n = 5;
            List<Integer> result = HashSetKata.findMissingNumbers(inputList, n);
            assertEquals(List.of(2,3,4,5), result);
        }

        @Test
        @DisplayName("Should handle unordered input the same as ordered input")
        void unorderedList(){
            int[] inputList = {5,3,2,4,1};
            int n = 7;
            List<Integer> result = HashSetKata.findMissingNumbers(inputList, n);
            assertEquals(List.of(6,7), result);
        }


        @Test
        @DisplayName("Should ignore duplicate numbers in the input")
        void duplicatesNumbersInList(){
            int[] inputList = {1,1,3,3,6,6,8};
            int n = 9;
            List<Integer> result = HashSetKata.findMissingNumbers(inputList, n);
            assertEquals(List.of(2,4,5,7,9),result);
        }

    }
}
