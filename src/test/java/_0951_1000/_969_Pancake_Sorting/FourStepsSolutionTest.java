package _0951_1000._969_Pancake_Sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FourStepsSolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new FourStepsSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {
        3, 2, 4, 1
    };
    final List<Integer> actual = solution.pancakeSort(input);
    assertTrue(isSorted(input));
  }

  @Test
  void testOnlineCase2() {
    final int[] input = {
        1, 2, 3
    };
    final List<Integer> actual = solution.pancakeSort(input);
    assertTrue(isSorted(input));
  }

  public static boolean isSorted(final int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        return false;
      }
    }
    return true;
  }

  public static void flip(final int[] nums, final List<Integer> flips) {
    for (int i : flips) {
      FourStepsSolution.flip(nums, i);
    }
  }

}