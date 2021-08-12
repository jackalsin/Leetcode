package google._049_Group_Anagrams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/21/2018.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithOnlineExample() throws Exception {
    String[] inputs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> expect = new ArrayList<>();
    expect.add(Arrays.asList("ate", "eat", "tea"));
    expect.add(Arrays.asList("nat", "tan"));
    expect.add(Arrays.asList("bat"));
    List<List<String>> actual = solution.groupAnagrams(inputs);
    assertEquals(expect.size(), actual.size());
  }

}
