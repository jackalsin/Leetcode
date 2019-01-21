package _0801_0850._843_Guess_the_Word;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils._843_Guess_the_Word.Master;
import utils._843_Guess_the_Word.MasterImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MiniMaxSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new MiniMaxSolution();
  }

  //  @Disabled
  @Test
  void testOnlineCase1() {
    final String secret = "acckzz";
    final Master master = new MasterImpl(secret);
    final String[] wordList = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
    solution.findSecretWord(wordList, master);
    assertTrue(master.hit());
  }

  //  @Disabled
  @Test
  void testOnlineCase2() {
    final String secret = "acckzz";
    final Master master = new MasterImpl(secret);
    final String[] wordList = {"acckzz", "acckzz", "ccbazz", "eiowzz", "abcczz"};
    solution.findSecretWord(wordList, master);
    assertTrue(master.hit());
  }
}