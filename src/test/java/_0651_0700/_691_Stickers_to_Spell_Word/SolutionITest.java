package _0651_0700._691_Stickers_to_Spell_Word;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String input[] = {"notice", "possible"}, target = "basicbasic";
    assertEquals(-1, solution.minStickers(input, target));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String input[] = {"with", "example", "science"}, target = "thehat";
    assertEquals(3, solution.minStickers(input, target));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String input[] = {"these", "guess", "about", "garden", "him"}, target = "atomher";
    assertEquals(3, solution.minStickers(input, target));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String input[] = {"heavy", "claim", "seven", "set", "had", "it", "dead", "jump", "design", "question",
        "sugar", "dress", "any", "special", "ground", "huge", "use", "busy", "prove", "there", "lone", "window",
        "trip", "also", "hot", "choose", "tie", "several", "be", "that", "corn", "after", "excite", "insect", "cat",
        "cook", "glad", "like", "wont", "gray", "especially", "level", "when", "cover", "ocean", "try", "clean",
        "property", "root", "wing"}, target = "travelbell";
    assertEquals(4, solution.minStickers(input, target));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final String input[] = {"claim", "last", "determine", "cry", "bed", "result", "human", "duck", "seem"},
        target = "camereal";
    assertEquals(3, solution.minStickers(input, target));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase6(Solution solution) {
    //                      0         1       2       3         4       5           6       7       8
    final String input[] = {"swim", "love", "father", "shape", "rich", "multiply", "new", "fill", "history"},
        target = "operateform";
    // {o:2, p: 1, r: 2, e: 2, a: 1, t: 1, f: 1, m: 1}
    // love     {o: 1, p: 1, r: 2, e: 2, a: 1, t: 1, f: 1, m: 1}
    // father   {o: 1, p: 1, r: 1,                         m: 1}
    // multiply {o: 1,       r: 1,                             }
    // history
    assertEquals(4, solution.minStickers(input, target));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase7(Solution solution) {
    final String input[] = {"all", "chord", "doctor", "dance", "drive", "ready", "phrase", "skill", "dress", "select"
        , "if", "develop", "space", "broad", "lone", "was", "fight", "how", "window", "place", "has", "plural", "star"
        , "complete", "though", "rub", "practice", "here", "nation", "dark", "job", "observe", "key", "hole", "short"
        , "last", "neck", "oh", "science", "industry", "work", "gun", "rule", "magnet", "stead", "many", "push",
        "tall", "soft", "road"}, target = "thosecontinent";
    assertEquals(4, solution.minStickers(input, target));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new TLESolution(),
        new SolutionI()
    );
  }
}