package _1301_1350._1348_Tweet_Counts_Per_Frequency;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
class TweetCountsTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(TweetCounts tweetCounts) {
    tweetCounts.recordTweet("tweet3", 0);
    tweetCounts.recordTweet("tweet3", 60);
    tweetCounts.recordTweet("tweet3", 10);                             // All tweets correspond to "tweet3" with
    // recorded times at 0, 10 and 60.
    assertEquals(List.of(2), tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59)); // return [2]. The
    // frequency is per minute (60
    // seconds), so there is one interval of time: 1) [0, 60> - > 2 tweets.
    assertEquals(List.of(2, 1), tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60));
    ; // return [2]. The frequency is per minute (60
    // return [2, 1]. The frequency is per minute
    // (60 seconds), so there are two intervals of time: 1) [0, 60> - > 2 tweets, and 2) [60,61> - > 1 tweet.
    tweetCounts.recordTweet("tweet3", 120);                            // All tweets correspond to "tweet3" with
    // recorded times at 0, 10, 60 and 120.
    assertEquals(List.of(4), tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210));  // return [4]. The
    // frequency is per hour (3600seconds), so there is one interval of }
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(TweetCounts tweetCounts) {
//    ["TweetCounts","recordTweet","recordTweet","recordTweet","recordTweet","recordTweet",
//    "getTweetCountsPerFrequency","getTweetCountsPerFrequency","recordTweet","getTweetCountsPerFrequency",
//    "recordTweet","getTweetCountsPerFrequency","recordTweet"]
//[[],["tweet0",744672961],["tweet1",659657051],["tweet2",820240432],["tweet3",767194152],["tweet4",149762791],
// ["hour","tweet0",820240432,820244034],["minute","tweet4",820240432,820247637],["tweet0",581875081],["day",
// "tweet1",820240432,820245606],["tweet4",510394168],["day","tweet3",581875081,581875873],["tweet4",63128126]]
    tweetCounts.recordTweet("tweet0", 744672961);
    tweetCounts.recordTweet("tweet1", 659657051);
    tweetCounts.recordTweet("tweet2", 820240432);
    tweetCounts.recordTweet("tweet3", 767194152);
    tweetCounts.recordTweet("tweet4", 149762791);
    assertEquals(List.of(0, 0), tweetCounts.getTweetCountsPerFrequency("hour", "tweet0", 820240432, 820244034)); //
  }

  static Stream<TweetCounts> solutionProvider() {
    return Stream.of(
        new TweetCounts()
    );
  }
}