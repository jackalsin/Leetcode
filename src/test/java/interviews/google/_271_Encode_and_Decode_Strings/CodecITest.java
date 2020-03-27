package interviews.google._271_Encode_and_Decode_Strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/26/2020
 */
class CodecITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Codec solution) {
    final List<String> input = List.of("a", "", "cdi"),
        actual = solution.decode(solution.encode(input));
    assertEquals(input, actual);
  }

  static Stream<Codec> solutionProvider() {
    return Stream.of(
        new CodecI()
    );
  }
}