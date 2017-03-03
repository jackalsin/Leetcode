package _001_050._014_Longest_Common_Prefix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/19.
 */
public class SolutionTest {
  private static final String[] SINGLE_EMPTY_STRING = new String[] {""};
  private static final String[] SINGLE_NON_EMPTY_STRING = new String[] {"Good"};
  private static final String[] EMPTY_STRINGS_INIT = new String[] {"", "Good"};
  private static final String[] EMPTY_STRINGS_MID = new String[] {"Good", ""};
  private static final String[] NO_COMMON_STRINGS = new String[] {"Good", "Batter"};
  private static final String[] COMMON_DECIDED_BY_FISRT_STRING =
      new String[] {"good", "goodbye", "goodday"};
  private static final String[] COMMON_DECIDED_BY_MID_STRING =
      new String[] {"goodbye", "good", "goodday"};
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void longestCommonPrefixSingleEmptyString() throws Exception {
    assertEquals("", solution.longestCommonPrefix(SINGLE_EMPTY_STRING));
  }

  @Test
  public void longestCommonPrefixSingleNonEmptyString() throws Exception {
    assertEquals("Good", solution.longestCommonPrefix(SINGLE_NON_EMPTY_STRING));
  }

  @Test
  public void longestCommonPrefixEmptyInit() throws Exception {
    assertEquals("", solution.longestCommonPrefix(EMPTY_STRINGS_INIT));
  }

  @Test
  public void longestCommonPrefixSingleMid() throws Exception {
    assertEquals("", solution.longestCommonPrefix(EMPTY_STRINGS_MID));
  }

  @Test
  public void longestCommonPrefixSingleNoCommonString() throws Exception {
    assertEquals("", solution.longestCommonPrefix(NO_COMMON_STRINGS));
  }

  @Test
  public void longestCommonPrefixSingleCommonFirstString() throws Exception {
    assertEquals("good", solution.longestCommonPrefix(COMMON_DECIDED_BY_FISRT_STRING));
  }

  @Test
  public void longestCommonPrefixSingleCommonMidString() throws Exception {
    assertEquals("good", solution.longestCommonPrefix(COMMON_DECIDED_BY_MID_STRING));
  }

}