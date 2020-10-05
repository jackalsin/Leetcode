package amazon._299_Bulls_and_Cows;

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
  void testOnlineCase1() throws Exception {
    assertEquals("1A3B", solution.getHint("1807", "7810"));
  }

  @Test
  void testOnlineCase2() throws Exception {
    assertEquals("1A1B", solution.getHint("1123", "0111"));
  }

  @Test
  void testOnlineCase3() throws Exception {
    assertEquals("0A4B", solution.getHint("1122", "2211"));
  }

}