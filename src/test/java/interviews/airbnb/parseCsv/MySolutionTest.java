package interviews.airbnb.parseCsv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MySolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new MySolution();
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
}