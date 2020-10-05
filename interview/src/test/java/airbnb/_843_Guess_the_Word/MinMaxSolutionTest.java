package airbnb._843_Guess_the_Word;

import definition._843_Guess_the_Word.Master;
import definition._843_Guess_the_Word.MasterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/17/2019.
 */
class MinMaxSolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new MinMaxSolution();
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