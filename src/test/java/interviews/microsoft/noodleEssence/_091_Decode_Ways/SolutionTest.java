package interviews.microsoft.noodleEssence._091_Decode_Ways;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testZeroElement() throws Exception {
    assertEquals(0, solution.numDecodings(""));
  }

  @Test
  void testOneElement() throws Exception {
    assertEquals(1, solution.numDecodings("1"));
  }

  @Test
  void test01() throws Exception {
    assertEquals(0, solution.numDecodings("01"));
  }

  @Test
  void test10() throws Exception {
    assertEquals(1, solution.numDecodings("10"));
  }

  @Test
  void test226() throws Exception {
    assertEquals(3, solution.numDecodings("226"));
  }
}