package _0201_0250._201_Bitwise_AND_of_Numbers_Range;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/2/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(new Solution());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testZero(Solution solution) {
    assertEquals(0, solution.rangeBitwiseAnd(0, 0));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test1And2(Solution solution) {
    assertEquals(0, solution.rangeBitwiseAnd(1, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test0b101010And0b101101(Solution solution) {
    assertEquals(0b101000, solution.rangeBitwiseAnd(0b101101,
        0b101010));
  }
}

