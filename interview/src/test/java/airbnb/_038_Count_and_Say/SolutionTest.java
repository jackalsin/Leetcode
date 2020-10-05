package airbnb._038_Count_and_Say;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/22/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWith1() throws Exception {
    assertEquals("1", solution.countAndSay(1));
  }

  @Test
  void testWith2() throws Exception {
    assertEquals("11", solution.countAndSay(2));
  }

  @Test
  void testWith13() throws Exception {
    assertEquals("11131221133112132113212221", solution.countAndSay(11));
  }
}