package interviews.linkedin._008_String_to_Integer_atoi;

public interface Solution {
  /**
   * Implement atoi which converts a string to an integer.
   * <p>
   * The function first discards as many whitespace characters as necessary until the first non-whitespace character
   * is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many
   * numerical digits as possible, and interprets them as a numerical value.
   * <p>
   * The string can contain additional characters after those that form the integral number, which are ignored and
   * have no effect on the behavior of this function.
   * <p>
   * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
   * exists because either str is empty or it contains only whitespace characters, no conversion is performed.
   * <p>
   * If no valid conversion could be performed, a zero value is returned.
   *
   * @param str
   * @return
   */
  int myAtoi(String str);

}
