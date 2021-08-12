package example.greedyAlgorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/10/2017.
 */
public class ActivitySelectionTest {
  private ActivitySelection activitySelection;

  @BeforeEach
  public void setUp() throws Exception {
    activitySelection = new ActivitySelection();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final List<Activity> expected = List.of(new Activity(1, 2), new Activity(3, 4),
        new Activity(5, 7), new Activity(8, 9));
    final Activity[] activities = {new Activity(5, 9), new Activity(1, 2), new Activity(3, 4),
        new Activity(0, 6), new Activity(5, 7), new Activity(8, 9)};
    assertEquals(expected, activitySelection.maxSelection(activities));
  }
}
