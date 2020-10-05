package airbnb.lintcode_604_The_Boggle_Game;

import definition.TwoDimensionArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private OnePathSolution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionII();
  }

  @Test
  void testSingleChar() {
    final char[][] board = {
        {'a'}
    };
    final String[] words = {"a"};
    assertEquals(1, solution.boggleGame(board, words));
  }

  @Test
  void testTwoChar() {
    final char[][] board = {
        {'a', 'b'}
    };
    final String[] words = {"a", "b"};
    assertEquals(2, solution.boggleGame(board, words));
  }

  @Test
  void testOnlineCase1() {
    final char[][] board = {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'}
    };
    final String[] words = {"ad", "eb", "abf", "adeb"};
    assertEquals(2, solution.boggleGame(board, words));
  }

  @Test
  void testOnlineCase2() {
    final char[][] board = {
        {'a', 'x', 'e'},
        {'s', 'e', 'l'},
        {'s', 'h', 'o'}
    };
    final String[] words = {"asshole", "ass", "she", "xe", "hole"};
    // assert bogglegame(board, words)==['ass', 'hole', 'xe']
    assertEquals(3, solution.boggleGame(board, words));
  }

  @Test
  void testOnlineCase3() {
    final char[][] board = TwoDimensionArray.getCharBoard(
        new String[]{
            "oaan",
            "etae",
            "ihkr",
            "iflv"}
    );
    final String[] words = {"oath", "pea", "eak", "rain", "ifl"};
    assertEquals(1, solution.boggleGame(board, words));
  }

  @Test
  void testOnlineCase4() {
//    words=["aba","ba","baba","abab", "ab", "b"]
//    board=["aaba", "abaa", "aaab", "baaa"]
//    board=[[c for c in row] for row in board]
//    assert bogglegame(board, words)==['ab', 'b', 'ab', 'ab']
//
//# don't run TLE
//# words=["aaa","aa","aaaa","aaaa", "aa", "a"]
//# board=["aaaa", "aaaa", "aaaa", "aaaa"]
//# board=[[c for c in row] for row in board]
//# print bogglegame(board, words)
    final char[][] board = TwoDimensionArray.getCharBoard(
        new String[]{"ab", "cd", "ab", "cd"}
    );
    final String[] words = {"ab", "ac", "acd", "c", "d"};
    // assert bogglegame(board, words)==['ass', 'ex', 'hole']
    assertEquals(6, solution.boggleGame(board, words));
  }

  @Test
  void testOnlineCase5() {
//# don't run TLE
//# words=["aaa","aa","aaaa","aaaa", "aa", "a"]
//# board=["aaaa", "aaaa", "aaaa", "aaaa"]
//# board=[[c for c in row] for row in board]
//# print bogglegame(board, words)
    final char[][] board = TwoDimensionArray.getCharBoard(
        new String[]{
            "abcd",
            "dddf",
            "ddde",
            "ddef"
        }
    );
    final String[] words = {"abcd", "ab", "fefe"};
    assertEquals(2, solution.boggleGame(board, words));
  }
}