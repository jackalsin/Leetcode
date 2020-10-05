package uber._091_Decode_Ways;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testEmpty() {
    assertEquals(0, solution.numDecodings(""));
  }

  @Test
  void testOnlineCase1() {
    assertEquals(1, solution.numDecodings("1"));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(2, solution.numDecodings("12"));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(2, solution.numDecodings("127383992"));
  }

  @Test
  void testOnlineCase4() {
    assertEquals(0, solution.numDecodings("1273083992"));
  }

  @Test
  void testInvalidCase1() {
    assertEquals(0, solution.numDecodings("0127383992"));
  }

}