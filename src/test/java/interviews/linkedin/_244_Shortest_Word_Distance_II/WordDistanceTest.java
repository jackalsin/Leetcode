package interviews.linkedin._244_Shortest_Word_Distance_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public class WordDistanceTest {
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testOnlineCase() throws Exception {
    final String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    final WordDistance wordDistance = new WordDistanceII(words);
    assertEquals(3, wordDistance.shortest("coding", "practice"));
    assertEquals(1, wordDistance.shortest("coding", "makes"));
  }

}
