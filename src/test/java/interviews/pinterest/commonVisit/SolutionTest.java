package interviews.pinterest.commonVisit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private static final String[] user0 = {"/nine.html", "/four.html", "/six.html", "/seven.html", "/one.html"};
  private static final String[] user2 = {"/nine.html", "/two.html", "/three.html", "/four.html", "/six.html", "/seven.html"};
  private static final String[] user1 = {"/one.html", "/two.html", "/three.html", "/four.html", "/six.html"};
  private static final String[] user3 = {"/three.html", "/eight.html"};
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final List<String> actual = solution.getCommonVisit(user0, user2);
    final List<String> expected = List.of("/four.html", "/six.html", "/seven.html");
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final List<String> actual = solution.getCommonVisit(user1, user2);
    final List<String> expected = List.of("/two.html", "/three.html", "/four.html", "/six.html");
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase3() {
    final List<String> actual = solution.getCommonVisit(user0, user3);
    final List<String> expected = List.of();
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase4() {
    final List<String> actual = solution.getCommonVisit(user3, user1);
    final List<String> expected = List.of("/three.html");
    assertEquals(expected, actual);
  }


  @Test
  void testOnlineCase5() {
    final String[] user1 = {"/a.html", "/d.html", "/b.html", "/c.html"},
        user3 = {"/a.html", "/b.html", "/c.html"};
    final List<String> actual = solution.getCommonVisit(user1, user3);
    final List<String> expected = List.of("/b.html", "/c.html");
    assertEquals(expected, actual);
  }
}