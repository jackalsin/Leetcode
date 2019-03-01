package interviews.airbnb.travelBuddy;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/1/2019.
 */
class SolutionTest {
  private Solution solution;


  @Test
  void testOnlineCase1() {
    final List<String> myCities = List.of("a", "b", "c", "d");
    final Map<String, List<String>> friendsCities = Map.of(
        "buddy1", List.of("a", "b", "e", "f"),
        "buddy2", List.of("a", "c", "d", "g")
    );
    solution = new Solution(myCities, friendsCities);
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
    solution = new Solution(myCities, friendsCities);
    final List<String> actual = solution.getTravelBuddies(),
        expected = List.of("buddy3");
    assertEquals(expected, actual);
  }

  @Test
  void testEmptyFriendsCities() {
    final List<String> myCities = List.of("a", "b", "c", "d");
    final Map<String, List<String>> friendsCities = Map.of();
    solution = new Solution(myCities, friendsCities);
    final List<String> actual = solution.getTravelBuddies(),
        expected = Collections.emptyList();

    assertEquals(expected, actual);
  }

  @Test
  void testBothEmpty() {
    final List<String> myCities = List.of();
    final Map<String, List<String>> friendsCities = Map.of();
    solution = new Solution(myCities, friendsCities);
    final List<String> actual = solution.getTravelBuddies(),
        expected = List.of();
    assertEquals(expected, actual);
  }
}