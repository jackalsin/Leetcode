package interviews.linkedin.mianjing._294_Flip_Game_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DfsMemoSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new DfsMemoSolution();
  }

  @Test
  void test4Plus() {
    final String input = "++++";
    assertTrue(solution.canWin(input));
  }

  @Test
  void test5Plus() {
    final String input = "+++++";
    assertFalse(solution.canWin(input));
  }

  @Test
  void testEmpty() {
    assertFalse(solution.canWin(""));
  }

}