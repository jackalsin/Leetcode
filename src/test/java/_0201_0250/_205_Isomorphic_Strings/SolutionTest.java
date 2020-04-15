package _0201_0250._205_Isomorphic_Strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/6/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testEmpty(Solution solution) {
    assertTrue(solution.isIsomorphic("", ""));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testExample1(Solution solution) {
    assertTrue(solution.isIsomorphic("egg", "add"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testExample2(Solution solution) {
    assertFalse(solution.isIsomorphic("foo", "bar"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testExample3(Solution solution) {
    assertTrue(solution.isIsomorphic("paper", "title"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testAbAndAA(Solution solution) throws Exception {
    assertFalse(solution.isIsomorphic("ab", "aa"));
  }
}
