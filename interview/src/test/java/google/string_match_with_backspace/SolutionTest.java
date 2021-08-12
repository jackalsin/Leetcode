package google.string_match_with_backspace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/9/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String str1 = "abc\b", str2 = "ab";
    assertTrue(solution.isMatch(str1, str2));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String str1 = "abc\bc", str2 = "abc";
    assertTrue(solution.isMatch(str1, str2));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final String str1 = "a\bc", str2 = "ac";
    assertFalse(solution.isMatch(str1, str2));
  }

  @Test
  public void testOnlineCase4() throws Exception {
    final String str1 = "abc\b", str2 = "abc";
    assertFalse(solution.isMatch(str1, str2));
  }

  @Test
  public void testOnlineCase5() throws Exception {
    final String str1 = "abc\b", str2 = "abc";
    assertFalse(solution.isMatch(str1, str2));
    assertTrue(solution.isMatch(str1, "ab"));
  }

  @Test
  public void testOnlineCase6() throws Exception {
    final String str1 = "abc\b\b", str2 = "a";
    assertTrue(solution.isMatch(str1, str2));
  }


}
