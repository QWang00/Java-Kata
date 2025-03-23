import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapKataTest {
    @Nested
    class findFirstRepeating {
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
    class getAllDuplicates{
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
}
