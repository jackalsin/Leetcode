package interviews.hulu.xmlParser;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/5/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String[] input = {
        "<breakfast_menu>",
        "<food>",
        "<name>", "Belgian Waffles", "</name>",
        "<price>", "$5.95", "</price>",
        "<description>",
        "Two of our famous Belgian Waffles with plenty of real maple syrup",
        "</description>",
        "<calories>", "650", "</calories>",
        "</food>",
        "<food>",
        "<name>", "Strawberry Belgian Waffles", "</name>",
        "<price>", "$7.95", "</price>",
        "<description>",
        "Light Belgian waffles covered with strawberries and whipped cream",
        "</description>",
        "<calories>", "900", "</calories>",
        "</food>",
        "</breakfast_menu>",
    };

    final XmlNode expected = new XmlNode("breakfast_menu", new ArrayList<>());
    final XmlNode food1 = new XmlNode("food", new ArrayList<>());
    food1.addChild(new XmlNode("name", "Belgian Waffles"));
    food1.addChild(new XmlNode("price", "$5.95"));
    food1.addChild(new XmlNode("description", "Two of our famous Belgian Waffles with plenty of real maple syrup"));
    food1.addChild(new XmlNode("calories", "650"));
    final XmlNode food2 = new XmlNode("food", new ArrayList<>());
    food2.addChild(new XmlNode("name", "Strawberry Belgian Waffles"));
    food2.addChild(new XmlNode("price", "$7.95"));
    food2.addChild(new XmlNode("description", "Light Belgian waffles covered with strawberries and whipped cream"));
    food2.addChild(new XmlNode("calories", "900"));

    expected.addChild(food1);
    expected.addChild(food2);
    final XmlNode actual = solution.parse(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}