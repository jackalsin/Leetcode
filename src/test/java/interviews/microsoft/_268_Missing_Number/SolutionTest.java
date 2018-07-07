package interviews.microsoft._268_Missing_Number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testEmpty() {
    final int[] input = new int[]{};
    assertEquals(0, solution.missingNumber(input));
  }

  @Test
  void test1() {
    final int[] input = new int[]{0};
    assertEquals(1, solution.missingNumber(input));
  }

  @Test
  void test2() {
    final int[] input = new int[]{0, 1};
    assertEquals(2, solution.missingNumber(input));
  }

}