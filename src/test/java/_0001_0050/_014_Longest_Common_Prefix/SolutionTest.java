package _0001_0050._014_Longest_Common_Prefix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/19.
 */
public class SolutionTest {
  private static final String[] SINGLE_EMPTY_STRING = new String[]{""};
  private static final String[] SINGLE_NON_EMPTY_STRING = new String[]{"Good"};
  private static final String[] EMPTY_STRINGS_INIT = new String[]{"", "Good"};
  private static final String[] EMPTY_STRINGS_MID = new String[]{"Good", ""};
  private static final String[] NO_COMMON_STRINGS = new String[]{"Good", "Batter"};
  private static final String[] COMMON_DECIDED_BY_FISRT_STRING =
      new String[]{"good", "goodbye", "goodday"};
  private static final String[] COMMON_DECIDED_BY_MID_STRING =
      new String[]{"goodbye", "good", "goodday"};

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void longestCommonPrefixSingleEmptyString(Solution solution) {
    assertEquals("", solution.longestCommonPrefix(SINGLE_EMPTY_STRING));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void longestCommonPrefixSingleNonEmptyString(Solution solution) {
    assertEquals("Good", solution.longestCommonPrefix(SINGLE_NON_EMPTY_STRING));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void longestCommonPrefixEmptyInit(Solution solution) {
    assertEquals("", solution.longestCommonPrefix(EMPTY_STRINGS_INIT));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void longestCommonPrefixSingleMid(Solution solution) {
    assertEquals("", solution.longestCommonPrefix(EMPTY_STRINGS_MID));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void longestCommonPrefixSingleNoCommonString(Solution solution) {
    assertEquals("", solution.longestCommonPrefix(NO_COMMON_STRINGS));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void longestCommonPrefixSingleCommonFirstString(Solution solution) {
    assertEquals("good", solution.longestCommonPrefix(COMMON_DECIDED_BY_FISRT_STRING));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void longestCommonPrefixSingleCommonMidString(Solution solution) {
    assertEquals("good", solution.longestCommonPrefix(COMMON_DECIDED_BY_MID_STRING));
  }

}