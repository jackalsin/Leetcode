package pinterest.parent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  private Solution solution;

  /**
   * Graph:
   * 1 2 4
   * \/ /\
   * 3 5 8
   * \/\ \
   * 6 7 9
   */
  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  // getNodeWithIParent test

  @Test
  void testOnlineCase1() {
    final int[][] parentChildPairs = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}};
    final Set<Integer> expected = Set.of(1, 2, 4);
    final List<Integer> actual = solution.getNodeWithIParent(parentChildPairs, 0);
    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  void testOnlineCase2() {
    final int[][] parentChildPairs = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}};
    final Set<Integer> expected = Set.of(5, 8, 7, 9);
    final List<Integer> actual = solution.getNodeWithIParent(parentChildPairs, 1);
    assertEquals(expected, new HashSet<>(actual));
  }

  // hasCommonParent test

  @Test
  void testHasCommonParent1() {
    final int[][] parentChildPairs = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}};
    assertTrue(solution.hasCommonParent(parentChildPairs, 5, 8));
    assertTrue(solution.hasCommonParent(parentChildPairs, 8, 5));
  }

  @Test
  void testHasCommonParent2() {
    final int[][] parentChildPairs = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}};
    assertFalse(solution.hasCommonParent(parentChildPairs, 3, 5));
    assertFalse(solution.hasCommonParent(parentChildPairs, 5, 3));
  }

  // getFurthestParent
  @Test
  void testGetFurthestParent6() {
    final int[][] parentChildPairs = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}};
    final Set<Integer> expected = Set.of(1, 2, 4);
    final int actual = solution.getFurthestParent(parentChildPairs, 6);
    assertTrue(expected.contains(actual));
  }

  @Test
  void testGetFurthestParent9() {
    final int[][] parentChildPairs = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}};
    final Set<Integer> expected = Set.of(4);
    assertTrue(expected.contains(solution.getFurthestParent(parentChildPairs, 9)));
  }
}