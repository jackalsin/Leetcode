package interviews.linkedin._244_Shortest_Word_Distance_II;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/9/2019
 */
class WordDistanceVITest {

  @Test
  void testOnlineCase() {
    final String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    final WordDistance wordDistance = new WordDistanceVI(words);
    assertEquals(3, wordDistance.shortest("coding", "practice"));
    assertEquals(1, wordDistance.shortest("coding", "makes"));
  }
}