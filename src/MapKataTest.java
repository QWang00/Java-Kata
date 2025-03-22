import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
