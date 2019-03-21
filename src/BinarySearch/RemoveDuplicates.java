package BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveDuplicates {


    public static void main(String[] args) {
        removeDuplicatesBest(new int[]{0,0,1,1,1,2,2,3,3,4});


    }
    public static int removeDuplicatesBest(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public int removeDuplicates(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int l = getIndex(nums, nums[i], true);
            int r = getIndex(nums, nums[i], false) - 1;
            if(r == nums.length - 1)
            {
                return l + 1;
            }
            if(l != r){
                while(r != l && r + 1 < nums.length){
                    nums[r] = nums[r + 1];
                    r--;
                }
            }
        }
        return nums.length;
    }

    public int getIndex(int[] nums, int target, boolean left){
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] > target || (nums[mid] == target && left))
                r = mid - 1;
            else
                l = mid + 1;
        }

        return l;


    }
}
