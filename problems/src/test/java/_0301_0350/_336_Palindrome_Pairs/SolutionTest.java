package _0301_0350._336_Palindrome_Pairs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/4/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
//    solution = new ON2Solution();
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
    final List<List<Integer>> expected = List.of(List.of(0, 1),
        List.of(1, 0), List.of(3, 2), List.of(2, 4));
    assertEquals(new HashSet<>(expected), new HashSet<>(solution.palindromePairs(words)));
  }

  @Test
  void testDuplicated() throws Exception {
    final String[] words = {"a", ""};
    final List<List<Integer>> expected = List.of(List.of(0, 1), List.of(1, 0));
    assertEquals(expected, solution.palindromePairs(words));
  }

}
