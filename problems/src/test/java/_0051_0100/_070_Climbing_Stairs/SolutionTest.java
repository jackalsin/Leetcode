package _0051_0100._070_Climbing_Stairs;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/28/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWith1() throws Exception {
    assertEquals(1, solution.climbStairs(1));
  }

  @Test
  void testWith2() throws Exception {
    assertEquals(2, solution.climbStairs(2));
  }

  @Test
  void testWith3() throws Exception {
    assertEquals(3, solution.climbStairs(3));
  }

  @Test
  void testWith4() throws Exception {
    assertEquals(5, solution.climbStairs(4));
  }
}
