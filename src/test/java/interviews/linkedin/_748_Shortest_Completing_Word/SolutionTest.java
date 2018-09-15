package interviews.linkedin._748_Shortest_Completing_Word;

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
    final String licensePlate = "1s3 PSt", expected = "steps";
    final String[] words = {"step", "steps", "stripe", "stepple"};
    assertEquals(expected, solution.shortestCompletingWord(licensePlate, words));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final String licensePlate = "1s3 456", expected = "pest";
    final String[] words = {"looks", "pest", "stew", "show"};
    assertEquals(expected, solution.shortestCompletingWord(licensePlate, words));
  }

  @Test
  void testOnlineCase3() throws Exception {
    final String licensePlate = "GrC8950", expected = "according";
    final String[] words = {
        "measure", "other", "every", "base", "according", "level", "meeting", "none", "marriage", "rest"
    };
    assertEquals(expected, solution.shortestCompletingWord(licensePlate, words));
  }

}