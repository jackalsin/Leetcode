package interviews.uber._354_Russian_Doll_Envelopes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/19/2018.
 */
class SolutionITest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase() throws Exception {
    final int[][] input = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
    assertEquals(3, solution.maxEnvelopes(input));
  }

  @Test
  void testEmpty() throws Exception {
    final int[][] input = {};
    assertEquals(0, solution.maxEnvelopes(input));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final int[][] input = {{5, 4}, {6, 5}, {6, 7}, {2, 3}, {7, 6}};
    assertEquals(4, solution.maxEnvelopes(input));
  }
}
