package _1451_1500._1452_People_Whose_List_of_Favorite_Companies_Is_Not_a_Subset_of_Another_List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/16/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<List<String>> input = List.of(
        List.of("leetcode", "google", "facebook"),
        List.of("leetcode", "amazon"),
        List.of("facebook", "google")
    );
    assertEquals(List.of(0, 1), solution.peopleIndexes(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final List<List<String>> input = List.of(
        List.of("leetcode", "google", "facebook"),
        List.of("google", "microsoft"),
        List.of("google", "facebook"),
        List.of("google"),
        List.of("amazon")
    );
    assertEquals(List.of(0, 1, 4), solution.peopleIndexes(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}