package _601_650._639_Decode_Ways_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionII();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(9, solution.numDecodings("*"));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(18, solution.numDecodings("1*"));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(11, solution.numDecodings("*1"));
  }
}