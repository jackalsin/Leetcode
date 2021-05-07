package google.roadTrip;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/6/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final Cost[][] cost = {
        {Cost.of(0, 0), Cost.of(1, 700), Cost.of(1, 100)},
        {Cost.of(1, 700), Cost.of(0, 0), Cost.of(1, 100)},
        {Cost.of(1, 100), Cost.of(1, 100), Cost.of(0, 0)},
    };
    assertEquals(Cost.of(1, 700), solution.getMinCost(cost, 0, 1));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}