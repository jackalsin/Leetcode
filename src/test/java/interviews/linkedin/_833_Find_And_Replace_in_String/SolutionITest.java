package interviews.linkedin._833_Find_And_Replace_in_String;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
    final String S = "abcd";

    final int[] indexes = {0, 2};
    final String[] sources = {"a", "cd"}, targets = {"eee", "ffff"};
    final String actual = solution.findReplaceString(S, indexes, sources, targets);
    assertEquals("eeebffff", actual);
  }

  @Test
  void testOnlineCase2() {
    final String S = "abcd";
    final int[] indexes = {0, 2};
    final String[] sources = {"ab", "ec"}, targets = {"eee", "ffff"};
    final String actual = solution.findReplaceString(S, indexes, sources, targets);
    assertEquals("eeecd", actual);
  }
}