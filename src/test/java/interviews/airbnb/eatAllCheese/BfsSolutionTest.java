package interviews.airbnb.eatAllCheese;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static interviews.airbnb.eatAllCheese.Solution.EMPTY;
import static interviews.airbnb.eatAllCheese.Solution.KEY;
import static interviews.airbnb.eatAllCheese.Solution.START;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BfsSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new BfsSolution();
  }

  @Test
  void testOnlineCase1() {
    final char[][] board = {
        {START, EMPTY, EMPTY, EMPTY},
        {KEY, EMPTY, EMPTY, EMPTY},
        {KEY, EMPTY, EMPTY, EMPTY},
        {KEY, KEY, EMPTY, EMPTY},
    };
    assertEquals(4, solution.getShortestPath(board));
  }

  @Test
  void testOnlineCase2() {
    final char[][] board = {
        {START, EMPTY, EMPTY, EMPTY},
        {KEY, EMPTY, EMPTY, EMPTY},
        {EMPTY, KEY, EMPTY, EMPTY},
        {KEY, KEY, EMPTY, EMPTY},
    };
    assertEquals(5, solution.getShortestPath(board));
  }

  @Test
  void testOnlineCase3() {
    final char[][] board = {
        {START, EMPTY, EMPTY, EMPTY},
        {KEY, EMPTY, EMPTY, EMPTY},
        {KEY, EMPTY, EMPTY, EMPTY},
        {KEY, EMPTY, EMPTY, EMPTY},
    };
    assertEquals(3, solution.getShortestPath(board));
  }

  @Test
  void testOnlineCase4() {
    final char[][] board = {
        {START, EMPTY, EMPTY, EMPTY},
        {KEY, EMPTY, EMPTY, EMPTY},
        {KEY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY},
    };
    assertEquals(2, solution.getShortestPath(board));
  }

  @Test
  void testOnlineCase5() {
    final char[][] board = {
        {START, EMPTY, EMPTY, EMPTY},
        {KEY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY},
    };
    assertEquals(1, solution.getShortestPath(board));
  }

}
