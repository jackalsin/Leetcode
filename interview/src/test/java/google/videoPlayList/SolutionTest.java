package google.videoPlayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/31/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setup() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] playlists = {
        {1, 2, 4, 5},
        {2, 4},
        {6},
        {5}
    };
    assertEquals(2, solution.clusterCount(playlists));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[][] playlists = {
        {1, 2, 4, 5},
        {2, 4},
        {7},
        {5}
    };
    assertEquals(2, solution.clusterCount(playlists));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final int[][] playlists = {
        {1, 2, 4, 5},
        {2, 4},
        {7, 8},
        {5}
    };
    assertEquals(2, solution.clusterCount(playlists));
  }
}
