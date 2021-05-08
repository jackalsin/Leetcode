package google.patternFinder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/8/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<Solution> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final String[] patterns = {
        "/api/customer/:customerId", // 0
        "/api/customer/:customerId/order", // 1
        "/api/customer/:customerId/payment", // 2
        "/api/customer/:customerId/payment/:paymentId", // 3
        "/api/product/:productId"}; // 4
    final Solution solution = cacheClass.getConstructor(String[].class).newInstance((Object) patterns);
    assertEquals(2, solution.pattern("/api/customer/123456/payment"));
    assertEquals(1, solution.pattern("/api/customer/123456/order"));
    assertEquals(-1, solution.pattern("/api/customer/123456/o"));
    assertEquals(-1, solution.pattern("/api/customer/123456/or"));
    assertEquals(-1, solution.pattern("/api/customer/123456/ord"));
    assertEquals(-1, solution.pattern("/api/customer/123456/orde"));
    assertEquals(-1, solution.pattern("/api/customer/123456/orders"));
    assertEquals(0, solution.pattern("/api/customer/123456"));
    assertEquals(4, solution.pattern("/api/product/111111"));
    assertEquals(-1, solution.pattern("/api/product/222222/payment"));
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        SolutionI.class
    );
  }
}