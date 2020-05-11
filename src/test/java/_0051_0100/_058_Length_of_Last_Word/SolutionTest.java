package _0051_0100._058_Length_of_Last_Word;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/21/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithEmpty(Solution solution) {
    assertEquals(0, solution.lengthOfLastWord(""));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithNoSpaces(Solution solution) {
    assertEquals(4, solution.lengthOfLastWord("abcd"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithLastIsMax(Solution solution) {
    assertEquals(3, solution.lengthOfLastWord("a b c def"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithFirstIsMax(Solution solution) {
    assertEquals(3, solution.lengthOfLastWord("abcd b c def"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithEmptyWithTailingSpace(Solution solution) {
    assertEquals(0, solution.lengthOfLastWord(""));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithNoSpacesWithTailingSpace(Solution solution) {
    assertEquals(4, solution.lengthOfLastWord("abcd "));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithLastIsMaxWithTailingSpace(Solution solution) {
    assertEquals(3, solution.lengthOfLastWord("a b c def "));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithFirstIsMaxWithTailingSpace(Solution solution) {
    assertEquals(3, solution.lengthOfLastWord("abcd b c def "));
  }

}