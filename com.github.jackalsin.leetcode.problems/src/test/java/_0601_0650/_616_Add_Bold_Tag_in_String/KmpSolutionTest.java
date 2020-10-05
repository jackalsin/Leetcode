package _0601_0650._616_Add_Bold_Tag_in_String;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KmpSolutionTest {

  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new KmpSolution();
  }

  @Test
  void testOnlineCase1() {
    final String s = "abcxyz123";
    final String[] dict = {"abc", "123"};
    final String expected = "<b>abc</b>xyz<b>123</b>";
    assertEquals(expected, solution.addBoldTag(s, dict));
  }

  @Test
  void testOnlineCase2() {
    final String s = "aaabbcc";
    final String[] dict = {"aaa", "aab", "bc"};
    final String expected = "<b>aaabbc</b>c";
    assertEquals(expected, solution.addBoldTag(s, dict));
  }

  @Test
  void testOnlineCase3() {
    final String s = "aaabbcc";
    final String[] dict = {"a", "b", "c"};
    final String expected = "<b>aaabbcc</b>";
    assertEquals(expected, solution.addBoldTag(s, dict));
  }

  @Disabled
  @Test
  void test2Kmp() {
    final String s = "aaabbcc";
    final int[] next1 = KmpSolution.getNext(s),
        next2 = KmpSolution.preprocessKMP(s);
    System.out.println(Arrays.toString(next1));
    System.out.println(Arrays.toString(next2));
    assertArrayEquals(next1, next2);
  }
}