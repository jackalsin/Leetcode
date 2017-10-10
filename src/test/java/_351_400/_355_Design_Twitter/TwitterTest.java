package _351_400._355_Design_Twitter;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/10/2017.
 */
public class TwitterTest {

  @Test
  public void testOnlineCase() throws Exception {
    final Twitter twitter = new Twitter();
    twitter.postTweet(1, 5);
    assertEquals(List.of(5), twitter.getNewsFeed(1));
    twitter.follow(1, 2);
    twitter.postTweet(2, 6);
    assertEquals(List.of(6, 5), twitter.getNewsFeed(1));
    twitter.unfollow(1, 2);
    assertEquals(List.of(5), twitter.getNewsFeed(1));
  }

  @Test
  public void testFailedOnDupTweet() throws Exception {
    final Twitter twitter = new Twitter();
    twitter.postTweet(1, 5);
    twitter.follow(1, 1);
    assertEquals(List.of(5), twitter.getNewsFeed(1));
  }

}
