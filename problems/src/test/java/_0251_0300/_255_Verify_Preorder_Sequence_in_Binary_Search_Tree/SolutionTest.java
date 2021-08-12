package _0251_0300._255_Verify_Preorder_Sequence_in_Binary_Search_Tree;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/27/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testEmpty() throws Exception {
    assertTrue(solution.verifyPreorder(new int[]{}));
  }

  @Test
  void testOneElement() throws Exception {
    assertTrue(solution.verifyPreorder(new int[]{4}));
  }

  @Test
  void test3ElementsNegative() throws Exception {
    assertFalse(solution.verifyPreorder(new int[]{2, 3, 1}));
  }
}
