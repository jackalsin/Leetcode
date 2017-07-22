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
        Map<Integer, Integer> counts = new HashMap<>();
        for(int child : nums) {
            int prevCount = counts.getOrDefault(child, 0);
            if (prevCount + 1 > nums.length / 2) {
                return child;
            }
            counts.put(child, prevCount + 1);
        }
        throw new IllegalStateException("No majority element in nums = " + Arrays.toString(nums));
    }
}

