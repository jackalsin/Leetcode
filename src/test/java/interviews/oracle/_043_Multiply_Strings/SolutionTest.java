package interviews.oracle._043_Multiply_Strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/21/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String nums1 = "0", nums2 = "123",
        expected = "0", actual = solution.multiply(nums1, nums2);
    assertEquals(expected, actual);
  }


  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCaseNoCarry(Solution solution) {
    final String nums1 = "123", nums2 = "123",
        expected = "15129", actual = solution.multiply(nums1, nums2);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCaseCarry(Solution solution) {
    final String nums1 = "99", nums2 = "99",
        expected = "9801", actual = solution.multiply(nums1, nums2);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}