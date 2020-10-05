package facebook._269_Alien_Dictionary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
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

}