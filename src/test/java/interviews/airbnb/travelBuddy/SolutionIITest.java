package interviews.airbnb.travelBuddy;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionIITest {

  private Solution solution;

  @Test
  void testOnlineCase1() {
    final List<String> myCities = List.of("a", "b", "c", "d");
    final Map<String, List<String>> friendsCities = Map.of(
        "buddy1", List.of("a", "b", "e", "f"),
        "buddy2", List.of("a", "c", "d", "g")
    );
    solution = new SolutionII(myCities, friendsCities);
    final List<String> actual = solution.getTravelBuddies(),
        expected = List.of(
            "buddy2", "buddy1"
        );

    assertEquals(expected, actual);
  }

  @Test
  void testEmptyMyList() {
    final List<String> myCities = List.of();
    final Map<String, List<String>> friendsCities = Map.of(
        "buddy1", List.of("a", "b", "e", "f"),
        "buddy2", List.of("a", "c", "d", "g"),
        "buddy3", List.of()
    );
    solution = new SolutionII(myCities, friendsCities);
    final List<String> actual = solution.getTravelBuddies(),
        expected = List.of("buddy3");
    assertEquals(expected, actual);
  }

  @Test
  void testEmptyFriendsCities() {
    final List<String> myCities = List.of("a", "b", "c", "d");
    final Map<String, List<String>> friendsCities = Map.of();
    solution = new SolutionII(myCities, friendsCities);
    final List<String> actual = solution.getTravelBuddies(),
        expected = Collections.emptyList();

    assertEquals(expected, actual);
  }

  @Test
  void testBothEmpty() {
    final List<String> myCities = List.of();
    final Map<String, List<String>> friendsCities = Map.of();
    solution = new SolutionII(myCities, friendsCities);
    final List<String> actual = solution.getTravelBuddies(),
        expected = List.of();
    assertEquals(expected, actual);
  }

  // test for the get recommend city

  @Test
  void testGetRecommendedCities() {
    final List<String> myCities = List.of("a", "b", "c", "d");
    final Map<String, List<String>> friendsCities = Map.of(
        "buddy1", List.of("a", "b", "e", "f"),
        "buddy2", List.of("a", "c", "d", "g")
    );
    solution = new SolutionII(myCities, friendsCities);
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
    final Set<List<String>> execpted2Set = Set.of(
        List.of("g", "e"),
        List.of("g", "f")
    );
    assertTrue(execpted2Set.contains(actualRec2));
  }
}