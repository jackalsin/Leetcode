package doordash._1359_Count_All_Valid_Pickup_and_Delivery_Options;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/8/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertEquals(1, solution.countOrders(1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    assertEquals(6, solution.countOrders(2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    assertEquals(90, solution.countOrders(3));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase8(Solution solution) {
    assertEquals(729647433, solution.countOrders(8));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}