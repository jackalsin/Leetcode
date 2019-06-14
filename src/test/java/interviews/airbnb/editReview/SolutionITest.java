package interviews.airbnb.editReview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {

  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
    final Map<String, String> wordsToReplace = Map.of(
        "Airbnb", "business",
        "san francisco", "city"
    );
    final String input = "I booked a house on Airbnb for my trip to San Francisco. It was a lovely experience.",
        expected = "I booked a house on [business]{Airbnb} for my trip to [city]{San Francisco}. It was a lovely experience.";
    assertEquals(expected, solution.getEditedReview(wordsToReplace, input));
  }

  @Test
  void testCommonPrefix() {
    final Map<String, String> wordsToReplace = Map.of(
        "Airbnb", "business",
        "san", "city prefix",
        "san francisco", "city"
    );
    final String input = "I booked a house on Airbnb for my trip to San Francisco. It was a lovely experience.",
        expected = "I booked a house on [business]{Airbnb} for my trip to [city]{San Francisco}. It was a lovely experience.";
    assertEquals(expected, solution.getEditedReview(wordsToReplace, input));
  }


  @Test
  void testLabelIsKey() {
    final Map<String, String> wordsToReplace = Map.of(
        "Airbnb", "business",
        "san francisco", "city",
        "city", "entity"
    );
    final String input = "I booked a house on Airbnb for my trip to San Francisco. It was a lovely experience.",
        expected = "I booked a house on [business]{Airbnb} for my trip to [city]{San Francisco}. It was a lovely experience.";
    assertEquals(expected, solution.getEditedReview(wordsToReplace, input));
  }
}