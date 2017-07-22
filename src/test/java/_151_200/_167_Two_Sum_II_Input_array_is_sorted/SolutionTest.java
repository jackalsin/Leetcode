package _151_200._167_Two_Sum_II_Input_array_is_sorted;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void testOnlineCase() throws Exception {
        final int[] input = new int[] {2, 7, 11, 15};
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(input, 9));
    }
}