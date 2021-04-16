package _1551_1600._1600_ThroneInheritance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/15/2021
 */
class ThroneInheritanceITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<ThroneInheritance> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    ThroneInheritance t = solutionClass.getConstructor(String.class).newInstance("king");
    t.birth("king", "andy"); // order: king > andy
    assertEquals(List.of("king", "andy"), t.getInheritanceOrder());
    t.birth("king", "bob"); // order: king > andy > bob
    assertEquals(List.of("king", "andy", "bob"), t.getInheritanceOrder());
    t.birth("king", "catherine"); // order: king > andy > bob > catherine
    assertEquals(List.of("king", "andy", "bob", "catherine"), t.getInheritanceOrder());
    t.birth("andy", "matthew"); // order: king > andy > matthew > bob > catherine
    assertEquals(List.of("king", "andy", "matthew", "bob", "catherine"), t.getInheritanceOrder());
    t.birth("bob", "alex"); // order: king > andy > matthew > bob > alex > catherine
    assertEquals(List.of("king", "andy", "matthew", "bob", "alex", "catherine"), t.getInheritanceOrder());
    t.birth("bob", "asha"); // order: king > andy > matthew > bob > alex > asha > catherine
    assertEquals(List.of("king", "andy", "matthew", "bob", "alex", "asha", "catherine"), t.getInheritanceOrder());
    t.death("bob"); // order: king > andy > matthew > bob > alex > asha > catherine
    assertEquals(List.of("king", "andy", "matthew", "alex", "asha", "catherine"), t.getInheritanceOrder());
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        ThroneInheritanceI.class
    );
  }
}