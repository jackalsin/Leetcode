package _001_050._033_Search_in_Rotated_Sorted_Array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/2/7.
 */
public class SolutionTest {
  private Solution solution;

  private static final int[] LEFT_SORT = new int[] {4, 5, 6, 8, 10, 0, 1, 2};
  private static final int[] RIGHT_SORT = new int[] {6, 7, 9, 0, 1, 3, 4, 5};
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithLeftSortedTargetLeftFound() throws Exception {
    assertEquals(2, solution.search(LEFT_SORT, 6));
  }

  @Test
  public void testWithLeftSortedTargetLeftNotFound() throws Exception {
    assertEquals(-1, solution.search(LEFT_SORT, 7));
  }
  @Test
  public void testWithLeftSortedTargetRightFound() throws Exception {
    assertEquals(LEFT_SORT.length - 1, solution.search(LEFT_SORT, 2));
  }
  @Test
  public void testWithLeftSortedTargetRightNotFound() throws Exception {
    assertEquals(-1, solution.search(LEFT_SORT, 11));
  }

  @Test
  public void testWithLeftSortedTargetNotBetweenEnds() throws Exception {
    assertEquals(-1, solution.search(LEFT_SORT, 3));
  }

  // -------- right sorted ---------
  @Test
  public void testWithRightSortedTargetLeftFound() throws Exception {
    assertEquals(1, solution.search(RIGHT_SORT, 7));
  }
  @Test
  public void testWithRightSortedTargetLeftNotFound() throws Exception {
    assertEquals(-1, solution.search(RIGHT_SORT, 8));
  }
  @Test
  public void testWithRightSortedTargetRightFound() throws Exception {
    assertEquals(5, solution.search(RIGHT_SORT, 3));
  }
  @Test
  public void testWithRightSortedTargetRightNotFound() throws Exception {
    assertEquals(-1, solution.search(RIGHT_SORT, 8));
  }

}