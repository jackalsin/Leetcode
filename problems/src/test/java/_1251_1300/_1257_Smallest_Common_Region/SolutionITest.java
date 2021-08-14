package _1251_1300._1257_Smallest_Common_Region;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 8/14/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final List<List<String>> regions = List.of(
        List.of("Earth", "North America", "South America"),
        List.of("North America", "United States", "Canada"),
        List.of("United States", "New York", "Boston"),
        List.of("Canada", "Ontario", "Quebec"),
        List.of("South America", "Brazil"));
    final String region1 = "Quebec", region2 = "New York",
        expected = "North America";
    assertEquals(expected, solution.findSmallestRegion(regions, region1, region2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final List<List<String>> regions = List.of(
        List.of("Earth", "North America", "South America"),
        List.of("North America", "United States", "Canada"),
        List.of("United States", "New York", "Boston"),
        List.of("Canada", "Ontario", "Quebec"),
        List.of("South America", "Brazil"));
    final String region1 = "Canada", region2 = "South America",
        expected = "Earth";
    assertEquals(expected, solution.findSmallestRegion(regions, region1, region2));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}