package _051_100._080_Remove_Duplicates_from_Sorted_Array_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/14/2017.
 */
public class SolutionTest {

  private int[] array1;

  private Solution solution;


  @Before
  public void setUp() throws Exception {
    array1 = new int[] {1, 1, 1, 2, 2, 3, 4};
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    int size = solution.removeDuplicates(array1);
    final int[] expected = new int[] {1, 1, 2, 2, 3, 4};
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], array1[i]);
    }
  }

  @Test
  public void testCount2() throws Exception {
    assertEquals(2, solution.getCount(array1, 3));
  }

  @Test
  public void testCount1() throws Exception {
    assertEquals(3, solution.getCount(array1, 0));
  }

  @Test
  public void testCount3() throws Exception {
    assertEquals(1, solution.getCount(array1, 4));
  }


  @Test
  public void testCount4() throws Exception {
    assertEquals(1, solution.getCount(array1, 5));
  }
}