package interviews.uber._049_Group_Anagrams;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/6/2020
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithOnlineExample(Solution solution) throws Exception {
    String[] inputs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> expect = new ArrayList<>();
    expect.add(Arrays.asList("ate", "eat", "tea"));
    expect.add(Arrays.asList("nat", "tan"));
    expect.add(Arrays.asList("bat"));
    List<List<String>> actual = solution.groupAnagrams(inputs);
    assertEquals(expect.size(), actual.size());
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}