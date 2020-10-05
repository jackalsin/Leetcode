package uber._332_Reconstruct_Itinerary;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/6/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) {
    final List<List<String>> tickets = List.of(
        List.of("MUC", "LHR"),
        List.of("JFK", "MUC"),
        List.of("SFO", "SJC"),
        List.of("LHR", "SFO"));
    final List<String> expected = List.of("JFK", "MUC", "LHR", "SFO", "SJC");
    assertEquals(expected, solution.findItinerary(tickets));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    final List<List<String>> tickets = List.of(
        List.of("JFK", "SFO"), List.of("JFK", "ATL"), List.of("SFO", "ATL"),
        List.of("ATL", "JFK"), List.of("ATL", "SFO"));
    final List<String> expected = List.of("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
    assertEquals(expected, solution.findItinerary(tickets));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase3(Solution solution) {
    final List<List<String>> tickets = List.of(
        List.of("JFK", "KUL"),
        List.of("JFK", "NRT"),
        List.of("NRT", "JFK"));
    final List<String> expected = List.of("JFK", "NRT", "JFK", "KUL");
    assertEquals(expected, solution.findItinerary(tickets));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }

}