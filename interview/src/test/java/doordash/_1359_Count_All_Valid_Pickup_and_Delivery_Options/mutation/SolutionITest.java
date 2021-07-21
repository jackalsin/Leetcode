package doordash._1359_Count_All_Valid_Pickup_and_Delivery_Options.mutation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final Set<List<String>> expected = Set.of(
      List.of("P2", "D2", "P1", "D1"),
      List.of("P2", "P1", "D2", "D1"),
      List.of("P2", "P1", "D1", "D2"),
      List.of("P1", "P2", "D1", "D2"),
      List.of("P1", "P2", "D2", "D1"),
      List.of("P1", "D1", "P2", "D2")
    );
    final Set<List<String>> actual = solution.countOrders(2);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}
