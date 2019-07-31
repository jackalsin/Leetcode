package interviews.linkedin._008_String_to_Integer_atoi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testMaxInteger(Solution solution) {
    assertEquals(Integer.MAX_VALUE, solution.myAtoi(String.valueOf(Integer.MAX_VALUE)));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testMinInteger(Solution solution) {
    assertEquals(Integer.MIN_VALUE, solution.myAtoi(String.valueOf(Integer.MIN_VALUE)));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testMinIntegerPlusOne(Solution solution) {
    assertEquals(Integer.MIN_VALUE + 1,
        solution.myAtoi(String.valueOf(Integer.MIN_VALUE + 1)));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testZero(Solution solution) {
    assertEquals(0, solution.myAtoi("0"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testUpOverflow(Solution solution) {
    assertEquals(Integer.MAX_VALUE, solution.myAtoi("2147483648"));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}