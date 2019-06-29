package _0051_0100._069_Sqrt_x;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/27/2017.
 */
class BinarySearchSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void test1() throws Exception {
    assertEquals(1, solution.mySqrt(1));
  }

  @Test
  void test2() throws Exception {
    assertEquals(1, solution.mySqrt(2));
  }

  @Test
  void test3() throws Exception {
    assertEquals(1, solution.mySqrt(3));
  }

  @Test
  void test4() throws Exception {
    assertEquals(2, solution.mySqrt(4));
  }

  @Test
  void test5() throws Exception {
    assertEquals(2, solution.mySqrt(5));
  }

  @Test
  void test2147395599() throws Exception {
    assertEquals(46339, solution.mySqrt(2147395599));
  }
}