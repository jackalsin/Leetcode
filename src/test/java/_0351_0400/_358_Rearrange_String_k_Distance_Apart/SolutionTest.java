package _0351_0400._358_Rearrange_String_k_Distance_Apart;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/12/2017.
 */
public class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(Solution solution) {
    assertEquals("abcabc", solution.rearrangeString("aabbcc", 3));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    assertEquals("", solution.rearrangeString("aaabc", 3));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase3(Solution solution) {
    final String actual = solution.rearrangeString("aaadbbcc", 2);
    assertTrue(Set.of("abacabcd", "abcabcda").contains(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(new Solution());
  }
}
