package HashMap;

import java.util.*;

public class ThreeSum {


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        //threeSumAlternate(nums);


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        // generate map of values -> count
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums) {
            int count = map.getOrDefault(a, 0);
            map.put(a, count + 1);
        }

        // find 3 sums
        List<List<Integer>> results = new ArrayList<>();
        for (int a : map.keySet()) {
            map.put(a, map.get(a) - 1);
            for (int b : map.keySet()) {
                map.put(b, map.get(b) - 1);
                int c = -1 * (a + b);
                if (map.get(b) >= 0 && a <= b && b <= c && map.containsKey(c) && map.get(c) > 0) {
                    results.add(Arrays.asList(new Integer[]{a, b, c}));
                }
                map.put(b, map.get(b) + 1);
            }
            map.put(a, map.get(a) + 1);
        }
        return results;
    }

    public static boolean threeSumAlternate(int[] A, int sum) {
        int l, r;

        /* Sort the elements */
        Arrays.sort(A);
        int arr_size = A.length;

        /* Now fix the first element one by one and find the
           other two elements */
        for (int i = 0; i < arr_size - 2; i++) {

            // To find the other two elements, start two index variables
            // from two corners of the array and move them toward each
            // other
            l = i + 1; // index of the first element in the remaining elements
            r = arr_size - 1; // index of the last element
            while (l < r) {
                if (A[i] + A[l] + A[r] == sum) {
                    System.out.print("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]);
                    return true;
                } else if (A[i] + A[l] + A[r] < sum)
                    l++;

                else // A[i] + A[l] + A[r] > sum
                    r--;
            }
        }

        // If we reach here, then no triplet was found
        return false;
    }
}

