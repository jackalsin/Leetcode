package _051_100._091_Decode_Ways;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/31/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testZeroElement() {
    assertEquals(0, solution.numDecodings(""));
  }

  @Test
  void testOneElement() {
    assertEquals(1, solution.numDecodings("1"));
  }

  @Test
  void test01() {
    assertEquals(0, solution.numDecodings("01"));
  }

  @Test
  void test10() {
    assertEquals(1, solution.numDecodings("10"));
  }
}