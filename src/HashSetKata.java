import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetKata {

    // Remove Duplicate integer from an array While Preserving Order
    public static List<Integer> removeDuplicates(int[] nums){
        if(nums==null || nums.length==0 ) return null;
        // initialize a hashset for result
        List<Integer> seen = new ArrayList<>();
        // iterate the input array, if the current is not in the set, add it
        for(int num : nums) {
            if(!seen.contains(num)) seen.add(num);
        }
        return seen;
    }

    public static List<Integer> removeDuplicatesSolution(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (!seen.contains(num)) {
                seen.add(num);
                result.add(num);
            }
        }

        return result;
    }

//    Find Missing Numbers in a Range
public static List<Integer> findMissingNumbers(int[] nums, int n){
        return null;
}


}
