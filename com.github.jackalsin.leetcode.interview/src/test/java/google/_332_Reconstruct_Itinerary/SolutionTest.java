package google._332_Reconstruct_Itinerary;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/14/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
    final List<String> expected = List.of("JFK", "MUC", "LHR", "SFO", "SJC");
    assertEquals(expected, solution.findItinerary(tickets));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String[][] tickets = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"},
        {"ATL",
        "SFO"}};
    final List<String> expected = List.of("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
    assertEquals(expected, solution.findItinerary(tickets));
  }
}
