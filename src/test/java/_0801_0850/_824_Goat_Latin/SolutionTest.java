package _0801_0850._824_Goat_Latin;

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
    final String input = "I speak Goat Latin",
        expected = "Imaa peaksmaaa oatGmaaaa atinLmaaaaa";
    assertEquals(expected, solution.toGoatLatin(input));
  }

  @Test
  void testOnlineCase2() {
    final String input = "The quick brown fox jumped over the lazy dog",
        expected = "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa";
    assertEquals(expected, solution.toGoatLatin(input));
  }
}