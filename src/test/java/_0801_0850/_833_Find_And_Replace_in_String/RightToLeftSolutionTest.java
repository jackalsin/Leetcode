package _0801_0850._833_Find_And_Replace_in_String;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RightToLeftSolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new RightToLeftSolution();
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

  @Test
  void testOnlineCase3() {
    final String S = "ukdaxmobyfnelsdeecwisaxwjjfrxwsyfibbvnenesupbifdza";
    final int[] indexes = {22, 27, 0, 25, 6, 32, 30, 36, 44, 8, 46, 40, 38, 14, 17, 20};
    final String[] sources = {"xwj", "rxw", "uk", "jf", "ob", "fib", "sy", "vn", "bi", "yfnel", "fdza", "esu", "en", "de", "cw", "sa"},
        targets = {"pw", "lqpq", "vp", "w", "ey", "lavl", "o", "wvb", "kpj", "aosdke", "ybie", "kuh", "a", "b", "j", "gz"};
    final String actual = solution.findReplaceString(S, indexes, sources, targets);
    assertEquals("vpdaxmeyaosdkesbejigzpwwlqpqolavlbwvbakuhpkpjybie", actual);
  }
}