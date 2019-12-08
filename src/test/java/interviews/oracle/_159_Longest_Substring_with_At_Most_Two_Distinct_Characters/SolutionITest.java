package interviews.oracle._159_Longest_Substring_with_At_Most_Two_Distinct_Characters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/7/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testEmpty(Solution solution) {
    assertEquals(0, solution.lengthOfLongestSubstringTwoDistinct(""));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOneElement(Solution solution) {
    assertEquals(1, solution.lengthOfLongestSubstringTwoDistinct("c"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOneDuplicatedElement(Solution solution) {
    assertEquals(5, solution.lengthOfLongestSubstringTwoDistinct("ccccc"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testTwoElements(Solution solution) {
    assertEquals(6, solution.lengthOfLongestSubstringTwoDistinct("ceecce"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testThreeElements(Solution solution) {
    assertEquals(3, solution.lengthOfLongestSubstringTwoDistinct("eceba"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testThreeElementsLast(Solution solution) {
    assertEquals(5, solution.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}