package pinterest.similarUsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String[][] input = {
        {"http://yahoo.com", "user3", "201999"},
        {"http://google.com/maps", "user2", "201004"},
        {"http://google.com/maps", "user1", "201015"},
        {"http://google.com", "user4", "201004"},
        {"http://google.com", "user2", "201012"},
        {"http://google.com/maps", "user2", "201008"},
        {"http://google.com/maps", "user2", "201013"},
        {"http://google.com/maps", "user2", "201030"},
        {"http://altavista.net/q?f=12344", "user3", "100002"},
        {"http://google.com/maps", "user3", "201015"},
        {"http://yahoo.com", "user2", "201035"},
        {"http://altavista.net/q?f=12344", "user1", "99999"},
        {"http://altavista.net/q?f=12344", "user1", "100004"},
        {"http://geocities.com", "user1", "100007"},
        {"http://geocities.com", "user3", "100009"}
    };

    assertEquals("user3", solution.findSimilarUser(input, "user2"));
    assertEquals("user3", solution.findSimilarUser(input, "user1"));
    assertEquals("user1", solution.findSimilarUser(input, "user3"));
    assertEquals("user2", solution.findSimilarUser(input, "user4"));
  }
}