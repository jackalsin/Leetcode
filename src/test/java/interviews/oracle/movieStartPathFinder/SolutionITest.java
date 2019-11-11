package interviews.oracle.movieStartPathFinder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/10/2019
 */
class SolutionITest {
  private static final String STAR1 = "Star 1", STAR2 = "Star 2", STAR3 = "Star 3",
      STAR4 = "Star 4", STAR5 = "Star 5";
  private static final String MOVIE1 = "Movie 1",
      MOVIE2 = "Movie 2", MOVIE3 = "Movie 3",
      MOVIE4 = "Movie 4", MOVIE5 = "Movie 5", MOVIE7 = "Movie 7";
  private static final List<String> M_1 = List.of(
      MOVIE1, MOVIE2, MOVIE3, MOVIE4
  ), M_2 = List.of(
      MOVIE3, MOVIE4
  ), M_3 = List.of(
      MOVIE7, MOVIE3
  ), M_4 = List.of(
      MOVIE7
  ), M_5 = List.of(
      MOVIE5, MOVIE7
  );

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final Map<String, List<String>> starToMovies = Map.of(
        STAR1, M_1,
        STAR2, M_2,
        STAR3, M_3
    );
    final List<String> expected = List.of(
        STAR1, MOVIE3, STAR3
    ), actual = solution.pathFinder(starToMovies, STAR1, STAR3);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final Map<String, List<String>> starToMovies = Map.of(
        STAR1, M_1,
        STAR2, M_2,
        STAR4, M_4
    );
    final List<String> expected = List.of(
    ), actual = solution.pathFinder(starToMovies, STAR1, STAR4);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final Map<String, List<String>> starToMovies = Map.of(
        STAR1, M_1,
        STAR2, M_2,
        STAR3, M_3,
        STAR4, M_4,
        STAR5, M_5
    );
    final List<String> expected = List.of(
        STAR1, MOVIE3, STAR3, MOVIE7, STAR5
    ), actual = solution.pathFinder(starToMovies, STAR1, STAR5);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}