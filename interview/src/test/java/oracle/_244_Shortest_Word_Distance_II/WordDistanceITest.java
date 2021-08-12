package oracle._244_Shortest_Word_Distance_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/2/2019
 */
class WordDistanceITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<WordDistance> solutionClass) throws Exception {
    final String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    final WordDistance wordDistance = solutionClass
        .getConstructor(String[].class)
        .newInstance((Object) words);
    assertEquals(3, wordDistance.shortest("coding", "practice"));
    assertEquals(1, wordDistance.shortest("coding", "makes"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<WordDistance> solutionClass) throws Exception {
    final String[] words = {"a", "b"};
    final WordDistance wordDistance = solutionClass
        .getConstructor(String[].class)
        .newInstance((Object) words);
    assertEquals(1, wordDistance.shortest("a", "b"));
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        WordDistanceI.class
    );
  }
}