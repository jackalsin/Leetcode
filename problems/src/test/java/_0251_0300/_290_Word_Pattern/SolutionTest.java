package _0251_0300._290_Word_Pattern;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author jacka
 * @version 1.0 on 9/6/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertTrue(solution.wordPattern("abba", "dog cat cat dog"));
    assertFalse(solution.wordPattern("abba", "dog cat cat fish"));
    assertFalse(solution.wordPattern("aaaa", "dog cat cat dog"));
    assertFalse(solution.wordPattern("abba", "dog dog dog dog"));
  }
}
