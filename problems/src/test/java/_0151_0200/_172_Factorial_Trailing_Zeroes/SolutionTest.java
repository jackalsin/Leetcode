package _0151_0200._172_Factorial_Trailing_Zeroes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testSmallerThan5() throws Exception {
    for (int i = 0; i < 5; i++) {
      assertEquals(0, solution.trailingZeroes(i));
    }
  }

  @Test
  public void test5() throws Exception {
    assertEquals(1, solution.trailingZeroes(5));
  }

  @Test
  public void test10() throws Exception {
    assertEquals(2, solution.trailingZeroes(10));
  }

  @Test
  public void test25() throws Exception {
    assertEquals(6, solution.trailingZeroes(25));
  }

  @Test
  public void test125() throws Exception {
    assertEquals(31, solution.trailingZeroes(125));
  }

}
