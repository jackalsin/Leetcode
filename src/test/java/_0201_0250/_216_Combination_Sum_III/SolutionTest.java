package _0201_0250._216_Combination_Sum_III;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/13/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test3And7() throws Exception {
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(1, 2, 4));
    assertEquals(expected, solution.combinationSum3(3, 7));
  }

  @Test
  public void test3And9() throws Exception {
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(1, 2, 6));
    expected.add(Arrays.asList(1, 3, 5));
    expected.add(Arrays.asList(2, 3, 4));
    assertEquals(expected, solution.combinationSum3(3, 9));
  }
}
