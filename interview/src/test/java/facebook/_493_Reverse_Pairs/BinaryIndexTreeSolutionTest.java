package facebook._493_Reverse_Pairs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryIndexTreeSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
//    solution = new MergeSortSolution();
    solution = new BinaryIndexTreeSolution();
//    solution = new BinaryIndexTreeSolutionSample();
  }

  @Test
  void testOnlineCase1() {
    final int[] nums = {1, 3, 2, 3, 1};
    assertEquals(2, solution.reversePairs(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {2, 4, 3, 5, 1};
    assertEquals(3, solution.reversePairs(nums));
  }

  @Test
  void testOnlineCase3() {
    final int[] nums = {5, 4, 3, 2, 1};
    assertEquals(4, solution.reversePairs(nums));
  }

}