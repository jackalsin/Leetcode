package interviews.linkedin._244_Shortest_Word_Distance_II;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordDistanceIIITest {

  @Test
  void testOnlineCase() throws Exception {
    final String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    final WordDistance wordDistance = new WordDistanceIII(words);
    assertEquals(3, wordDistance.shortest("coding", "practice"));
    assertEquals(1, wordDistance.shortest("coding", "makes"));
  }
}