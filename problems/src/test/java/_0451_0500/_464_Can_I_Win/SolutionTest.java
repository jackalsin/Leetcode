package _0451_0500._464_Can_I_Win;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/14/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
//    solution = new DPSolution();
    solution = new MemoSolution();
  }

  @Test
  void testOnlineCase() throws Exception {
    assertFalse(solution.canIWin(10, 11));
  }

  @Test
  void test1() throws Exception {
    assertTrue(solution.canIWin(10, 1));
  }

  @Test
  void test2() throws Exception {
    assertTrue(solution.canIWin(10, 2));
  }

  @Test
  void test3() throws Exception {
    assertTrue(solution.canIWin(10, 3));
  }

  @Test
  void test4() throws Exception {
    assertTrue(solution.canIWin(10, 4));
  }

  @Test
  void test40And10() throws Exception {
    assertFalse(solution.canIWin(10, 40));
  }

  @Test
  void test5And50() throws Exception {
    assertFalse(solution.canIWin(5, 50));
  }

  @Test
  void test1And10() throws Exception {
    assertTrue(solution.canIWin(10, 1));
  }
}
