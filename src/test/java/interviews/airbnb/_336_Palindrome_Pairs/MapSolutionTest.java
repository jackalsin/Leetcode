package interviews.airbnb._336_Palindrome_Pairs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/3/2019.
 */
class MapSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new MapSolution();
  }

  @Test
  void testOnlineCase() throws Exception {
    final String[] words = {"bat", "tab", "cat"};
    final List<List<Integer>> expected = List.of(List.of(0, 1), List.of(1, 0));
    assertEquals(new HashSet<>(expected), new HashSet<>(solution.palindromePairs(words)));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
    final List<List<Integer>> expected = List.of(
        List.of(0, 1), List.of(1, 0), List.of(3, 2), List.of(2, 4)),
        actual = solution.palindromePairs(words);
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    System.out.println(actual);
    assertEquals(expected.size(), actual.size());
  }

  @Test
  void testDuplicated() throws Exception {
    final String[] words = {"a", ""};
    final Set<List<Integer>> expected = Set.of(List.of(0, 1), List.of(1, 0));
    assertEquals(expected, new HashSet<>(solution.palindromePairs(words)));
  }

}