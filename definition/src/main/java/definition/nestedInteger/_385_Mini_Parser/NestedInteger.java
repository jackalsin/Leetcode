package definition.nestedInteger._385_Mini_Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class NestedInteger {
  private final List<NestedInteger> list = new ArrayList<>();
  private final Integer val;
  private final boolean isInteger;

  // Constructor initializes an empty nested list.
  public NestedInteger() {
    val = 0;
    isInteger = false;
  }

  // Constructor initializes a single integer.
  public NestedInteger(int value) {
    isInteger = true;
    val = value;
  }

  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  public boolean isInteger() {
    return isInteger;
  }

  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  public Integer getInteger() {
    if (isInteger()) {
      return val;
    }
    throw new IllegalStateException("Not an integer");
  }

  // Set this NestedInteger to hold a single integer.
  public void setInteger(int value) {
    throw new UnsupportedOperationException();
  }

  // Set this NestedInteger to hold a nested list and adds a nested integer to it.
  public void add(NestedInteger ni) {
    list.add(ni);
  }

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return null if this NestedInteger holds a single integer
  public List<NestedInteger> getList() {
    return new ArrayList<>(list);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NestedInteger that = (NestedInteger) o;
    return isInteger == that.isInteger &&
        Objects.equals(list, that.list) &&
        Objects.equals(val, that.val);
  }

  @Override
  public int hashCode() {

    return Objects.hash(list, val, isInteger);
  }

  @Override
  public String toString() {
    return "NestedInteger{" +
        "list=" + list +
        ", val=" + val +
        ", isInteger=" + isInteger +
        '}';
  }
}
