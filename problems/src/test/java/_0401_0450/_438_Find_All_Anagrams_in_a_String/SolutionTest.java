package _0401_0450._438_Find_All_Anagrams_in_a_String;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
//    solution = new SampleSolution();
//    solution = new MySolution();
    solution = new SecondTry();
  }

  @Test
  void testOnlineCase1() {
    final String s = "cbaebabacd", p = "abc";
    assertEquals(List.of(0, 6), solution.findAnagrams(s, p));
  }

  @Test
  void testOnlineCase2() {
    final String s = "abab", p = "ab";
    assertEquals(List.of(0, 1, 2), solution.findAnagrams(s, p));
  }

  @Test
  void testOnlineCase3() {
    final String s = "cabaebabacdacba", p = "abca";
    assertEquals(List.of(0, 6, 11), solution.findAnagrams(s, p));
  }

}