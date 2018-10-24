package interviews.linkedin._012_Integer_to_Roman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionI();
  }

  @Test
  void testIntToRomanWith1() throws Exception {
    assertEquals("I", solution.intToRoman(1));
  }

  @Test
  void testIntToRomanWith2() throws Exception {
    assertEquals("II", solution.intToRoman(2));
  }

  @Test
  void testIntToRomanWith3() throws Exception {
    assertEquals("III", solution.intToRoman(3));
  }

  @Test
  void testIntToRomanWith4() throws Exception {
    assertEquals("IV", solution.intToRoman(4));
  }

  @Test
  void testIntToRomanWith5() throws Exception {
    assertEquals("V", solution.intToRoman(5));
  }

  @Test
  void testIntToRomanWith6() throws Exception {
    assertEquals("VI", solution.intToRoman(6));
  }

  @Test
  void testIntToRomanWith9() throws Exception {
    assertEquals("IX", solution.intToRoman(9));
  }

  @Test
  void testIntToRomanWith10() throws Exception {
    assertEquals("X", solution.intToRoman(10));
  }

  @Test
  void testIntToRomanWith13() throws Exception {
    assertEquals("XIII", solution.intToRoman(13));
  }

  @Test
  void testIntToRomanWith43() throws Exception {
    assertEquals("XLIII", solution.intToRoman(43));
  }

  @Test
  void testIntToRomanWith333() throws Exception {
    assertEquals("CCCXXXIII", solution.intToRoman(333));
  }

  @Test
  void testIntToRomanWith433() throws Exception {
    assertEquals("CDXXXIII", solution.intToRoman(433));
  }

}