package interviews.microsoft._091_Decode_Ways;

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

  @Test
  void test226() {
    assertEquals(3, solution.numDecodings("226"));
  }
}