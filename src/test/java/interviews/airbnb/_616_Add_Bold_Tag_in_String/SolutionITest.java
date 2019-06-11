package interviews.airbnb._616_Add_Bold_Tag_in_String;

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
}