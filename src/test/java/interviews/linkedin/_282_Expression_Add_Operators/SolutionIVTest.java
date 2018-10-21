package interviews.linkedin._282_Expression_Add_Operators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIVTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionIII();
  }

  @Test
  void testOnlineCase1() {
    final String input = "123";
    List<String> actual = solution.addOperators(input, 6);
    Set<String> expect = new HashSet<>() {{
      add("1+2+3");
      add("1*2*3");
    }};
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @Test
  void testOnlineCase2() {
    final String input = "232";
    List<String> actual = solution.addOperators(input, 8);
    Set<String> expect = new HashSet<String>() {{
      add("2+3*2");
      add("2*3+2");
    }};
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @Test
  void testOnlineCase3() {
    final String input = "105";
    List<String> actual = solution.addOperators(input, 5);
    Set<String> expect = new HashSet<String>() {{
      add("1*0+5");
      add("10-5");
    }};
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @Test
  void testOnlineCase4() {
    final String input = "00";
    List<String> actual = solution.addOperators(input, 0);
    Set<String> expect = new HashSet<String>() {{
      add("0+0");
      add("0-0");
      add("0*0");
    }};
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @Test
  void testOnlineCase5() {
    final String input = "3456237490";
    List<String> actual = solution.addOperators(input, 9191);
    Set<String> expect = new HashSet<String>();
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

}