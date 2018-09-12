package interviews.linkedin._744_Find_Smallest_Letter_Greater_Than_Target;

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
    final char[] letters = {'c', 'f', 'j'};
    final char target = 'a';
    assertEquals('c', solution.nextGreatestLetter(letters, target));
  }

  @Test
  void testOnlineCase2() {
    final char[] letters = {'c', 'f', 'j'};
    final char target = 'c';
    assertEquals('f', solution.nextGreatestLetter(letters, target));
  }

  @Test
  void testOnlineCase3() {
    final char[] letters = {'c', 'f', 'j'};
    final char target = 'd';
    assertEquals('f', solution.nextGreatestLetter(letters, target));
  }

  @Test
  void testOnlineCase4() {
    final char[] letters = {'c', 'f', 'j'};
    final char target = 'g';
    assertEquals('j', solution.nextGreatestLetter(letters, target));
  }

  @Test
  void testOnlineCase5() {
    final char[] letters = {'c', 'f', 'j'};
    final char target = 'a';
    assertEquals('c', solution.nextGreatestLetter(letters, target));
  }

  @Test
  void testOnlineCase6() {
    final char[] letters = {'c', 'f', 'j'};
    final char target = 'j';
    assertEquals('c', solution.nextGreatestLetter(letters, target));
  }

  @Test
  void testOnlineCase7() {
    final char[] letters = {'c', 'f', 'j'};
    final char target = 'k';
    assertEquals('c', solution.nextGreatestLetter(letters, target));
  }
}