package _0201_0250._205_Isomorphic_Strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/6/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testEmpty(Solution solution) {
    assertTrue(solution.isIsomorphic("", ""));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testExample1(Solution solution) {
    assertTrue(solution.isIsomorphic("egg", "add"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testExample2(Solution solution) {
    assertFalse(solution.isIsomorphic("foo", "bar"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testExample3(Solution solution) {
    assertTrue(solution.isIsomorphic("paper", "title"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testAbAndAA(Solution solution) throws Exception {
    assertFalse(solution.isIsomorphic("ab", "aa"));
  }
}
