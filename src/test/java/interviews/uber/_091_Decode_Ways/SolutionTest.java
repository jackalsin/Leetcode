package interviews.uber._091_Decode_Ways;


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

}