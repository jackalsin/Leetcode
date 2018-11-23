package _0401_0450._411_Minimum_Unique_Word_Abbreviation;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new BitMapSolution();
//    solution = new BruteForceSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String target = "apple";
    final String[] dictionary = {"blade"};
    final String expected = "a4";
    assertEquals(expected, solution.minAbbreviation(target, dictionary));

  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String target = "apple";
    final String[] dictionary = {"plain", "amber", "blade"};
    final Set<String> expected = Set.of("1p3", "ap3", "a3e", "2p2", "3le", "3l1");
    assertTrue(expected.contains(solution.minAbbreviation(target, dictionary)));

  }

  @Test
  public void testTLECase() throws Exception {
    final String target = "apple";
    final String[] dictionary = {"kkkk", "blade"};
    solution.minAbbreviation(target, dictionary);
  }

  @Test
  public void testMemoryExceedLimit() throws Exception {
    final String target = "usaandchinaarefriends";
    final String[] dictionary = {};
    assertEquals("21", solution.minAbbreviation(target, dictionary));
  }

  @Test
  public void testTLECase2() throws Exception {
    final String target = "internationalize";
    System.out.println("xnternationalize".length());
    final String[] dictionary = {
        "xnternationalize",
        "ixternationalize",
        "inxernationalize",
        "intxrnationalize",
        "intexnationalize",
        "interxationalize",
        "internxtionalize",
        "internaxionalize",
        "internatxonalize",
        "internatixnalize",
        "internatioxalize",
        "internationxlize",
        "internationaxize",
        "internationalxze",
        "internationalixe",
        "internationalizx"
    };
    solution.minAbbreviation(target, dictionary);
//    assertEquals(, solution.minAbbreviation(target, dictionary));
  }


  // ------------- help method test ---------
  @Test
  public void testMaskAppleWithBpple() throws Exception {
    final String target = "apple", str = "bpple";
    assertEquals(0b10000, BitMapSolution.toMask(str, target));
  }

  @Test
  public void test01001AndAbcde() throws Exception {
    final String target = "abcde";
    final int mask = 0b01001;
    assertEquals("1b2e", BitMapSolution.toWord(target, mask));
  }

  @Test
  public void test01000AndAbcde() throws Exception {
    final String target = "abcde";
    final int mask = 0b01000;
    assertEquals("1b3", BitMapSolution.toWord(target, mask));
  }

  @Test
  public void testAbbrLen() throws Exception {
    assertEquals(4, BitMapSolution.abbrLen(0b01001, 5));
    // the length of abbreviation: if there is a 2-digit number in the string, that part still counts one.
    assertEquals("1a11a2a1".length() - 1, BitMapSolution.abbrLen(0b01_0000_0000_0001_0010, 16 + 2));
  }

}
