package _1301_1350._1352_Product_of_the_Last_K_Numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/15/2020
 */
class ProductOfNumbersTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(ProductOfNumbers productOfNumbers) {
    productOfNumbers.add(3);        // [3]
    productOfNumbers.add(0);        // [3,0]
    productOfNumbers.add(2);        // [3,0,2]
    productOfNumbers.add(5);        // [3,0,2,5]
    productOfNumbers.add(4);        // [3,0,2,5,4]
    assertEquals(20, productOfNumbers.getProduct(2)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
    assertEquals(40, productOfNumbers.getProduct(3)); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
    assertEquals(0, productOfNumbers.getProduct(4)); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
    productOfNumbers.add(8);        // [3,0,2,5,4,8]
    assertEquals(32, productOfNumbers.getProduct(2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(ProductOfNumbers productOfNumbers) {
    productOfNumbers.add(3);        // [3]
    productOfNumbers.add(1);        // [3,1]
    productOfNumbers.add(2);        // [3,1,2]
    productOfNumbers.add(5);        // [3,1,2,5]
    productOfNumbers.add(4);        // [3,1,2,5,4]
    assertEquals(20, productOfNumbers.getProduct(2)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
    assertEquals(40, productOfNumbers.getProduct(3)); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
    assertEquals(40, productOfNumbers.getProduct(4)); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4
    // = 0
    productOfNumbers.add(8);        // [3,1,2,5,4,8]
    assertEquals(960, productOfNumbers.getProduct(6));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(ProductOfNumbers productOfNumbers) {
//    ["ProductOfNumbers","add","add","add","add","add","add","add","add","getProduct","getProduct","getProduct",
//    "getProduct","add"]
//[ [],                   [2],    [4],[1],    [7],  [4],  [1],  [4],  [2], [3],                 [5],          [6],
// [8],[4]]
    productOfNumbers.add(2);        // [2]
    productOfNumbers.add(4);        // [2, 4]
    productOfNumbers.add(1);        // [2, 4, 1]
    productOfNumbers.add(7);        // [2, 4, 1, 7]
    productOfNumbers.add(4);        // [2, 4, 1, 7, 4]
    productOfNumbers.add(1);        // [2, 4, 1, 7, 4, 1]
    productOfNumbers.add(4);        // [2, 4, 1, 7, 4, 1, 4]
    productOfNumbers.add(2);        // [2, 4, 1, 7, 4, 1, 4, 2]
    assertEquals(224, productOfNumbers.getProduct(6));
  }

  static Stream<ProductOfNumbers> solutionProvider() {
    return Stream.of(
        new ProductOfNumbersI()
    );
  }
}