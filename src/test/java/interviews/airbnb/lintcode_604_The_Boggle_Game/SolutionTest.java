package interviews.airbnb.lintcode_604_The_Boggle_Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.TwoDimensionArray;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final char[][] board = {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'}
    };
    final String[] words = {"ad", "be", "abf", "ade"};
    assertEquals(2, solution.boggleGame(board, words));
  }

  @Test
  void testOnlineCase2() {
    final char[][] board = {
        {'a', 'x', 'e'},
        {'s', 'e', 'l'},
        {'s', 'h', 'o'}
    };
    final String[] words = {"asshole", "ass", "she", "ex", "hole"};
    // assert bogglegame(board, words)==['ass', 'ex', 'hole']
    assertEquals(3, solution.boggleGame(board, words));
  }

  @Test
  void testOnlineCase3() {
    final char[][] board = TwoDimensionArray.getCharBoard(
        new String[]{"oaan", "etae", "ihkr", "iflv"}
    );
    final String[] words = {"oath", "pea", "eak", "rain", "ifl"};
    //    assert bogglegame(board, words)==['oath', 'eak', 'ifl']
    assertEquals(3, solution.boggleGame(board, words));
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
    final char[][] board = TwoDimensionArray.getCharBoard(
        new String[]{"aaba", "abaa", "aaab", "baaa"}
    );
    final String[] words = {"aba", "ba", "baba", "abab", "ab", "b"};
    //    assert bogglegame(board, words)==['ab', 'b', 'ab', 'ab']
    assertEquals(4, solution.boggleGame(board, words));
  }

  @Test
  @Disabled
  void testOnlineCase6() {
//# don't run TLE
//# words=["aaa","aa","aaaa","aaaa", "aa", "a"]
//# board=["aaaa", "aaaa", "aaaa", "aaaa"]
//# board=[[c for c in row] for row in board]
//# print bogglegame(board, words)
    final char[][] board = TwoDimensionArray.getCharBoard(
        new String[]{"aaaa", "aaaa", "aaaa", "aaaa"}
    );
    final String[] words = {"aaa", "aa", "aaaa", "aaaa", "aa", "a"};
    assertEquals(16, solution.boggleGame(board, words));
  }


}