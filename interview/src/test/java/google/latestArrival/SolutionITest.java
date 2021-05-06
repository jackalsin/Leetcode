package google.latestArrival;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/5/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] shuttles = {900}, cap = {1}, arrivials = {899, 900};
    assertEquals(898, solution.latestArrival(shuttles, cap, arrivials));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] shuttles = {900}, cap = {2}, arrivials = {899, 900};
    assertEquals(899, solution.latestArrival(shuttles, cap, arrivials));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}