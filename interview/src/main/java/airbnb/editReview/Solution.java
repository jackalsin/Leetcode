package airbnb.editReview;

import java.util.Map;

public interface Solution {
  /**
   * Input:
   * review="I booked a house on Airbnb for my trip to San Francisco. It was a lovely experience."
   * <p>
   * map={"Airbnb": "business", "san francisco": "city"}
   * <p>
   * Output:
   * "I booked a house on [business]{Airbnb} for my trip to [city]{San Francisco}. It was a lovely experience."
   * <p>
   * 大概题意是这样，对字符串进行处理。
   * 我一上来想的比较简单，说去loop map，在review里面找key并进行替换。国人小哥提示有种情况，某个value可能也是key，
   * 比如说{"business": "industry"}, 如果先替换Airbnb，那就会替换出错。这题感觉需要想到的情况挺多的，我现在能想到的
   * 1. 大小写的问题
   * 2. 如果map里有{"san francisco": "city", "francisco": "name"}.
   * <p>
   * 比方说输入文字是 "I travel to San Francisco" 字典是 {"San Francisco": "City"} 输出是"I travel to [San Francisco](City)"
   * <p>
   * 跟进问题:
   * 1. 如果替换是大小写不敏感的怎么办 比方说字典是 {"san francisco": "City"}
   * 2. 如果替换有多种可能怎么没办 比方说字典是 {"San Francisco": "City"， "San": "City", "Francisco": "City"}
   * 3. 如果标签本身也是关键字怎么办 比方说字典是 {"San Francisco": "City", "City": "Location"}
   *
   * @param wordsToType
   * @param line
   * @return
   */
  String getEditedReview(Map<String, String> wordsToType, final String line);
}
