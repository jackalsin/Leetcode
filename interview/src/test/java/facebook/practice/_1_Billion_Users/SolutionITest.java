package facebook.practice._1_Billion_Users;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    float[] test_1 = {1.1f, 1.2f, 1.3f};
    int expected_1 = 79;
    int output_1 = solution.getBillionUsersDay(test_1);
    assertEquals(expected_1, output_1);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    float[] test_2 = {1.01f, 1.02f};
    int expected_2 = 1047;
    int output_2 = solution.getBillionUsersDay(test_2);
    assertEquals(expected_2, output_2);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}