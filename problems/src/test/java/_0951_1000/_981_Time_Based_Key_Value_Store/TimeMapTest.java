package _0951_1000._981_Time_Based_Key_Value_Store;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeMapTest {

  @Test
  void testOnlineCase1() {
    final TimeMap kv = new TimeMap();
    kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
    assertEquals("bar", kv.get("foo", 1));  // output "bar"
    assertEquals("bar", kv.get("foo", 3));// output "bar" since there is no value corresponding to foo at timestamp 3
    // and timestamp 2, then the only value is at timestamp 1 ie "bar"
    kv.set("foo", "bar2", 4);
    assertEquals("bar2", kv.get("foo", 4)); // output "bar2"
    assertEquals("bar2", kv.get("foo", 5)); //output "bar2"

  }

  @Test
  void testOnlineCase2() {
    final TimeMap kv = new TimeMap();

//    ["TimeMap","set","set","get","get","get","get","get"]
//[[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
//    Output: [null,null,null,"","high","high","low","low"]

    kv.set("love", "high", 10); // store the key "foo" and value "bar" along with timestamp = 1
    kv.set("love", "low", 20); // store the key "foo" and value "bar" along with timestamp = 1
    assertEquals("", kv.get("love", 5));  // output "bar"
    assertEquals("high", kv.get("love", 10));  // output "bar"
    assertEquals("high", kv.get("love", 15));  // output "bar"
    assertEquals("low", kv.get("love", 20));  // output "bar"
    assertEquals("low", kv.get("love", 25));  // output "bar"

  }
}