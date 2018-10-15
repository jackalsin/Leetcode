package interviews.linkedin._255_Verify_Preorder_Sequence_in_Binary_Search_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionIIITest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionIII();
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

  @Test
  void testFailedCase1() throws Exception {
    assertTrue(solution.verifyPreorder(new int[]{1, 2}));
  }

  @Test
  void testFailedCase2() throws Exception {
    assertTrue(solution.verifyPreorder(new int[]{5, 2, 1, 3, 6}));
  }

  @Test
  void testFailedCase3() throws Exception {
    assertTrue(solution.verifyPreorder(new int[]{2, 1}));
  }

  @Test
  void testFailedCase4() throws Exception {
    assertFalse(solution.verifyPreorder(new int[]{1, 3, 4, 2}));
  }

  @Test
  void testFailedCase5() throws Exception {
    assertFalse(solution.verifyPreorder(new int[]{4, 2, 3, 1}));
  }


}