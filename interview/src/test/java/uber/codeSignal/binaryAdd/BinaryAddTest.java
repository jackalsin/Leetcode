package uber.codeSignal.binaryAdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/17/2021
 */
class BinaryAddTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<BinaryAdder> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final BinaryAdder solution = solutionClass.getConstructor(String.class).newInstance("0");
    for (int i = 0; i < 100_000; ++i) {
      solution.addOne();
      final int expect = getOneCount(Integer.toBinaryString(i + 1).toCharArray());
      assertEquals(expect, solution.oneCount());
    }
  }

  private static int getOneCount(char[] chars) {
    int res = 0;
    for (final char c : chars) {
      if (c == '1') res++;
    }
    return res;
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        BinaryAdderI.class,
        BinaryAdderStack.class
    );
  }
}