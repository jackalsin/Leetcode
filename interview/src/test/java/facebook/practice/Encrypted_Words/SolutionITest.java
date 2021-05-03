package facebook.practice.Encrypted_Words;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    String s_1 = "abc";
    String expected_1 = "bac";
    String output_1 = solution.findEncryptedWord(s_1);
    assertEquals(expected_1, output_1);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    String s_2 = "abcd";
    String expected_2 = "bacd";
    String output_2 = solution.findEncryptedWord(s_2);
    assertEquals(expected_2, output_2);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}