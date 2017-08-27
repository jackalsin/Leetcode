package _251_300._255_Verify_Preorder_Sequence_in_Binary_Search_Tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/27/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    assertTrue(solution.verifyPreorder(new int[]{}));
  }

  @Test
  public void testOneElement() throws Exception {
    assertTrue(solution.verifyPreorder(new int[]{4}));
  }

  @Test
  public void test3ElementsNegative() throws Exception {
    assertFalse(solution.verifyPreorder(new int[]{2, 3, 1}));
  }
}
