package _1051_1100._1055_Shortest_Way_to_Form_String;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreedySolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new GreedySolution();
  }

  @Test
  void testOnlineCase1() {
    final String source = "abc", target = "abcbc";
    assertEquals(2, solution.shortestWay(source, target));
  }

  @Test
  void testOnlineCase2() {
    final String source = "abc", target = "acdbc";
    assertEquals(-1, solution.shortestWay(source, target));
  }

  @Test
  void testOnlineCase3() {
    final String source = "xyz", target = "xzyxz";
    assertEquals(3, solution.shortestWay(source, target));
  }

  @Test
  void testTEL1() {
    final String source = "lkynjisqcrfkkhrrwwgdnzziupubqchukdinntwiesphyryfsgkjtngabsnzwlze",
        target = "lkynjisqcrfkkhrrwwgdnzziupubqchukdinntwiesphyryfsgkjtngabsnzwlzelkynjisqcrfkkhrrwwgdnzziupubqchukdinntwiesphyryfsgkjtngabsnzwlzelkynjisqcrfkkhrrwwgdnzziupubqchukdinntwiesphyryfsgkjtngabsnzwlzelkynjisqcrfkkhrrwwgdnzziupubqchukdinntwiesphyryfsgkjtngabsnzwlzelkynjisqcrfkkhrrwwgdnzziupubqchukdinntwiesphyryfsgkjtngabsnzwlze";
    assertEquals(5, solution.shortestWay(source, target));
  }

  @Test
  void testOnlineCase4() {
    final String source = "aaaaa",
        target = "aaaaaaaaaaaaa";
    assertEquals(3, solution.shortestWay(source, target));
  }
}