package interviews.airbnb.parseCsv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShenQiuSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new ShenQiuSolution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals("John|Smith|john.smith@gmail.com|Los Angeles|1",
        solution.parseCSV("John,Smith,john.smith@gmail.com,Los Angeles,1"));
  }

  @Test
  void testOnlineCase2() {
    assertEquals("Jane|Roberts|janer@msn.com|San Francisco, CA|0",
        solution.parseCSV("Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0"));
  }

  @Test
  void testOnlineCase3() {
    assertEquals("Alexandra \"Alex\"|Menendez|alex.menendez@gmail.com|Miami|1",
        solution.parseCSV("\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1"));
  }

  @Test
  void testOnlineCase4() {
    assertEquals("\"Alexandra Alex\"",
        solution.parseCSV("\"\"\"Alexandra Alex\"\"\""));
  }

  @Test
  void testOnlineCase5() {
    assertEquals("Alexandra\t\"Alex\"|Menendez|alex.menendez@gmail.com|Miami|1\t\"Alexandra\tAlex\"",
        solution.parseCSV("\"Alexandra\t\"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1\t\"\"\"Alexandra\tAlex\"\"\""));
  }

  @Test
  void testOnlineCase6() {
    final String input = "\"John \"\"Da Man\"\"\",Doe, 120 any st.",
        expected = "John \"Da Man\"|Doe| 120 any st.";
    assertEquals(expected, solution.parseCSV(input));
  }

  /**
   * 其实是这样的，有多个quote的时候，原来的每一个quote一定要有一个quote来escape它
   */
  @Test
  void testOnlineCase7() {
    final String input = "\"John \"\"Da Man\"\"\"\"\",Doe, 120 any st.",
        expected = "John \"Da Man\"\"|Doe| 120 any st.";
    assertEquals(expected, solution.parseCSV(input));
  }
}