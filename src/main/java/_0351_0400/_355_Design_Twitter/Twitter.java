package _0351_0400._355_Design_Twitter;

import java.util.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/9/2017.
 */
public final class Twitter {
  private final Map<Integer, Set<Integer>> following;
  private final Map<Integer, User> idToUsers;
  private static int time = 0;
  private static final int MAX_FEEDS = 10;
  /** Initialize your data structure here. */
  public Twitter() {
    following = new HashMap<>();
    idToUsers = new HashMap<>();
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    idToUsers.putIfAbsent(userId, new User(userId));
    idToUsers.get(userId).tweets.add(new Tweet(time++, tweetId));
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed
   * must be posted by users who the user followed or by the user herself. Tweets must be
   * ordered from most recent to least recent.
   */
  public List<Integer> getNewsFeed(int userId) {
    PriorityQueue<Tweet> allTweets = new PriorityQueue<>(new Comparator<Tweet>() {
      @Override
      public int compare(Tweet t1, Tweet t2) {
        return Integer.compare(t1.time, t2.time);
      }
    });

    if (idToUsers.containsKey(userId)) {
      updateFeedsWithUserId(allTweets, userId);
    }

    Set<Integer> followingIds = following.getOrDefault(userId, new HashSet<>());
    for (int followingId : followingIds) {
      if (followingId != userId) {
        updateFeedsWithUserId(allTweets, followingId);
      }
    }

    LinkedList<Integer> result = new LinkedList<>();
    while (!allTweets.isEmpty()) {
      result.addFirst(allTweets.poll().tweetId);
    }
    return result;
  }

  private void updateFeedsWithUserId(final PriorityQueue<Tweet> allTweets, final int userId) {
    List<Tweet> curUserTweets = idToUsers.getOrDefault(userId, new User(userId)).tweets;
    for (int i = 0; i < MAX_FEEDS && i < curUserTweets.size(); ++i) {
      Tweet tweet = curUserTweets.get(curUserTweets.size() - 1 - i);
      if (allTweets.size() == MAX_FEEDS) {
        if (tweet.time > allTweets.peek().time) {
          allTweets.poll();
          allTweets.add(tweet);
        }
      } else {
        allTweets.add(tweet);
      }
    }
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    following.putIfAbsent(followerId, new HashSet<>());
    following.get(followerId).add(followeeId);
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    following.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
  }

  private static final class User {
    final int userId;
    final List<Tweet> tweets;

    User(int userId) {
      this.userId = userId;
      this.tweets = new ArrayList<>();
    }
  }

  private static final class Tweet {
    final int time;
    final int tweetId;

    public Tweet(int time, int tweetId) {
      this.time = time;
      this.tweetId = tweetId;
    }
  }
}
