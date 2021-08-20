package airbnb._190_Reverse_Bits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1(Solution solution) {
    assertEquals(1 << 31, solution.reverseBits(1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test(Solution solution) {
    assertEquals(1 << 30, solution.reverseBits(2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2147483648(Solution solution) {
    assertEquals(1, solution.reverseBits(0x80000000));
  }
}