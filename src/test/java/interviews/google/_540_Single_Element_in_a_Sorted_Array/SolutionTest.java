package interviews.google._540_Single_Element_in_a_Sorted_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/11/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
    assertEquals(2, solution.singleNonDuplicate(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {3, 3, 7, 7, 10, 11, 11};
    assertEquals(10, solution.singleNonDuplicate(nums));
  }
}
