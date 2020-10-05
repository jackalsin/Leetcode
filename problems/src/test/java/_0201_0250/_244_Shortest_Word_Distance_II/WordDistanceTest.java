package _0201_0250._244_Shortest_Word_Distance_II;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
class WordDistanceTest {

  @Test
  void testOnline1() {
    final String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    final WordDistance solution = new WordDistance(words);

    assertEquals(3, solution.shortest("coding", "practice"));
    assertEquals(1, solution.shortest("makes", "coding"));
  }

}