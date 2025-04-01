import java.util.*;

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

    /*
    Find Missing Numbers in a Range, assume the array has unique numbers, and the range is 0 to n

    Input:  nums = [2, 3, 7], n = 7
    Output: [1, 4, 5, 6]

    Input:  nums = [1, 2, 3, 4, 5], n = 5
    Output: []

    Input:  nums = [4, 2], n = 5
    Output: [1, 3, 5]

    Input: nums = [4,4,3,1,3,2,100], n = 5
    Output: [5]
    */
    public static List<Integer> findMissingNumbers(int[] nums, int n){
        if(nums== null || nums.length ==0) return List.of();
        List<Integer> result = new ArrayList<>();

        // convert array to arrayList
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums){
            numsList.add(num);
        }

        // create an expected list based on n
        Set<Integer> fullList = new HashSet<>();
        for (int i = 1; i < n+1; i++) {
            fullList.add(i);
        }
        // iterate the expected list and see each item is in nums, if not, put it in result list
        for(int num : fullList){
            if(!numsList.contains(num)) result.add(num);
        }
        return result;
    }

    public static List<Integer> findMissingNumbersSolution(int[] nums, int n) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> missing = new ArrayList<>();

        for (int num : nums) {
            seen.add(num); // Duplicates are ignored automatically
        }

        for (int i = 1; i <= n; i++) {
            if (!seen.contains(i)) {
                missing.add(i);
            }
        }

        return missing;
    }


}
