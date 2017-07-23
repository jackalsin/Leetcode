package _151_200._169_Majority_Element;

        import java.util.Arrays;
        import java.util.HashMap;
        import java.util.Map;

public class Solution {
    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     * You may assume that the array is non-empty and the majority element always exist in the array.
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;
            } else if (count == 0) {
                major = nums[i];
                count = 1;
            } else {
                count--;
            }
        }
        return major;
    }
}

