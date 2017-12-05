package _451_500._493_Reverse_Pairs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new MergeSortSolution();
//    solution = new BinaryIndexTreeSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 3, 2, 3, 1};
    assertEquals(2, solution.reversePairs(nums));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] nums = {2, 4, 3, 5, 1};
    assertEquals(3, solution.reversePairs(nums));
  }
}