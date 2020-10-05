package _0601_0650._616_Add_Bold_Tag_in_String;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
//    solution = new MergeIntervalSolution();
    solution = new BooleanArraySolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String s = "abcxyz123", expected = "<b>abc</b>xyz<b>123</b>";
    final String[] dict = {"abc", "123"};
    assertEquals(expected, solution.addBoldTag(s, dict));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String s = "aaabbcc", expected = "<b>aaabbc</b>c";
    final String[] dict = {"aaa", "aab", "bc"};
    assertEquals(expected, solution.addBoldTag(s, dict));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final String s = "aaabbcc", expected = "aaabbcc";
    final String[] dict = {};
    assertEquals(expected, solution.addBoldTag(s, dict));
  }
}