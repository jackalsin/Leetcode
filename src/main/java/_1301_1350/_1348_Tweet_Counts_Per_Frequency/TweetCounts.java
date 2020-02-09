package _1301_1350._1348_Tweet_Counts_Per_Frequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
public class TweetCounts {
  private static final String DAY = "day",
      MIN = "minute", HOUR = "hour";
  private final Map<String, TreeSet<Integer>> tweet = new HashMap<>();

  public void recordTweet(String tweetName, int time) {
    tweet.computeIfAbsent(tweetName, k -> new TreeSet<>()).add(time);
  }

  public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
    final long step;
    if (freq.equals(MIN)) {
      step = 60;
    } else if (freq.equals(HOUR)) {
      step = 3600;
    } else {
      step = 3600 * 24;
    }
    if (!tweet.containsKey(tweetName)) {
      return new ArrayList<>();
    }
    final TreeSet<Integer> timeSet = tweet.get(tweetName);
    final List<Integer> result = new ArrayList<>();
    for (int i = startTime; i <= endTime; i += step) {
      result.add(timeSet.subSet(i, true, (int) Math.min(i + step, endTime + 1), false).size());
    }
    return result;
  }

}
