package _0901_0950._920_Number_of_Music_Playlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(6, solution.numMusicPlaylists(3, 3, 1));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(6, solution.numMusicPlaylists(2, 3, 0));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(2, solution.numMusicPlaylists(2, 3, 1));
  }
}