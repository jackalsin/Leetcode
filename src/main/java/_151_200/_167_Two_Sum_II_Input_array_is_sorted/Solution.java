package _151_200._167_Two_Sum_II_Input_array_is_sorted;

import com.jcraft.jsch.HASH;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("numbers cannot be null or its length cannot be less than 2");
        } else {
            int start = 0;
            int end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[start] + numbers[end];
                if (sum > target) {
                    end--;
                } else if (sum == target) {
                    return new int[] {start + 1, end + 1};
                } else {
                    start++;
                }
            }
            throw new IllegalStateException("No such solution for target = " + target);
        }
    }
}
