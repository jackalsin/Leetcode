package interviews.linkedin._065_Valid_Number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void test0(Solution solution) {
    assertTrue(solution.isNumber("0"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test0_1(Solution solution) {
    assertTrue(solution.isNumber("0.1"));
    assertTrue(solution.isNumber(" 0.1 "));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testAbc(Solution solution) {
    assertFalse(solution.isNumber("abc"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1a(Solution solution) {
    assertFalse(solution.isNumber("1a"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test03(Solution solution) {
    assertTrue(solution.isNumber(".3"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test03E81(Solution solution) {
    assertTrue(solution.isNumber(".3e81"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test3Point0(Solution solution) {
    assertTrue(solution.isNumber("3."));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2e10(Solution solution) {
    assertTrue(solution.isNumber("2e10"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2E10(Solution solution) {
    assertTrue(solution.isNumber("2E10"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2E3Point5(Solution solution) {
    assertFalse(solution.isNumber("2E3.5"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2ENegative3Point5(Solution solution) {
    assertFalse(solution.isNumber("2E3.5"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    assertFalse(solution.isNumber(""));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV()
    );
  }
}
