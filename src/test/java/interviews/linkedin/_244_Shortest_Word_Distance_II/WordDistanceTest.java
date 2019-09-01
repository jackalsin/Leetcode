package interviews.linkedin._244_Shortest_Word_Distance_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
class WordDistanceTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Class<WordDistance> solutionClass) throws Exception {
    final String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    final WordDistance wordDistance = solutionClass
        .getConstructor(String[].class)
        .newInstance((Object) words);
    assertEquals(3, wordDistance.shortest("coding", "practice"));
    assertEquals(1, wordDistance.shortest("coding", "makes"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Class<WordDistance> solutionClass) throws Exception {
    final String[] words = {"a", "b"};
    final WordDistance wordDistance = solutionClass
        .getConstructor(String[].class)
        .newInstance((Object) words);
    assertEquals(1, wordDistance.shortest("a", "b"));
  }

  static Stream<Class> solutionProvider() {
    return Stream.of(
        WordDistanceI.class,
        WordDistanceII.class,
        WordDistanceIII.class,
        WordDistanceIV.class,
        WordDistanceV.class,
        WordDistanceVI.class
    );
  }

}
