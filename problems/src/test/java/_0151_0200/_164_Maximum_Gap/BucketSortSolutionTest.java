package _0151_0200._164_Maximum_Gap;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/27/2017.
 */
class BucketSortSolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new BucketSortSolution();
  }

  @Test
  void testZeroElement() {
    assertEquals(0, solution.maximumGap(new int[]{}));
  }

  @Test
  void testOneElement() {
    assertEquals(0, solution.maximumGap(new int[]{1}));
  }

  @Test
  void testTwoElement() {
    assertEquals(1, solution.maximumGap(new int[]{1, 2}));
    assertEquals(1, solution.maximumGap(new int[]{2, 1}));
  }

  @Test
  void testOnlineCase() {
    assertEquals(3, solution.maximumGap(new int[]{3, 6, 9, 1}));
  }

}
