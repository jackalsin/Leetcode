package interviews.tableau.tableToTree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<String> input = List.of(
        "apple M 1",
        "apple M 2",
        "pear M 3",
        "banana L 4",
        "banana M 5"
    ), appleList = List.of(
        "apple",
        "     M",
        "      1",
        "      2"
    ), pearList = List.of(
        "pear",
        "    M",
        "     3"
    ), bananaList = List.of(
        "banana",
        "      L",
        "       4",
        "      M",
        "       5"
    ), actual = solution.transform(input);
    final Set<List<String>> expected = Set.of(
        new ArrayList<>() {{
          addAll(appleList);
          addAll(pearList);
          addAll(bananaList);
        }}, new ArrayList<>() {{
          addAll(appleList);
          addAll(bananaList);
          addAll(pearList);
        }}, new ArrayList<>() {{
          addAll(pearList);
          addAll(appleList);
          addAll(bananaList);
        }}, new ArrayList<>() {{
          addAll(pearList);
          addAll(bananaList);
          addAll(appleList);
        }}, new ArrayList<>() {{
          addAll(bananaList);
          addAll(appleList);
          addAll(pearList);
        }}, new ArrayList<>() {{
          addAll(bananaList);
          addAll(pearList);
          addAll(appleList);
        }}
    );
    assertTrue(expected.contains(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}