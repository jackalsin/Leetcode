package airbnb.travelBuddy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/1/2019.
 */
class SolutionITest {

  static Stream<Class> solutionStream() {
    return Stream.of(
        SolutionI.class,
        SolutionII.class,
        SolutionIII.class
    );
  }

  //   public SolutionII(final List<String> myCities, final Map<String, List<String>> friendsCities)
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<Solution> solutionClass) throws NoSuchMethodException, InvocationTargetException,
      InstantiationException, IllegalAccessException {
    final List<String> myCities = List.of("a", "b", "c", "d");
    final Map<String, List<String>> friendsCities = Map.of(
        "buddy1", List.of("a", "b", "e", "f"),
        "buddy2", List.of("a", "c", "d", "g")
    );
    final Solution solution =
        solutionClass.getConstructor(List.class, Map.class).
            newInstance(myCities, friendsCities);
    final List<String> actual = solution.getTravelBuddies(),
        expected = List.of(
            "buddy2", "buddy1"
        );

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmptyMyList(Class<Solution> solutionClass) throws NoSuchMethodException, InvocationTargetException,
      InstantiationException, IllegalAccessException {
    final List<String> myCities = List.of();
    final Map<String, List<String>> friendsCities = Map.of(
        "buddy1", List.of("a", "b", "e", "f"),
        "buddy2", List.of("a", "c", "d", "g"),
        "buddy3", List.of()
    );
    final Solution solution =
        solutionClass.getConstructor(List.class, Map.class).
            newInstance(myCities, friendsCities);
    final List<String> actual = solution.getTravelBuddies(),
        expected = List.of("buddy3");
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmptyFriendsCities(Class<Solution> solutionClass) throws NoSuchMethodException, InvocationTargetException,
      InstantiationException, IllegalAccessException {
    final List<String> myCities = List.of("a", "b", "c", "d");
    final Map<String, List<String>> friendsCities = Map.of();
    final Solution solution =
        solutionClass.getConstructor(List.class, Map.class).
            newInstance(myCities, friendsCities);
    final List<String> actual = solution.getTravelBuddies(),
        expected = Collections.emptyList();

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testBothEmpty(Class<Solution> solutionClass) throws NoSuchMethodException, InvocationTargetException,
      InstantiationException, IllegalAccessException {
    final List<String> myCities = List.of();
    final Map<String, List<String>> friendsCities = Map.of();
    final Solution solution =
        solutionClass.getConstructor(List.class, Map.class).
            newInstance(myCities, friendsCities);
    final List<String> actual = solution.getTravelBuddies(),
        expected = List.of();
    assertEquals(expected, actual);
  }

  // test for the get recommend city

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testGetRecommendedCities(Class<Solution> solutionClass) throws NoSuchMethodException,
      InvocationTargetException, InstantiationException, IllegalAccessException {
    final List<String> myCities = List.of("a", "b", "c", "d");
    final Map<String, List<String>> friendsCities = Map.of(
        "buddy1", List.of("a", "b", "e", "f"),
        "buddy2", List.of("a", "c", "d", "g")
    );
    final Solution solution =
        solutionClass.getConstructor(List.class, Map.class).
            newInstance(myCities, friendsCities);
    final List<String> actual = solution.getTravelBuddies(),
        expected = List.of(
            "buddy2", "buddy1"
        );

    assertEquals(expected, actual);

    final List<String> actualRec0 = solution.getRecommendList(0),
        actualRec1 = solution.getRecommendList(1),
        actualRec2 = solution.getRecommendList(2),
        actualRec3 = solution.getRecommendList(3),
        expectedRec0 = List.of(),
        expectedRec1 = List.of("g"), expectedRec3 = List.of("g", "e", "f");
    assertEquals(expectedRec0, actualRec0);
    assertEquals(expectedRec1, actualRec1);
    assertEquals(expectedRec3, actualRec3);
    final Set<List<String>> expected2Set = Set.of(
        List.of("g", "e"),
        List.of("g", "f")
    );
    assertTrue(expected2Set.contains(actualRec2));
  }
}