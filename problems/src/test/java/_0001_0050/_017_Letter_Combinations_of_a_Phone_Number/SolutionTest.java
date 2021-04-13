package _0001_0050._017_Letter_Combinations_of_a_Phone_Number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author jacka
 * @version 1.0 on 2017/1/21.
 */
public class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test2(Solution solution) {
    assertEquals(Set.of("a", "b", "c"), new HashSet<>(solution.letterCombinations("2")));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test23(Solution solution) {
    assertEquals(Set.of("ad", "bd", "cd", "ae", "be", "ce", "af", "bf", "cf"),
        new HashSet<>(solution.letterCombinations("23")));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }
}