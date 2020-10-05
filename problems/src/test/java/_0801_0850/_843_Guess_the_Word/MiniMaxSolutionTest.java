package _0801_0850._843_Guess_the_Word;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import definition._843_Guess_the_Word.Master;
import definition._843_Guess_the_Word.MasterImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MiniMaxSolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new MiniMaxSolution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String secret = "acckzz";
    final Master master = new MasterImpl(secret);
    final String[] wordList = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
    solution.findSecretWord(wordList, master);
    assertTrue(master.hit());
  }

  //  @Disabled
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String secret = "acckzz";
    final Master master = new MasterImpl(secret);
    final String[] wordList = {"acckzz", "acckzz", "ccbazz", "eiowzz", "abcczz"};
    solution.findSecretWord(wordList, master);
    assertTrue(master.hit());
  }
}