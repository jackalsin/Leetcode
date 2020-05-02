package interviews.byteDance._003_Longest_Substring_Without_Repeating_Characters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/2/2020
 */
class SolutionITest {
  //  Given "abcabcbb", the answer is "abc", which the length is 3.
  private static final String STR1 = "abcabcbb";
  //  Given "bbbbb", the answer is "b", with the length of 1.
  private static final String STR2 = "bbbbb";
  //  Given "pwwkew", the answer is "wke", with the length of 3.
  private static final String STR3 = "pwwkew";
  private static final String STR4 = "c";
  private static final String STR5 = "aaabcd";
  private static final String STR6 = "abba";

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void lengthOfLongestSubstring(Solution solution) {
    assertEquals(3, solution.lengthOfLongestSubstring(STR1));
    assertEquals(1, solution.lengthOfLongestSubstring(STR2));
    assertEquals(3, solution.lengthOfLongestSubstring(STR3));
    assertEquals(1, solution.lengthOfLongestSubstring(STR4));
    assertEquals(4, solution.lengthOfLongestSubstring(STR5));
    assertEquals(2, solution.lengthOfLongestSubstring(STR6));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}