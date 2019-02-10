package _0251_0300._269_Alien_Dictionary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/29/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testExample1() throws Exception {
    assertEquals("wertf", solution.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
  }

  @Test
  void testExample2() throws Exception {
    assertEquals("zx", solution.alienOrder(new String[]{"z", "x"}));
  }

  @Test
  void testExample3() throws Exception {
    assertEquals("", solution.alienOrder(new String[]{"z", "x", "z"}));
  }

  @Test
  void testFailed() throws Exception {
    assertEquals("acb", solution.alienOrder(new String[]{"ac", "ab", "b"}));
  }

  @Test
  void testFailed2() throws Exception {
    assertEquals("acb", solution.alienOrder(new String[]{"ac", "ab", "b"}));
  }

  @org.junit.jupiter.api.Test
  void testFailed3() throws Exception {
    Assertions.assertEquals("z", solution.alienOrder(new String[]{"z", "z"}));
  }
}
